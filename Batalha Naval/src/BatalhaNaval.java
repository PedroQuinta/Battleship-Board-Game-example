
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroQuinta
 */
public class BatalhaNaval {

    private static Jogador jogador1 = new Jogador();
    private static Jogador jogador2 = new Jogador();
    private static Jogador computador = new Jogador();
    private static int maximumShots = 19;
    private static int numDeJogadasPorTurno = 3;
    private static boolean flag = true;
    private static boolean barcoPendente = false;

    /**
     * Imprime as instruções do jogo. Espera que o utilizador pressione uma
     * tecla para regressar ao menu.
     */
    public static void mostraInstrucoes() {
        out.println("1 - Cada jogador começa por construir duas grelhas quadriculadas iguais de 10x10 quadrados.\n"
                + "2 - Numerar as linhas e atribuir uma letra a cada coluna.\n"
                + "3 - Posicionar barcos de forma a que não haja qualquer contacto entre eles.\n"
                + "4 - Cada jogador tem direito a 3 jogadas por turno.\n"
                + "5 - Sempre que houver um tiro certeiro, é imprimida uma mensagem a informar que houve tiro e mais nada.\n"
                + "6 - Apenas quando o barco vai ao fundo pode-se informar o adversário de que barco se trata.");
    }

    /**
     * Utilizador dá as coordenadas da posição inicial, onde irá ser colocado o
     * seu barco no tabuleiro, assim como a orientação desejada. Retorna um
     * conjunto de inteiros.
     *
     *
     * @param numero Para se saber o tamanho da peça que se está a colocar.
     * @return Um array de inteiros. Onde contém os valores da coordenada
     * inicial e direção.
     */
    public static int[] userCoord(int numero) {
        int posX = 0;
        int posY = 0;
        int y;
        int direcao = 0;
        int[] info = new int[3];

        System.out.printf("Peça tamanho %s", numero);
        System.out.println();
        if (numero > 1) {
            direcao = exceptionsInt(1);
        }
        System.out.println("Insira as coordenadas da posição inicial:");
        posX = exceptionsInt(0);
        y = exceptionsString().toUpperCase().charAt(0);
        posY = y - 'A';
        info[0] = direcao;
        info[1] = posX;
        info[2] = posY;

        return info;
    }

    /**
     * Pede ao utilizador as coordenadas de cada tiro. Retorna um array de
     * inteiros.
     *
     * @return Um array de inteiros com as coordenadas do tiro.
     */
    public static int[] userCoordPlays() {
        int linha = -1;
        int coluna = -1;
        int y;
        int[] info = new int[2];
        System.out.println("Insira as coordenadas dos tiros (3)");
        linha = exceptionsInt(0);
        y = exceptionsString().toUpperCase().charAt(0);
        coluna = y - 'A';
        info[0] = linha;
        info[1] = coluna;
        return info;
    }

