/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroQuinta
 */
public class Galeao extends Peca {
    
    private char nome='G';
    
    public Galeao(int posicaoX, int posicaoY) {

        super(posicaoX, posicaoY,new boolean[][]{{true, true, true}});        
        setNome(nome);
    }   
}
