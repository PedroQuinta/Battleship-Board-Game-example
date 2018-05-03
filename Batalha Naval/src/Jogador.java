
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PedroQuinta
 */
public class Jogador {

    private Tabuleiro proprio;
    private int[] numeroDePecas = new int[]{3, 2, 1, 1, 1};
    private ArrayList<Peca> listaDeBarcos;
    private int shots = 0;
    private String name = "";
    private int[] coordenadasDeTiro = new int[]{-1, -1};
    private boolean coordRepetidas = false;
    private int contador = 4;
    private int[] firstShot = new int[]{-1, -1};

    public Jogador() {
        this.proprio = new Tabuleiro();
        listaDeBarcos = new ArrayList<>();
        Peca[] boats = new Peca[]{new Submarino(0, 0), new Navio(0, 0), new Galeao(0, 0), new Fragata(0, 0), new PortaAvioes(0, 0)};
        for (int i = 0; i < numeroDePecas.length; i++) {
            listaDeBarcos.add(boats[i]);
        }

    }

    /**
     * Devolve o campo proprio do tipo Tabuleiro.
     *
     * @return Tabuleiro proprio.
     */
    public Tabuleiro getProprio() {
        return proprio;
    }

    /**
     * Retorna o campo shots que é um inteiro que representa o número de tiros.
     *
     * @return Um inteiro para guardar o número de tiros com sucesso.
     */
    public int getShots() {
        return shots;
    }

    public boolean isCoordRepetidas() {
        return coordRepetidas;
    }

    /**
     * Lê um inteiro que irá conter o número de tiros certeiros já efetuado pelo
     * jogador.
     *
     * @param shots
     */
    public void setShots(int shots) {
        this.shots = shots;
    }

    /**
     * Retorna o campo nome do jogador.
     *
     * @return Uma string para guardar o campo nome.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Lê uma String e atualiza o campo nome com essa String.
     *
     * @param name Uma String para guardar o nome que queremos modificar.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o campo coleção de objetos do tipo Peca.
     *
     * @return Um ArrayList listaDeBarcos que contém a informação dos meus
     * barcos e de como estão inicializados.
     */
    public ArrayList<Peca> getListaDeBarcos() {
        return listaDeBarcos;
    }

    /**
     * Retorna um array de inteiros que representa respetivamente a quantidade
     * de cada tipo de barcos que temos à disposição para colocar. [submarino
     * navio galeao fragata portaAvioes]
     *
     * @return Um array de inteiros
     */
    public int[] getNumeroDePecas() {
        return numeroDePecas;
    }

    /**
     * Joga no player ( o player que passa como parâmetro), simulando o jogo de
     * tabuleiro real, regista no tabuleiro principal (tabuleiro onde os barcos
     * estão posicionados) o X caso seja tiro ou a O caso água, verifica se a
     * jogada foi tiro ou nao, no tabuleiro de barcos do player, se sim, regista
     * no tabuleiro de registo de quem chama o método e soma um no contador, se
     * o barco tiver ido ao fundo, imprime mensagem a dizer qual é que foi esse
     * barco.
     *
     * @param player Um objeto do tipo Jogador para se saber sobre quem está a
     * ser feita a jogada.
     * @param linha Um inteiro para me guardar a coordenada correspondente à
     * linha.
     * @param coluna Um inteiro para me guardar a coordenada correspondente à
     * coluna.
     */
    public void jogada(Jogador player, int linha, int coluna) {

        if (player.getProprio().getTabDeBarcos(linha, coluna) != null) {
            proprio.setTabRegistoTiro(linha, coluna);
            player.getProprio().setTabPrincipal(linha, coluna);
            System.out.println("TIRO");
            shots++;
            player.getProprio().getTabDeBarcos(linha, coluna).tiro();
            if (player.getProprio().getTabDeBarcos(linha, coluna).foiAoFundo()) {
                System.out.println("Barco de dimensão " + player.getProprio().getTabDeBarcos(linha, coluna).getComprimento() + " foi ao fundo.");
                player.getProprio().getTabDeBarcos(linha, coluna).setHits(0);
            }
        } else {
            player.getProprio().setTabPrincipal(linha, coluna);
            proprio.setTabRegistoAgua(linha, coluna);
            System.out.println("água");
        }

    }

