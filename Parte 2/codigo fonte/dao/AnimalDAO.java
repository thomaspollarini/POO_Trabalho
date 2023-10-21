package dao;

import bd.BancoDeDados;
import java.util.Map;
import model.Animal;

public class AnimalDAO {

    private Map<Integer,Animal> animal;

    public AnimalDAO(){
        animal = BancoDeDados.getInstance().getAnimal();    //Puxa banco de dados de animais
    }

    /**
     * Insere animal no banco de dados
     * @param animal - objeto animal que será inserido
     * @return true Se inserção for bem sucedida, false se ocorrer algum erro durante inserção
     */
    public boolean inserir(Animal animal) {
        this.animal.put(animal.getCodigo(), animal);
        return true;
    }
    
    /**
     * Altera animal no banco de dados
     * @param cod - posição do animal no vetor de Banco de dados
     * @param animal - objeto animal que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Animal animal) {
        this.animal.put(cod, animal);
        return true;
    }
    
    /**
     * Remove animal do bando de dados
     * @param cod - posição do animal no vetor de Banco de dados
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod) {
        this.animal.remove(cod);
        return true;
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos animais
     */
    public void limpaDados() {
        this.animal.clear();
    }
    
    /**
     * Retorna animal de acordo com código passado por parâmetro
     * @param cod - código do animal
     * @return variável Objeto Animal
     */
    public Animal getAnimal(int cod) {
        return this.animal.get(cod);
    }

    /**
     * Retorna Banco de Dados dos animais
     * @return Map do Objeto Animal
     */
    public Map<Integer,Animal> getAll() {
        return this.animal;
    }

}
