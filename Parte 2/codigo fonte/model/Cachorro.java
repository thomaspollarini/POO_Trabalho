/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alunos
 */
public class Cachorro extends Animal{
    private boolean pedigree;

    public Cachorro() {
    }

    public Cachorro( int codigo, String nome, String endereco, String cidade, boolean pedigree) {
        super(codigo, nome, endereco, cidade);
        this.pedigree = pedigree;
    }

    public boolean isPedigree(){
        if(pedigree) return true;
        return false;
    }
    
    public void setPePedigree(boolean temPedigree){
        pedigree = temPedigree;
    }

    @Override
    public String toString() {
        return super.toString() + " Pedigree: "+pedigree;
    }

    @Override
    public float getTaxa() {
       return 1.10f;
    }
   
   
}