    /**
     * Lê linha e coluna e retorna true se no tabuleiro de registo nessa
     * coordenada estiver água.
     *
     * @param linha
     * @param coluna
     * @return Um booleano para me validar.
     */
    public boolean verificaRegisto(int linha, int coluna) {
        return proprio.getTabRegisto(linha, coluna) == '~';
    }

    /**
     * Recebe um barco e chama o método de desenhaPeca.
     *
     * @param barco Um barco para sabermos qual estamos a desenhar.
     * @return Um booleano caso desenhar seja possível.
     */
    public boolean adicionaPecas(Peca barco) {
        return proprio.desenhaPeca(barco);
    }

    /**
     * Recebe um objeto do tipo jogador para saber sobre quem se está a jogar.
     * Gera um par de coordenadas entre 0 e 9 e faz verificação se houve tiro
     * certeiro ou não. Se sim incrementa o campo shots e informa o barco do
     * jogador player que este sofreu um tiro.
     *
     * @param player
     * @return Um booleano para guardar true quando as coordenadas geradas são
     * válidas.
     */
    public boolean playRandom(Jogador player) {
        int linha = ThreadLocalRandom.current().nextInt(0, 10);
        int coluna = ThreadLocalRandom.current().nextInt(0, 10);
        linha = 6;
        coluna = 4;
        if (verificaRegisto(linha, coluna)) {
            if (player.getProprio().getTabDeBarcos(linha, coluna) != null) {
                proprio.setTabRegistoTiro(linha, coluna);
                player.getProprio().setTabPrincipal(linha, coluna);
                shots++;
                player.getProprio().getTabDeBarcos(linha, coluna).tiro();
                System.out.print("(" + (linha + 1) + "," + coluna + ")" + " ");
                System.out.println();
                if (!player.getProprio().getTabDeBarcos(linha, coluna).foiAoFundo()) {
                    coordenadasDeTiro[0] = linha;
                    coordenadasDeTiro[1] = coluna;
                    firstShot[0] = linha;
                    firstShot[1] = coluna;
                    return true;
                } else {
                    System.out.println("O barco de dimensão " + player.getProprio().getTabDeBarcos(linha, coluna).getComprimento() + " ao fundo.");
                }

            } else {
                proprio.setTabRegistoAgua(linha, coluna);
                player.getProprio().setTabPrincipal(linha, coluna);
                System.out.print("(" + (linha + 1) + "," + coluna + ")" + " ");
                System.out.println();
            }
            coordRepetidas = false;
        } else {
            coordRepetidas = true;
        }
        return false;
    }

