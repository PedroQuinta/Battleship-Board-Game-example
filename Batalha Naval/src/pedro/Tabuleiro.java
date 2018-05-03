/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedro;

/**
 *
 * @author luminoso
 */
class Tabuleiro {

    private final char[][] tabuleiro = new char[15][15];

    public Tabuleiro() {

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = '~';
            }
        }
    }

    public int getTamanho() {
        return tabuleiro.length;
    }

    public char getPosicao(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public void setPosicao(int linha, int coluna, char letra) {
        tabuleiro[linha][coluna] = letra;
    }

}
