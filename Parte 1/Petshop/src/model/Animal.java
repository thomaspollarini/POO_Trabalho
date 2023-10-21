package model;


public class Animal {
    private int codigo;
    private String nome;
    private String endereco;
    private String cidade;

    public Animal() {
        
    }

    public Animal(int codigo, String nome, String endereco, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    

    

    /**
     * Retorna código do animal
     * @return codigo do animal
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Aloca código do animal
     * @param codigo código do animal
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna nome do animal
     * @return nome do animal
     */
    public String getNome() {
        return nome;
    }

    /**
     * Aloca nome do animal
     * @param nome nome do animal
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna endereço do animal
     * @return endereço do animal
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Aloca endereço do animal
     * @param endereco endereço do animal
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna cidade do animal
     * @return cidade do animal
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Aloca cidade do animal
     * @param cidade cidade do animal
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    /**
     * Retorna dados do animal em texto
     * @return Dados do animal
     */
    @Override
    public String toString() {
        return "\nAnimal: - Código: "+getCodigo()+" Nome: "+getNome()+" Endereço: "+getEndereco()+" Cidade: "+getCidade();
    }
    
}