    public boolean playAI(Jogador player) {
        int[][] coordenadas = new int[][]{{coordenadasDeTiro[0] + 1, coordenadasDeTiro[1]}, {coordenadasDeTiro[0], coordenadasDeTiro[1] + 1}, {coordenadasDeTiro[0] - 1, coordenadasDeTiro[1]}, {coordenadasDeTiro[0], coordenadasDeTiro[1] - 1}};
        for (int[] coord : coordenadas) {
            
            if (verificaRegisto(coord[0], coord[1])) {
                System.out.println("entrou aqui");
                if (player.getProprio().getTabDeBarcos(coord[0], coord[1]) != null) {
                    proprio.setTabRegistoTiro(coord[0], coord[1]);
                    player.getProprio().setTabPrincipal(coord[0], coord[1]);
                    coordenadasDeTiro[0] = coord[0];
                    coordenadasDeTiro[1] = coord[1];
                    System.out.println("coordenadas de tiro :" +"("+coordenadasDeTiro[0]+","+coordenadasDeTiro[1]+")");
                    contador = 4;
                    shots++;
                    player.getProprio().getTabDeBarcos(coord[0], coord[1]).tiro();
                    System.out.print("(" + (coord[0] + 1) + "," + coord[1] + ")" + " ");
                    if (player.getProprio().getTabDeBarcos(coord[0], coord[1]).foiAoFundo()) {
                        registaInvolucro(player, coord[0], coord[1]);
                        System.out.println("O barco de dimensão " + player.getProprio().getTabDeBarcos(coord[0], coord[1]).getComprimento() + " ao fundo.");
                        return false;
                    }
                    return true;
                } else {
                    proprio.setTabRegistoAgua(coord[0], coord[1]);
                    player.getProprio().setTabPrincipal(coord[0], coord[1]);
                    System.out.print("(" + (coord[0] + 1) + "," + coord[1] + ")" + " ");
                    return true;
                }
            } else {
                contador--;
            }            
        }
        System.out.println(contador);
        //nao tem tiros a dar nestas 4 coordenadas. Quer dizer que está numa extremidade do barco
        //e é necessário procurar o outro extremo
        if (contador <= 0) {
            System.out.println("entrou no AI extremidade");
            for (int[] coord : coordenadas) {
                if (player.getProprio().getTabDeBarcos(coord[0], coord[1]) != null) {
                    System.out.println("entrou no AI extremidade");
                    //ver para onde está o barco
                    //o resto do barco está em (coordenadasDeTiro[0] - coord[0]), ( coordenadasDeTiro[1] - coord[1])
                    int dx = Math.abs(-coord[0] + firstShot[0]);
                    int dy = Math.abs(-coord[1] + firstShot[1]);
                    System.out.println("coordenadas de tiro :" +"("+coord[0]+","+coord[1]+")");
                    System.out.println("coordenadas first shot:" +"("+firstShot[0]+","+firstShot[1]+")");
                    System.out.println("dx = "+dx+", dy = "+dy);
                    int dist;
                    for (dist = 0; !verificaRegisto(firstShot[0] + dist * dx, firstShot[1] + dist * dy); dist++);
                    System.out.println("***********passou o for");
                    proprio.setTabRegistoTiro(firstShot[0] + dist * dx, firstShot[1] + dist * dy);
                    player.getProprio().setTabPrincipal(firstShot[0] + dist * dx, firstShot[1] + dist * dy);
                    shots++;
                    player.getProprio().getTabDeBarcos(firstShot[0] + dist * dx, firstShot[1] + dist * dy).tiro();
                    System.out.print("(" + (firstShot[0] + dist * dx + 1) + "," + firstShot[1] + dist * dy + ")" + " ");
                    if (player.getProprio().getTabDeBarcos(firstShot[0] + dist * dx, firstShot[1] + dist * dy).foiAoFundo()) {
                        registaInvolucro(player, firstShot[0] + dist * dx, firstShot[1] + dist * dy);
                        return false;
                    }
                } else {
                    proprio.setTabRegistoAgua(coord[0], coord[1]);
                    player.getProprio().setTabPrincipal(coord[0], coord[1]);
                }

            }
        }

        return true;
    }

    public boolean registaInvolucro(Jogador player, int linha, int coluna) {
        int limiteX = player.getProprio().getTabDeBarcos(linha, coluna).getDimensoes()[0];
        int limiteY = player.getProprio().getTabDeBarcos(linha, coluna).getDimensoes()[1];

        for (int i = linha, barcoX = 0; barcoX < limiteX; i++, barcoX++) {
            for (int j = coluna, barcoY = 0; barcoY < limiteY; j++, barcoY++) {
                if ((i >= proprio.getComprimento() || j >= proprio.getComprimento())) {
                    return false;
                }
                if (player.getProprio().getTabDeBarcos(linha, coluna).getForma(barcoX, barcoY) && player.getProprio().validateSurrounding(i, j)) {
                    player.getProprio().setTabRegistoTiro(i, j);
                }

            }

        }
        return true;
    }
}
