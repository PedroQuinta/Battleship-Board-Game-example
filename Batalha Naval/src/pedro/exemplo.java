/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedro;

import static java.lang.System.out;

/**
 *
 * @author luminoso
 */
public class exemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Tabuleiro t1 = new Tabuleiro();
        
        t1.setPosicao(2, 3, 'B');
        t1.setPosicao(2, 4, 'B');
        
        
        Tabuleiro t2 = new Tabuleiro();
        
        t2.setPosicao(4, 5, 'K');
        t2.setPosicao(5, 5, 'K');
        
        
        MemoryStick gravadordejogos = new MemoryStick();
        gravadordejogos.gravaJogoJogador("save1.dat", t1, t2);
        
        out.println("Tabuleiro lido:");
        
        Tabuleiro[] recuperaTabuleiros = gravadordejogos.recuperaTabuleiros("save1.dat");
        
        // tabuleiro em recuperaTabuleiros[0] e recuperaTabuleiros[1]
        
    }
    
}
