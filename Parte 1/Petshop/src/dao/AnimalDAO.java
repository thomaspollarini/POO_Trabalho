package dao;

import bd.BancoDeDados;
import model.Animal;

public class AnimalDAO {

    private Animal animal[];

    public AnimalDAO(){
        animal = BancoDeDados.getInstance().getAnimal();    //Puxa banco de dados de animais
    }

    /**
     * Insere animal no banco de dados
     * @param animal - objeto animal que será inserido
     * @return true Se inserção for bem sucedida, false se ocorrer algum erro durante inserção
     */
    public boolean inserir(Animal animal) {
        int i = 0;
        while (i < this.animal.length) {  //procura posição vazia no banco de dados
            if (this.animal[i] == null) {
                this.animal[i]=animal;
                return true;
            }
            i++;
        }
        
        if (i == this.animal.length) { //caso não haja posição vaga retorna false
            System.out.println("Banco de dados dos animais está cheio");
            return false;
        }
        
        return true;
    }
    
    /**
     * Altera animal no banco de dados
     * @param cod - posição do animal no vetor de Banco de dados
     * @param animal - objeto animal que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Animal animal) {

        if (cod == this.animal.length) { // verifica se posição passada existe no banco de dados
            System.out.println("Código digitado não pertence ao Banco de Dados.");
            return false;
        } else {
            this.animal[cod]=animal;
            return true;
        }
    }
    
    /**
     * Remove animal do bando de dados
     * @param cod - posição do animal no vetor de Banco de dados
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod) {

        if (cod == this.animal.length) {  // verifica se posição passada existe no banco de dados
            System.out.println("Código digitado não pertence ao Banco de Dados.");
            return false;
        } else {
            this.animal[cod] = null;
            return true;
        }
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos animais
     */
    public void limpaDados() {
        for (int i = 0; i < this.animal.length; i++) {  //caminha todo banco de dados substituindo valores para nulo
            this.animal[i] = null;
        }
    }
    
    /**
     * Retorna animal de acordo com código passado por parâmetro
     * @param cod - código do animal
     * @return variável Objeto Animal
     */
    public Animal getAnimal(int cod) {
        int i = 0;
        while (i < this.animal.length) {  //percorre banco de dados até encontrar animal com mesmo código
            if (this.animal[i] != null && this.animal[i].getCodigo() == cod) {
                return this.animal[i];
            }
            i++;
        }
        return null;
    }

    /**
     * Retorna Banco de Dados dos animais
     * @return vetor do Objeto Animal
     */
    public Animal[] getAll() {

        return this.animal;
    }

}
