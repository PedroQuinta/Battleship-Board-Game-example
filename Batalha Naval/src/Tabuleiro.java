/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroQuinta
 */
public class Tabuleiro {

    private char[][] tabPrincipal;
    private char[][] tabRegisto;
    private int comprimento = 10;
    private Peca[][] tabDeBarcos = new Peca[comprimento][comprimento];
    

    public Tabuleiro() {
        tabPrincipal = new char[comprimento][comprimento];
        tabRegisto = new char[comprimento][comprimento];
        for (int i = 0; i < tabPrincipal.length; i++) {
            for (int j = 0; j < tabPrincipal.length; j++) {
                tabPrincipal[i][j] = '~';
                tabRegisto[i][j] = '~';
            }
        }
    }

    /**
     * Lê um inteiro linha e um inteiro coluna e coloca o caracter X nessa coordenada.
     * @param linha Um inteiro para guardar a coordenada x.
     * @param coluna Um inteiro para guardar a coordenada y. 
     */
    public void setTabRegistoTiro(int linha, int coluna) {        
        tabRegisto[linha][coluna] = 'X';
    }
    
    /**
     * Lê um inteiro linha e um inteiro coluna e coloca o caracter O nessa coordenada.
     * @param linha Um inteiro para guardar a coordenada x.
     * @param coluna Um inteiro para guardar a coordenada y. 
     */
    public void setTabRegistoAgua(int linha, int coluna) {
        tabRegisto[linha][coluna] = 'O';
    }
    
    /**
     * Lê um inteiro linha e um inteiro coluna e coloca o caracter X nessa coordenada,
     * caso o tabuleiro principal nessa coordenada seja diferente de água e de O. Senão
     * coloca o caracter O.
     * @param linha Um inteiro para guardar a coordenada x.
     * @param coluna Um inteiro para guardar a coordenada y.
     */
    public void setTabPrincipal(int linha, int coluna) {
        if (tabPrincipal[linha][coluna] != '~'&& tabPrincipal[linha][coluna] != 'O') {
            tabPrincipal[linha][coluna] = 'X';
        } else {
            tabPrincipal[linha][coluna] = 'O';
        }
    } 

    public void setTabPrincipal(char tabPrincipal, int i, int j) {
        this.tabPrincipal[i][j] = tabPrincipal;
    }

    public void setTabRegisto(char tabRegisto, int i, int j) {
        this.tabRegisto[i][j] = tabRegisto;
    }    
    
    /**
     * Lê um inteiro i e um inteiro l e retorna o objeto nessa coordenada do tabuleiro de barcos.
     * Pode ser um objeto do tipo barco, ou null.
     * @param i
     * @param l
     * @return Um objeto do tipo Peca para ter acesso à informação de que tipo de barco se encontra na coordenada que leu.
     */
    public Peca getTabDeBarcos(int i, int l) {
        return tabDeBarcos[i][l];
    }

    /**
     * Retorna um inteiro que corresponde ao campo comprimento do tabuleiro.
     * @return 
     */
    public int getComprimento() {
        return comprimento;
    }

    /**
     * Lê um inteiro linha e um inteiro coluna e retorna o caracter presente nessa coordenada do tabuleiro principal.
     * @param linha
     * @param coluna
     * @return Um caracter do tipo char para saber distinguir se foi certeiro, água, ou ainda não tentado.     
     */
    public char getTabPrincipal(int linha, int coluna) {
        return tabPrincipal[linha][coluna];
    }   
    
    /**
     * Lê um inteiro linha e um inteiro coluna e retorna o caracter presente nessa coordenada do tabuleiro de registo.
     * @param linha
     * @param coluna
     * @return Um caracter do tipo char para saber distinguir se foi certeiro, água, ou ainda não tentado.
     */
    public char getTabRegisto(int linha, int coluna){
        return tabRegisto[linha][coluna];
    }    

