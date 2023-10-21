/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ServicoDAO;
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
    private Servico servico[];

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

        int i = 0;
        while (i < this.servico.length) {  //percorre banco de dados dos serviços verificando se código já foi cadastrado
            if (this.servico[i] != null && this.servico[i].getCodigo() == servico.getCodigo()) {
                System.out.println("Código já cadastrado.");
                return false;
            }
            i++;
        }
        return servicoDAO.inserir(servico); //chama inserir do serviçoDAO
    }

    /**
     * Altera serviço no banco de dados
     * @param cod - código do serviço
     * @param servico - objeto serviço que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Servico servico) {

        int i = 0;
        while (i < this.servico.length) {   //percorre banco de dados dos serviços procurando código do parâmetro
            if (this.servico[i] != null && this.servico[i].getCodigo() == servico.getCodigo()) {
                return servicoDAO.alterar(i, servico);//chama alterar do servicoDAO
            }
            i++;
        }
        return servicoDAO.alterar(i, servico); //chama alterar do servicoDAO
    }

    /**
     * Remove serviço do bando de dados
     * @param cod - código do serviço
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod) {
        int i = 0;
        while (i < this.servico.length) { //percorre banco de dados dos animais procurando código do parâmetro
            if (this.servico[i] != null && this.servico[i].getCodigo() == cod) {
                return servicoDAO.remover(i); //chama remover do servicoDAO
            }
            i++;
        }
        return servicoDAO.remover(i); //chama remover do servicoDAO
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
        int i=0;
        while(i<this.servico.length){ //percorre todo banco de dados
            if(servico[i]!=null){     //quando serviço diferente de nulo concatena toString do serviço
                listagem+=servico[i].toString();
            }    
            i++;
        }
        
        return listagem; 
    }
}

