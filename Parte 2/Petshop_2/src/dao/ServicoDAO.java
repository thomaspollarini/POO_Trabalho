package dao;

import bd.BancoDeDados;
import java.util.Map;
import model.Servico;
/**
 *
 * @author windows
 */
public class ServicoDAO {
    
    private BancoDeDados bd;
    private Map<Integer,Servico> servico;

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
        this.servico.put(servico.getCodigo(), servico);
        return true;
    }
    
    /**
     * Altera serviço no banco de dados
     * @param cod - posição do serviço no vetor de Banco de dados
     * @param servico - objeto serviço que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Servico servico){
        this.servico.put(cod, servico);
        return true;
    }
    
    /**
     * Remove serviço do bando de dados
     * @param cod - posição do serviço no vetor de Banco de dados
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod){
        this.servico.remove(cod);
        return true;
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos serviços
     */
    public void limpaDados(){
        this.servico.clear();
    }
    
    /**
     * Retorna serviço de acordo com código passado por parâmetro
     * @param cod - código do serviço
     * @return variável Objeto serviço
     */
    public Servico getServico(int cod){
        return this.servico.get(cod);
    }

    /**
     * Retorna Banco de Dados dos serviçoos
     * @return Map do Objeto Servico
     */
    public Map<Integer,Servico> getAll() {
            return this.servico;
    }
    
}