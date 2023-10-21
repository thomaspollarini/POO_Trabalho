package bd;

import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {

    private static Animal animal[];
    private static Servico servico[];
    private static Atendimento atendimento[];
    private static BancoDeDados bd;

    private BancoDeDados() {
        animal = new Animal[10];        //instancia vetores para armazenar dados
        servico = new Servico[10];
        atendimento = new Atendimento[20];
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
     *  Retorna banco de dados de animais
     * 
     * @return  vetor do Objeto Animal
     */
    public static Animal[] getAnimal() {
        return animal; //Retorna banco de dados de animais
    }
    
    /**
     *  Retorna banco de dados de serviços
     * 
     * @return  vetor do Objeto Servico
     */
    public static Servico[] getServico() {
        return servico; //Retorna banco de dados de serviços
    }
    
    /**
     *  Retorna banco de dados de atendimentos
     * 
     * @return  vetor do Objeto Atendimento
     */
    public static Atendimento[] getAtendimento() {
        return atendimento; //Retorna banco de dados de atendimentos
    }

}
