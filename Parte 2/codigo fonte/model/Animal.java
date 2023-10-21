package model;

import java.util.Objects;


public  abstract class  Animal {
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
    public abstract float getTaxa();
   
    @Override
    public String toString() {
        return "\nAnimal: - Código: "+getCodigo()+" Nome: "+getNome()+" Endereço: "+getEndereco()+" Cidade: "+getCidade();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.endereco);
        hash = 23 * hash + Objects.hashCode(this.cidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }
   
   
   
}