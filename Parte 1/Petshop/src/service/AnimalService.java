/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AnimalDAO;
import model.Animal;

/**
 *
 * @author windows
 */
public class AnimalService {

    private AnimalDAO animalDAO;
    private Animal animal[];
    
    public AnimalService() {
        animalDAO= new AnimalDAO();
        animal = animalDAO.getAll();
    }
    
    /**
     * Insere animal no banco de dados
     * @param animal - objeto animal que será inserido
     * @return true Se inserção for bem sucedida, false se ocorrer algum erro durante inserção
     */
    public boolean inserir(Animal animal){
        
        int i=0;
        while(i<this.animal.length){  //percorre banco de dados dos animais verificando se código já foi cadastrado
            if(this.animal[i]!=null && this.animal[i].getCodigo() == animal.getCodigo()){
                System.out.println("Código já cadastrado.");
                return false;
            }
            i++;
        }
        return animalDAO.inserir(animal);   //chama inserir do animalDAO
    }
    
     /**
     * Altera animal no banco de dados
     * @param cod - código do animal
     * @param animal - objeto animal que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Animal animal){
        
        int i=0;
        while(i<this.animal.length){  //percorre banco de dados dos animais procurando código do parâmetro
            if(this.animal[i]!=null && this.animal[i].getCodigo() == animal.getCodigo()){
                return animalDAO.alterar(i,animal);//chama alterar do animalDAO
            }
            i++;
        }
        return animalDAO.alterar(i,animal);//chama alterar do animalDAO
    }
    
    /**
     * Remove animal do bando de dados
     * @param cod - código do animal
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod){
        int i=0;
        while(i<this.animal.length){ //percorre banco de dados dos animais procurando código do parâmetro
            if(this.animal[i]!=null && this.animal[i].getCodigo() == cod){
                return animalDAO.remover(i); //chama remover do animalDAO
            }
            i++;
        }
        return animalDAO.remover(i); //chama remover do animalDAO
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos animais
     */
    public void limpaDados(){
        animalDAO.limpaDados(); //chama limpaDados do animalDAO
    }
    
    /**
     * Retorna animal de acordo com código passado por parâmetro
     * @param cod - código do animal
     * @return variável Objeto Animal
     */
    public Animal getAnimal(int cod){
        return animalDAO.getAnimal(cod); //chama getAnimal do animalDAO
    }

    /**
     * Retorna dados de todos os animais cadastrados em forma de texto
     * @return dados de todos os animais
     */
    @Override
    public String toString() {
        String listagem="";
        int i=0;
        while(i<this.animal.length){ //percorre todo banco de dados
            if(animal[i]!=null){     //quando animal diferente de nulo concatena toString do animal
                listagem+=animal[i].toString();
            }    
            i++;
        }
        
        return listagem; 
    }
    
    
    
}
