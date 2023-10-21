/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.BancoDeDados;
import model.Atendimento;

/**
 *
 * @author windows
 */
public class AtendimentoDAO {

    private BancoDeDados bd;
    private Atendimento atendimento[];

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
        int i = 0;
        while (i < this.atendimento.length) {  //procura posição vazia no banco de dados
            if (this.atendimento[i] == null) {
                this.atendimento[i]=atendimento;
                return true;
            }
            i++;
        }

        if (i == this.atendimento.length) { //caso não haja posição vaga retorna false
            System.out.println("Banco de dados dos animais está cheio");
            return false;
        }
        
        return true;
    }

    /**
     * Altera atendimento no banco de dados
     * @param cod - posição do atendimento no vetor de Banco de dados
     * @param atendimento - objeto atendimento que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Atendimento atendimento) {

        if (cod == this.atendimento.length) { // verifica se posição passada existe no banco de dados
            System.out.println("Código digitado não pertence ao Banco de Dados.");
            return false;
        } else {
            this.atendimento[cod]=atendimento;
            return true;
        }
    }

    /**
     * Remove atendimento do bando de dados
     * @param cod - posição do atendimento no vetor de Banco de dados
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod) {

        if (cod == this.atendimento.length) { // verifica se posição passada existe no banco de dados
            System.out.println("Código digitado não pertence ao Banco de Dados.");
            return false;
        } else {
            this.atendimento[cod] = null;
            return true;
        }
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos atendimentos
     */
    public void limpaDados() {

        for (int i = 0; i < this.atendimento.length; i++) { //caminha todo banco de dados substituindo valores para nulo
            this.atendimento[i] = null;
        }
    }

    /**
     * Retorna atendimento de acordo com código passado por parâmetro
     * @param cod - código do atendimento
     * @return variável Objeto Atendimento
     */
    public Atendimento getAtendimento(int cod) {
        int i = 0;
        while (i < this.atendimento.length) { //percorre banco de dados até encontrar atendimento com mesmo código
            if (this.atendimento[i] != null && this.atendimento[i].getCodigo() == cod) {
                return this.atendimento[i];
            }
            i++;
        }
        return null;
    }

    /**
     * Retorna Banco de Dados dos atendimentos
     * @return vetor do Objeto Atendimento
     */
    public Atendimento[] getAll() {
        return this.atendimento;
    }

}
