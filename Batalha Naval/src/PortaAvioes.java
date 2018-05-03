/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroQuinta
 */
public class PortaAvioes extends Peca {
    
    private char nome='P';
     
    
    public PortaAvioes(int posicaoX, int posicaoY) {

        super(posicaoX, posicaoY,new boolean[][]{{true, true, true}, {false, true, false},{false, true, false}});
        setNome(nome);
    }  
}
