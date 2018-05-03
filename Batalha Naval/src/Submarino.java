/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroQuinta
 */
public class Submarino extends Peca {
    
     private char nome='S';
     
    // submario sabe qual a sua forma. n precisa de receber no construtor
    public Submarino(int posicaoX, int posicaoY) {
        
        super(posicaoX, posicaoY, new boolean[][]{{true}});
        setNome(nome);
    }    
    

}
