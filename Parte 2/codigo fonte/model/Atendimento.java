package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Atendimento {
   private int codigo;
   private Date date;
   private Animal animal;
   private Servico servico;

    public Atendimento() {
        servico = new Servico();
    }

    public Atendimento(int codigo, Date date, Animal animal, Servico servico) {
        this.codigo = codigo;
        this.date = date;
        this.animal = animal;
        this.servico = servico;
    }

    
    /**
     * Aloca código do atendimento
     * @param codigo código do atendimento
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna código do atendimento
     * @return codigo do atendimento
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Aloca data do atendimento
     * @param date data do atendimento
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Retorna data do atendimento
     * @return data do atendimento
     */
    public Date getDate() {
        return date;
    }

    /**
     * Aloca animal do atendimento
     * @param animal animal do atendimento
     */
    public  void setAnimal(Animal animal){
        this.animal = animal;
    }
   
    /**
     * Retorna animal do atendimento
     * @return animal do atendimento
     */
    public  Animal getAnimal(){
        return this.animal;
    }
   
    /**
     * Aloca serviço do atendimento
     * @param servico serviço do atendimento
     */
    public  void setServico(Servico servico){
        this.servico = servico;
    }
   
    /**
     * Retorna servico do atendimento
     * @return servico do atendimento
     */
    public  Servico getServico(){
        return this.servico;
    }
    
    /**
     * Retorna código do animal
     * @return codigo do animal
     */
    public int getAnimalCodigo(){
        return this.animal.getCodigo();
    }
    
    /**
     * Aloca código do serviço
     * @param cod código do serviço
     */
    public void setServicoCodigo(int cod){
        this.servico.setCodigo(cod);
    }
    
    /**
     * Retorna código do serviço
     * @return codigo do serviço
     */
    public int getServicoCodigo(){
        return this.servico.getCodigo();
    }

    /**
     * Retorna dados do atendimento em texto
     * @return Dados do atendimento
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        
        return "\nAtendimento: - Código: "+codigo+" Cliente: "+getAnimalCodigo()
                +" Produto: "+getServicoCodigo()+" Data: "+sdf.format(date);
    }
   
}