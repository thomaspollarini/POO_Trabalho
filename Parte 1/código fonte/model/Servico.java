package model;

public class Servico {

    private int codigo;
    private String nome;
    private float valor;

    public Servico() {
    }

    public Servico(int codigo, String nome, float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }
    
    /**
     * Aloca código do serviço
     * @param codigo código do serviço
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Retorna código do serviço
     * @return codigo do serviço
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Aloca nome do serviço
     * @param nome nome do serviço
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna nome do serviço
     * @return nome do serviço
     */
    public String getNome() {
        return nome;
    }

    /**
     * Aloca valor do serviço
     * @param valor valor do serviço
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * Retorna valor do serviço
     * @return valor do serviço
     */
    public float getValor() {
        return valor;
    }

    /**
     * Retorna dados do serviço em texto
     * @return Dados do serviço
     */
    @Override
    public String toString() {
        return "\nServiço: - Código: "+codigo+" Nome: "+nome+" Valor: "+valor;
    }

}