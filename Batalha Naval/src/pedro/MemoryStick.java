/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemoryStick {

    public void gravaJogoJogador(String caminho, Tabuleiro proprio, Tabuleiro jogadas) {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(caminho);
            bw = new BufferedWriter(fw);

            bw.write(String.valueOf(proprio.getTamanho())); // gravar o tamanho dos tabuleiros
            bw.write("\n"); // nova linha

            for (int i = 0; i < proprio.getTamanho(); i++) {
                for (int j = 0; j < proprio.getTamanho(); j++) {
                    bw.write(proprio.getPosicao(i, j));

                    if (j < proprio.getTamanho() - 1) {
                        bw.write(",");
                    }
                }
                bw.write("\n");
            }

            // bw.write("\n");
            // novos fors para o tabuleiro jogadas ou assim
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(MemoryStick.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tabuleiro[] recuperaTabuleiros(String caminho) {

        Tabuleiro[] lidos = new Tabuleiro[2]; // ler dois tabuleiros

        File file = null;
        Scanner sc = null;

        try {
            file = new File(caminho);
            sc = new Scanner(file);

            int tamanho = Integer.parseInt(sc.nextLine());
            System.out.println("Tamanho detectado pelo recuperaTabuleiros: " + tamanho);

            for (int i = 0; i < tamanho; i++) {

                String linha = sc.nextLine();
                String[] valoresCasas = linha.split(",");
                
                for (int j = 0; j < tamanho; j++) {
                    System.out.print(valoresCasas[j]);              
                    System.out.print(" ");
                    // seria tabuleiro[0].setPosicao(i,j) = valorCasas[j];
                }
                
                System.out.println();
            }

            // bw.write("\n");
            // novos fors para o tabuleiro jogadas ou assim
            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(MemoryStick.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lidos;
    }

}
