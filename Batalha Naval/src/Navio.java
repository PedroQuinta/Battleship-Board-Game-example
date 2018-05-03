/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroQuinta
 */
public class Navio extends Peca {
    
    private char name='N';

    public Navio(int posicaoX, int posicaoY) {
        
        super(posicaoX, posicaoY,new boolean[][]{{true, true}});
        setNome(name);
    } 
    

}
