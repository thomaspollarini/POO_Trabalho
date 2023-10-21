/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ServicoDAO;
import java.util.Map;
import model.Servico;

/**
 *
 * @author windows
 */
public class ServicoService {

    /**
     *
     * @author windows
     */
    private ServicoDAO servicoDAO;
    private Map<Integer,Servico> servico;

    public ServicoService() {
        servicoDAO = new ServicoDAO();
        servico = servicoDAO.getAll();
    }

    /**
     * Insere serviço no banco de dados
     * @param servico - objeto serviço que será inserido
     * @return true Se inserção for bem sucedida, false se ocorrer algum erro durante inserção
     */
    public boolean inserir(Servico servico) {

        if(this.servico.containsKey(servico.getCodigo())){
            System.out.println("Código já cadastrado.");
            return false;
        }
        return servicoDAO.inserir(servico);   //chama inserir do servicoDAO
    }

    /**
     * Altera serviço no banco de dados
     * @param cod - código do serviço
     * @param servico - objeto serviço que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Servico servico) {

        if(this.servico.containsKey(cod)){
            return servicoDAO.alterar(cod,servico);
        }
        System.out.println("Código não cadastrado");
        return false;
    }

    /**
     * Remove serviço do bando de dados
     * @param cod - código do serviço
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod) {
        if(this.servico.containsKey(cod)){
            return servicoDAO.remover(cod);
        }
        System.out.println("Código não cadastrado");
        return false; 
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos serviços
     */
    public void limpaDados() {
        servicoDAO.limpaDados(); //chama limpaDados do serviçoDAO
    }

    /**
     * Retorna serviço de acordo com código passado por parâmetro
     * @param cod - código do serviço
     * @return variável Objeto serviço
     */
    public Servico getServico(int cod) {
        return servicoDAO.getServico(cod); //chama getServico do serviçoDAO
    }

    /**
     * Retorna dados de todos os serviços cadastrados em forma de texto
     * @return dados de todos os serviços
     */
    @Override
    public String toString() {
        String listagem="";
        for(int key : this.servico.keySet()){
            listagem+=this.servico.get(key);
        }
        
        return listagem; 
    }
}

