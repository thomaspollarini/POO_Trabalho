/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.DocumentoException;
import util.Util;

/**
 *
 * @author Alunos
 */
public class Gato extends Animal {

    private String numeroDocumento;
    private TipoDocumento tipo;

    public Gato() {
    }

    public Gato(int codigo, String nome, String endereco, String cidade, TipoDocumento tipo, String numDocumento) {
        super(codigo, nome, endereco, cidade);
        this.tipo = tipo;
        this.numeroDocumento = numDocumento;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) throws DocumentoException {
        if (this.tipo.getTipo().equals("CPF")) {
            if (!Util.cpfValido(numeroDocumento)) {
                throw new DocumentoException("CPF inválido");
            }
            this.numeroDocumento = numeroDocumento;
        }else{
            if (!Util.cnpjValido(numeroDocumento)) {
                throw new DocumentoException("CNPJ inválido");
            }
            this.numeroDocumento = numeroDocumento;
        }
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    @Override
    public float getTaxa() {
        return 1.15f;
    }

    @Override
    public String toString() {
        return super.toString() + " Numero Documento: " + numeroDocumento + " Tipo:" + tipo;
    }

}
