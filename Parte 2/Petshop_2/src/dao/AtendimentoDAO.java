/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.BancoDeDados;
import java.util.Map;
import model.Atendimento;

/**
 *
 * @author windows
 */
public class AtendimentoDAO {

    private BancoDeDados bd;
    private Map<Integer,Atendimento> atendimento;

    public AtendimentoDAO() {
        bd = BancoDeDados.getInstance();
        atendimento = bd.getAtendimento();

    }

    /**
     * Insere atendimento no banco de dados
     * @param atendimento - objeto atendimento que será inserido
     * @return true Se inserção for bem sucedida, false se ocorrer algum erro durante inserção
     */
    public boolean inserir(Atendimento atendimento) {
        this.atendimento.put(atendimento.getCodigo(), atendimento);
        return true;
    }

    /**
     * Altera atendimento no banco de dados
     * @param cod - posição do atendimento no vetor de Banco de dados
     * @param atendimento - objeto atendimento que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Atendimento atendimento) {
        this.atendimento.put(cod, atendimento);
        return true;
    }

    /**
     * Remove atendimento do bando de dados
     * @param cod - posição do atendimento no vetor de Banco de dados
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod) {
        this.atendimento.remove(cod);
        return true;
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos atendimentos
     */
    public void limpaDados() {
        this.atendimento.clear();
    }

    /**
     * Retorna atendimento de acordo com código passado por parâmetro
     * @param cod - código do atendimento
     * @return variável Objeto Atendimento
     */
    public Atendimento getAtendimento(int cod) {
        return this.atendimento.get(cod);
    }

    /**
     * Retorna Banco de Dados dos atendimentos
     * @return Map do Objeto Atendimento
     */
    public Map<Integer,Atendimento> getAll() {
        return this.atendimento;
    }

}
