package dao;

import bd.BancoDeDados;
import model.Servico;
/**
 *
 * @author windows
 */
public class ServicoDAO {
    
    private BancoDeDados bd;
    private Servico servico[];

    public ServicoDAO() {
        bd = BancoDeDados.getInstance();
        servico = bd.getServico();

    }

    /**
     * Insere serviço no banco de dados
     * @param servico - objeto serviço que será inserido
     * @return true Se inserção for bem sucedida, false se ocorrer algum erro durante inserção
     */
    public boolean inserir(Servico servico) {
        int i = 0;
        while(i<this.servico.length){       //procura posição vazia no banco de dados
            if (this.servico[i] == null) {
                this.servico[i]=servico;
                return true;
            }
            i++;
        }

        if (i == this.servico.length) {  //caso não haja posição vaga retorna false
            System.out.println("Banco de dados dos animais está cheio");
            return false;
        }
        
        return true;
    }
    
    /**
     * Altera serviço no banco de dados
     * @param cod - posição do serviço no vetor de Banco de dados
     * @param servico - objeto serviço que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Servico servico){
        
        if (cod == this.servico.length) {  // verifica se posição passada existe no banco de dados
            System.out.println("Código digitado não pertence ao Banco de Dados.");
            return false;
        }else{
            this.servico[cod]=servico;
            return true;
        }
    }
    
    /**
     * Remove serviço do bando de dados
     * @param cod - posição do serviço no vetor de Banco de dados
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod){
        
        if (cod == this.servico.length) { // verifica se posição passada existe no banco de dados
            System.out.println("Código digitado não pertence ao Banco de Dados.");
            return false;
        }else{
            this.servico[cod] = null;
            return true;
        }
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos serviços
     */
    public void limpaDados(){
        for(int i=0;i<this.servico.length;i++){ //caminha todo banco de dados substituindo valores para nulo
            this.servico[i]=null;
        }
    }
    
    /**
     * Retorna serviço de acordo com código passado por parâmetro
     * @param cod - código do serviço
     * @return variável Objeto serviço
     */
    public Servico getServico(int cod){
        int i=0;
        while(i<this.servico.length){ //percorre banco de dados até encontrar serviço com mesmo código
            if(this.servico[i] !=null && this.servico[i].getCodigo()==cod){
                return this.servico[i];
            }
            i++;
        }
        return null;
    }

    /**
     * Retorna Banco de Dados dos serviçoos
     * @return vetor do Objeto Servico
     */
    public Servico[] getAll() {
            return this.servico;
    }
    
}