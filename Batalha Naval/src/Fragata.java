/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroQuinta
 */
public class Fragata extends Peca {
    
    private char nome='F';
     
    
    public Fragata(int posicaoX, int posicaoY) {

        super(posicaoX, posicaoY,new boolean[][]{{true, true, true, true}});
        setNome(nome);
    }  
}
