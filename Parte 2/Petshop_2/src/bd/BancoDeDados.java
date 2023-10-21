package bd;

import java.util.HashMap;
import java.util.Map;
import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {

    private static Map<Integer,Animal> animal;
    private static Map<Integer,Servico> servico;
    private static Map<Integer,Atendimento> atendimento;
    private static BancoDeDados bd;

    private BancoDeDados() {
        animal = new HashMap<Integer,Animal>();         //instancia vetores para armazenar dados
        servico = new HashMap<Integer,Servico>();
        atendimento = new HashMap<Integer,Atendimento>();
    }
    
    /**
     * Inicializa Banco de Dados
     * 
     */
    public static BancoDeDados getInstance() { 
        if (bd == null) {           //verifica se bd ja foi instanciado anteriormente
            bd = new BancoDeDados();    //instancia bd
        }
        return bd;   //retorna bd
    }

    /**
     * @return the animal
     */
    public static Map<Integer,Animal> getAnimal() {
        return animal;
    }

    /**
     * @return the servico
     */
    public static Map<Integer,Servico> getServico() {
        return servico;
    }

    /**
     * @return the atendimento
     */
    public static Map<Integer,Atendimento> getAtendimento() {
        return atendimento;
    }

    

}