    /**
     * Insere as peças de cada jogador mediante a quantidade de barcos
     * existente. Recebe as coordenadas do utilizador e insere-as no tabuleiro
     * principal.
     *
     * @param jogador Um jogador para saber quem está a posicionar.
     */
    public static void inserePecas(Jogador jogador) {
        /*
        for (int i = 0; i < jogador.getListaDeBarcos().size(); i++) {
            for (int j = 0; j < jogador.getNumeroDePecas()[i]; j++) {
                do {
                    int[] coord = userCoord(i + 1);
                    jogador.getListaDeBarcos().get(i).setPosicaoX(coord[1]);
                    jogador.getListaDeBarcos().get(i).setPosicaoY(coord[2]);
                    jogador.getListaDeBarcos().get(i).setRotacoes(coord[0]);
                    jogador.getListaDeBarcos().get(i).rotateMatrix();
                } while (!jogador.adicionaPecas(jogador.getListaDeBarcos().get(i)));
                jogador.getProprio().mostraTab(jogador.toString());
            }
        }*/
        
        jogador.getListaDeBarcos().get(0).setPosicaoX(0);
        jogador.getListaDeBarcos().get(0).setPosicaoY(0);
        jogador.getListaDeBarcos().get(0).setRotacoes(0);
        jogador.getListaDeBarcos().get(0).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(0));
        jogador.getListaDeBarcos().get(0).setPosicaoX(0);
        jogador.getListaDeBarcos().get(0).setPosicaoY(9);
        jogador.getListaDeBarcos().get(0).setRotacoes(0);
        jogador.getListaDeBarcos().get(0).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(0));
        jogador.getListaDeBarcos().get(0).setPosicaoX(9);
        jogador.getListaDeBarcos().get(0).setPosicaoY(9);
        jogador.getListaDeBarcos().get(0).setRotacoes(0);
        jogador.getListaDeBarcos().get(0).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(0));
        jogador.getListaDeBarcos().get(1).setPosicaoX(0);
        jogador.getListaDeBarcos().get(1).setPosicaoY(2);
        jogador.getListaDeBarcos().get(1).setRotacoes(0);
        jogador.getListaDeBarcos().get(1).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(1));
        jogador.getListaDeBarcos().get(1).setPosicaoX(0);
        jogador.getListaDeBarcos().get(1).setPosicaoY(5);
        jogador.getListaDeBarcos().get(1).setRotacoes(1);
        jogador.getListaDeBarcos().get(1).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(1));
        jogador.getListaDeBarcos().get(2).setPosicaoX(2);
        jogador.getListaDeBarcos().get(2).setPosicaoY(0);
        jogador.getListaDeBarcos().get(2).setRotacoes(0);
        jogador.getListaDeBarcos().get(2).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(2));
        jogador.getListaDeBarcos().get(3).setPosicaoX(5);
        jogador.getListaDeBarcos().get(3).setPosicaoY(4);
        jogador.getListaDeBarcos().get(3).setRotacoes(1);
        jogador.getListaDeBarcos().get(3).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(3));
        jogador.getListaDeBarcos().get(4).setPosicaoX(5);
        jogador.getListaDeBarcos().get(4).setPosicaoY(7);
        jogador.getListaDeBarcos().get(4).setRotacoes(0);
        jogador.getListaDeBarcos().get(4).rotateMatrix();
        jogador.adicionaPecas(jogador.getListaDeBarcos().get(4));

    }

    /**
     * Insere as peças do computador no tabuleiro, este difere do usado para o
     * jogador humano, pois todas as coordenadas são geradas de forma aleatória.
     *
     * @param computador Um computador do tipo Jogador para termos acesso às
     * Pecas dele e aos tabuleiros.
     */
    public static void inserePecasRandom(Jogador computador) {

        for (int i = 0; i < computador.getListaDeBarcos().size(); i++) {
            for (int j = 0; j < computador.getNumeroDePecas()[i]; j++) {
                do {
                    int posX = randomGen(0, 10);
                    int posY = randomGen(0, 10);
                    int direcao = randomGen(0, 2);
                    computador.getListaDeBarcos().get(i).setPosicaoX(posX);
                    computador.getListaDeBarcos().get(i).setPosicaoY(posY);
                    computador.getListaDeBarcos().get(i).setRotacoes(direcao);
                    computador.getListaDeBarcos().get(i).rotateMatrix();
                } while (!computador.adicionaPecas(computador.getListaDeBarcos().get(i)));

            }
        }
    }

    /**
     * Condensa a inserção e posicionamento das peças dos jogadores nos
     * tabuleiros, se tudo posicionado com sucesso imprime mensagem.
     *
     * @param jogador Um objeto do tipo jogador para sabermos que tipo de método
     * de inserção usar.
     */
    public static void positioningPlayer(Jogador jogador) {
        if (!jogador.equals(computador)) {
            jogador.getProprio().mostraTab(jogador.toString());
            inserePecas(jogador);
            System.out.println("Tabuleiro preenchido com sucesso!!");
            //jogador.getProprio().clearScreen();
        } else {
            inserePecasRandom(jogador);
            //jogador.getProprio().mostraTab(jogador.toString());
        }
    }

    /**
     * Condensa os método de jogada de cada jogador, valida se coordenadas dadas
     * pelo utilizador ou geradas random, não são repetidas e se não forem o
     * jogador faz uma jogada(Jogador player, int linha, int coluna), ou o
     * computador faz playRandom(Jogador player). Ao invocar este método deve-se
     * interpretar que o jogador1 está a fazer uma jogada sobre o jogador2.
     *
     * @param jogador1 Um objeto jogador1 para saber quem está a fazer a jogada.
     * @param jogador2 Um objeto jogador2 para sabermos sobre quem se está a
     * jogar.
     */
    public static void playingPlayerVsPlayer(Jogador jogador1, Jogador jogador2) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numDeJogadasPorTurno; i++) {
            if (!jogador1.equals(computador)) {
                int[] coord = userCoordPlays();
                if (jogador1.getProprio().getTabRegisto(coord[0], coord[1]) == '~') {
                    jogador1.jogada(jogador2, coord[0], coord[1]);
                    jogador1.getProprio().mostraTabRegisto(jogador1.toString());
                }
                sc.nextLine();
            } else {
                if (!barcoPendente && !jogador1.isCoordRepetidas()) {
                    barcoPendente = jogador1.playRandom(jogador2);
                    System.out.println("passouno random");
                } else if (jogador1.isCoordRepetidas()) {
                    i--;
                } else {
                    barcoPendente = jogador1.playAI(jogador2);
                    System.out.println("jogada :" + i);
                }
            }
        }
        if (jogador1.getShots() == maximumShots) {
            System.out.printf("O VENCEDOR É O %s", jogador1.toString());
            System.out.println();
            System.out.println();
            flag = false;
            return;
        }

    }

    /**
     * Lê um número e se for zero faz as exceções para a coordenada
     * correspondente à linha, apenas saindo caso a coordenada seja válida. Se
     * for diferente de zero faz o mesmo para a coordenada correspondente à
     * direção
     *
     * @param numero Um número inteiro para distinguir quais dos processos o
     * método deve executar.
     * @return Um inteiro que servirá de linha ou de numero de rotações.
     */
    public static int exceptionsInt(int numero) {
        int linha = -1;
        Scanner sc = new Scanner(System.in);

        if (numero == 0) {
            do {
                try {
                    System.out.print("Escolha uma linha (1-10):");
                    linha = (sc.nextInt()) - 1;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor insira um apenas números inteiros.");
                    System.out.println(sc.next() + " não é um input válido.");
                }

            } while (!(linha >= 0 && linha <= 9));
        } else {
            do {
                try {
                    System.out.print("Número de rotações(0 - 0º; 1 - 90º; 2 - 180º; 3 - 270º):");
                    linha = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Por favor insira um apenas números inteiros.");
                    System.out.println(sc.next() + " não é um input válido.");
                }

            } while (!(linha >= 0 && linha <= 4));
        }
        return linha;
    }

    /**
     * Lida com as execeções relativas à coordenada correspondente à coluna e
     * que se insere como sendo letras. Retorna uma string já validada.
     *
     * @return Uma String para retornar e ser convertida em inteiro.
     */
    public static String exceptionsString() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        String[] texto = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        do {
            try {
                System.out.print("Escolha uma coluna (A-J):");
                op = sc.nextLine();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Input inválido");
            }
        } while (!(Arrays.asList(texto).contains(op.toUpperCase())));
        return op;
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        jogador1.setName("Jogador A");
        jogador2.setName("Jogador B");
        computador.setName("Computador");
        String op = "";
        do {
            out.println("Batalha Naval:");
            out.println("I - Instruções");
            out.println("P - jogar contra outra Pessoa");
            out.println("C - jogar contra Computador");
            out.println("S - Sair");
            out.print("\n");

            op = sc.nextLine();

            switch (op.toUpperCase()) {
                case "I":
                    mostraInstrucoes();
                    sc.nextLine();
                    break;
                case "P":

                    //jogador1
                    //POSICIONAMENTO JOGADOR 1:
                    positioningPlayer(jogador1);
                    //jogador2
                    //POSICIONAMENTO JOGADOR 2:
                    positioningPlayer(jogador2);

                    System.out.println("*****************Posicionamento concluido. Let's Play!!! *****************");
                    System.out.println();
                    sc.nextLine();

                    int aux = randomGen(0, 2);

                    while (flag) {
                        if (aux % 2 == 0) {
                            System.out.printf("Turno do %s", jogador1.toString());
                            System.out.println();
                            jogador1.getProprio().mostraTab(jogador1.toString());
                            jogador1.getProprio().mostraTabRegisto(jogador1.toString());
                            playingPlayerVsPlayer(jogador1, jogador2);
                        } else {
                            System.out.printf("Turno do %s", jogador2.toString());
                            System.out.println();
                            jogador2.getProprio().mostraTab(jogador2.toString());
                            jogador2.getProprio().mostraTabRegisto(jogador2.toString());
                            playingPlayerVsPlayer(jogador2, jogador1);
                        }
                        aux++;
                    }

                    return;
                case "C":
                    //jogador1
                    //POSICIONAMENTO JOGADOR 1:              
                    positioningPlayer(jogador1);
                    //gravaJogoJogador(jogador1.toString().concat(".txt"), jogador1);
                    sc.nextLine();
                    //Computador
                    //POSICIONAMENTO computador:
                    positioningPlayer(computador);

                    System.out.println("*****************Posicionamento concluido. Let's Play!!! *****************");
                    int aux2 = randomGen(0, 2);

                    while (flag) {
                        if (aux2 % 2 == 0) {
                            System.out.printf("Turno do %s", jogador1.toString());
                            System.out.println();
                            jogador1.getProprio().mostraTab(jogador1.toString());
                            jogador1.getProprio().mostraTabRegisto(jogador1.toString());
                            playingPlayerVsPlayer(jogador1, computador);
                        } else {
                            System.out.println("Turno do Computador");
                            playingPlayerVsPlayer(computador, jogador1);
                        }
                        aux2++;
                    }
                    flag = true;
                    break;
                case "S":
                    out.println("A sair ...");
                    break;
                default:
                    System.out.println(op + " não é uma operação válida.");
            }

        } while (!op.toUpperCase()
                .equals("S"));

    }

    /**
     * Gera um número aleatório entre x e y, o intervalo é aberto [x,y[ o que
     * significa que se queremos um número mesmo com x e y incluídos temos que
     * fazer entre x e y+1. Retorna um número inteiro nas condições descritas
     * acima.
     *
     * @param x Um inteiro para funcionar de mínimo.
     * @param y Um inteiro para funcionar de máximo.
     * @return Um número inteiro
     */
    public static int randomGen(int x, int y) {
        int rand;

        rand = ThreadLocalRandom.current().nextInt(x, y);
        return rand;
    }

    /**
     * Lê uma String que irá guardar o nome do ficheiro a gravar e lê também um
     * objeto do tipo jogador. Grava um ficheiro com os conteúdos do tabuleiro
     * de registo e do tabuleiro principal, cada caracter separado por vírgula.
     *
     * @param caminho Uma String para servir de nome de ficheiro a gravar.
     * @param player Um objeto do tipo Jogador para sabermos a quem pertence os
     * tabuleiros gravados.
     */
    public static void gravaJogoJogador(String caminho, Jogador player) {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(caminho);
            bw = new BufferedWriter(fw);

            bw.write(String.valueOf(player.getProprio().getComprimento())); // gravar o tamanho dos tabuleiros
            bw.newLine(); // nova linha

            bw.write("Tabuleiro de Registo do " + player.toString());
            bw.newLine();
            for (int i = 0; i < player.getProprio().getComprimento(); i++) {
                for (int j = 0; j < player.getProprio().getComprimento(); j++) {
                    bw.write(player.getProprio().getTabRegisto(i, j));

                    if (j < player.getProprio().getComprimento() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }

            bw.newLine();
            bw.write("Tabuleiro Principal do " + player.toString());
            bw.newLine();
            for (int i = 0; i < player.getProprio().getComprimento(); i++) {
                for (int j = 0; j < player.getProprio().getComprimento(); j++) {
                    bw.write(player.getProprio().getTabPrincipal(i, j));

                    if (j < player.getProprio().getComprimento() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(BatalhaNaval.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lê uma String que irá verificar se é igual ao nome do ficheiro gravado e
     * lê também um objeto do tipo jogador. Lê um ficheiro com os conteúdos do
     * tabuleiro de registo e do tabuleiro principal e modifica os respetivos
     * tabuleiro para o estado previamente gravado no ficheiro.
     *
     * @param caminho Uma String para validar se encontrámos o ficheiro certo.
     * @param player Um objeto do tipo Jogador para sabermos a quem pertence os
     * tabuleiros gravados.
     */
    public static void recuperaTabuleiros(String caminho, Jogador player) {

        File file = null;
        Scanner sc = null;

        try {
            file = new File(caminho);
            sc = new Scanner(file);

            int tamanho = Integer.parseInt(sc.nextLine());
            String linha = sc.nextLine();
            String[] valoresCasas = linha.split(",");

            for (int i = 0; i < tamanho; i++) {

                linha = sc.nextLine();
                valoresCasas = linha.split(",");

                for (int j = 0; j < tamanho; j++) {

                    player.getProprio().setTabRegisto(valoresCasas[j].charAt(0), i, j);

                }
                System.out.println();
            }
            linha = sc.nextLine();
            linha = sc.nextLine();

            for (int i = 0; i < tamanho; i++) {

                linha = sc.nextLine();
                valoresCasas = linha.split(",");

                for (int j = 0; j < tamanho; j++) {
                    player.getProprio().setTabPrincipal(valoresCasas[j].charAt(0), i, j);
                }
                System.out.println();
            }

            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(BatalhaNaval.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        menu();
    }

}