    /**
     * Imprime o tabuleiro principal 10x10, com uma linha adicional de caracteres maiúsculos do A ao J,
     * uma coluna adicional no fim com números do 1 ao 10 e um cabeçalho a informar tratar-se do 
     * tabuleiro principal.
     * @param nomeDoJogador Uma string para guardar o nome do jogador ao qual corresponde o tabuleiro imprimido.
     */
    public void mostraTab(String nomeDoJogador) {
        char coluna[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int linha[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.printf("TABULEIRO PRINCIPAL(%s): ", nomeDoJogador);
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < tabPrincipal.length; i++) {

            System.out.print(coluna[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < tabPrincipal.length; i++) {
            for (int j = 0; j < tabPrincipal.length; j++) {

                System.out.print(tabPrincipal[i][j] + "   ");
                if (j == tabPrincipal.length - 1) {
                    System.out.print(linha[i]);
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Imprime o tabuleiro principal 10x10, com uma linha adicional de caracteres maiúsculos do A ao J,
     * uma coluna adicional no fim com números do 1 ao 10 e um cabeçalho a informar tratar-se do 
     * tabuleiro de registo.     
     * @param nomeDoJogador
     */
    public void mostraTabRegisto(String nomeDoJogador) {
        char coluna[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int linha[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.printf("TABULEIRO DE REGISTO (%s): ",nomeDoJogador);
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < tabRegisto.length; i++) {

            System.out.print(coluna[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < tabRegisto.length; i++) {
            for (int j = 0; j < tabRegisto.length; j++) {

                System.out.print(tabRegisto[i][j] + "   ");
                if (j == tabRegisto.length - 1) {
                    System.out.print(linha[i]);
                }
            }
            System.out.println();
        }
    }   

    /**
     * Lê um inteiro linha e um inteiro coluna e valida-me o invólucro à volta de uma coordenada, 
     * para saber se esta está rodeada de água. Retorna false caso, à volta da coordenada não
     * haja só água.
     * @param linha
     * @param coluna
     * @return  Um booleano para saber distinguir quando é uma coordenada válida ou não.
     */
    public boolean validateSurrounding(int linha, int coluna) {

        int i = linha;
        int j = coluna;
        

        for (i = linha - 1; i <= linha + 1; i++) {

            for (j = coluna - 1; j <= coluna + 1; j++) {
                if (i < 0 || i >= tabPrincipal.length || j < 0 || j >= tabPrincipal[0].length) {
                    continue;
                }
                if (tabPrincipal[i][j] != '~') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Limpa a janela do output, enviando para cima o conteudo mais recente dando assim a ilusão de ter sido limpo.
     */
    public void clearScreen() {
        for (int clear = 0; clear < 50; clear++) {
            System.out.println("\b");
        }
    }
   
    /**
     * Lê um barco do tipo Peca, onde através da sua forma e da coordenada inicial dada pelo utilizador ou computador
     * e validada pelo validateSurrounding irá desenhar no tabuleiro principal o nome correspondente ao barco que recebeu
     * como parametro.
     * @param barco Um objeto do tipo Peca para saber que barco deve desenhar e que caracter colocar no tabuleiro.
     * @return Um booleano para saber se desenhou com sucesso ou se não validou.
     */
    public boolean desenhaPeca(Peca barco) {
        int linha = barco.getPosicaoX();
        int coluna = barco.getPosicaoY();
        int limiteX = barco.getDimensoes()[0];
        int limiteY = barco.getDimensoes()[1];      
        

        for (int i = linha, barcoX = 0; barcoX < limiteX; i++, barcoX++) {
            for (int j = coluna, barcoY = 0; barcoY < limiteY; j++, barcoY++) {
                if (barco.getForma(barcoX, barcoY) && !validateSurrounding(i, j)) {                    
                    return false;
                }
                if((i>=tabPrincipal.length || j >=tabPrincipal[0].length)){
                    return false;
                }
            }
        }

        for (int i = linha, barcoX = 0; barcoX < limiteX; i++, barcoX++) {
            for (int j = coluna, barcoY = 0; barcoY < limiteY; j++, barcoY++) {
                if((i>=tabPrincipal.length || j >=tabPrincipal[0].length)){
                    return false;
                }
                if(barco.getForma(barcoX, barcoY)){                    
                    tabPrincipal[i][j] = barco.getNome();
                    tabDeBarcos[i][j] = barco;                    
                }     
                
            }
            
        }
        return true;
    }

}
