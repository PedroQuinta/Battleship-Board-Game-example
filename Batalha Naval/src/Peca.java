
/**
 *
 * @author PedroQuinta
 */
public abstract class Peca {

    public int comprimento = 0;
    public int posicaoX;
    public int posicaoY;
    public char nome;
    public boolean[][] forma;
    public int hits = 0;
    private int rotacoes = 0;
    private int judge = 0;

    public Peca(int posicaoX, int posicaoY, boolean[][] forma) {
        for (boolean[] forma1 : forma) {
            for (int j = 0; j < forma[0].length; j++) {
                if (forma1[j]) {
                    this.comprimento += 1;
                }
            }
        }
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.forma = forma;
    }

    /**
     * Lê um nome e atribui esse nome ao campo.
     *
     * @param nome
     */
    void setNome(char nome) {
        this.nome = nome;
    }

    /**
     * Lê número inteiro e modifica o campo hits.
     * @param hits Um inteiro que servirá para modificar o campo hits.
     */
    public void setHits(int hits) {
        this.hits = hits;
    }   

    /**
     * Retorna um inteiro.
     *
     * @return Um inteiro correspondente ao campo posicaoX.
     */
    int getPosicaoX() {
        return posicaoX;
    }

    /**
     * Retorna um inteiro.
     *
     * @return Um inteiro que corresponde ao campo comprimento.
     */
    int getComprimento() {
        return comprimento;
    }

    /**
     * Retorna um inteiro.
     *
     * @return Um inteiro correspondente ao campo posicaoY.
     */
    int getPosicaoY() {
        return posicaoY;
    }

    /**
     * Retorna um inteiro.
     *
     * @return Um inteiro que corresponde ao campo rotações.
     */
    public int getRotacoes() {
        return rotacoes;
    }

    /**
     * Lê um inteiro e coloca-o numa variavel.
     *
     * @param posicaoX Um inteiro para fazer a atribuição e modificação do campo
     * posicaoX.
     */
    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    /**
     * Lê um inteiro e coloca-o numa variavel.
     *
     * @param posicaoY Um inteiro para fazer a atribuição e modificação do campo
     * posicaoY.
     */
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    /**
     * Lê um inteiro e coloca-o num campo.
     *
     * @param rotacoes Um inteiro para atribiur e modificar o campo rotacoes.
     */
    public void setRotacoes(int rotacoes) {
        this.rotacoes = rotacoes;
    }

    /**
     * Lê um array 2D booleano e coloca-o no campo forma.
     *
     * @param forma Um array 2D booleano para ser atribuido e modificar o campo
     * forma.
     */
    public void setForma(boolean[][] forma) {
        this.forma = forma;
    }

    /**
     * Retorna um array 2D booleano correspondente ao valor que o campo forma
     * terá.
     *
     * @return Um array 2D booleano para guardar a informação que o campo forma
     * contém.
     */
    public boolean[][] getForma() {
        return forma;
    }

    /**
     * Retorna um caracter.
     *
     * @return Um caracter para guardar o valor contido no campo nome.
     */
    char getNome() {
        return nome;
    }

    /**
     * Lê dois inteiros e retorna um valor booleano true caso o campo
     * forma[m][n] for true, senão retorna falso.
     *
     * @param m Um inteiro para servir de coordenada linha.
     * @param n Um inteiro para servir de coordenada coluna.
     * @return Um booleano para sabermos se o campo forma naquela coordenada
     * exata assume valor falso ou verdadeiro.
     */
    boolean getForma(int m, int n) {
        return forma[m][n];
    }

    /**
     * Retorna um array unidimensional de inteiros.
     *
     * @return Um array de inteiros para guardar informação acerca da dimensão
     * em XX e em YY do campo forma.
     */
    public int[] getDimensoes() {
        int[] dim = new int[2];
        dim[0] = forma.length;
        dim[1] = forma[0].length;

        return dim;
    }

    /**
     * Incrementa o valor do campo hits.
     */
    public void tiro() {
        hits++;
    }

    /**
     * Retorna um booleano.
     *
     * @return Um booleano para guardar true quando o número de tiros certeiros
     * for igual ao comprimento do barco em questão.
     */
    public boolean foiAoFundo() {
        return hits == getComprimento();
    }

    /**
     * Lê um array 2D de entrada e retorna um array do mesmo tipo, mas
     * transposto.
     *
     * @param array Um array de booleanos para ser transposto.
     * @return Um array 2D final de booleanos após a operação matemática de
     * transpor.
     */
    public boolean[][] transpose(boolean[][] array) {
        if (array == null || array.length == 0)//empty or unset array, nothing do to here
        {
            return array;
        }

        int width = array.length;
        int height = array[0].length;

        boolean[][] array_new = new boolean[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                array_new[y][x] = array[x][y];
            }
        }
        return array_new;
    }

    /**
     * Método que roda uma matriz até 360º, passando pelas várias rotações.
     */
    public void rotateMatrix() {

        switch (rotacoes) {
            case 0:
                if (judge == 1) {
                    judge = 0;
                    forma = transpose(forma);
                }
                break;
            case 1:
                if (judge == 0) {
                    forma = transpose(forma);
                    judge = 1;
                }
                break;
            default:
                for (int k = 0; k < rotacoes; k++) {
                    for (int i = 0; i < forma.length / 2; i++) {
                        for (int j = 0; j < forma.length - 1 - 2 * i; j++) {
                            boolean tmp = forma[j + i][forma.length - 1 - i];
                            forma[j + i][forma.length - 1 - i] = forma[i][j + i];
                            forma[i][j + i] = forma[forma.length - 1 - j - i][i];
                            forma[forma.length - 1 - j - i][i] = forma[forma.length - 1 - i][forma.length - 1 - j - i];
                            forma[forma.length - 1 - i][forma.length - 1 - j - i] = tmp;
                        }
                    }
                }
        }
    }

}
