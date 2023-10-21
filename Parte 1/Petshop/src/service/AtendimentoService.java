/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AtendimentoDAO;
import java.util.Date;
import model.Animal;
import model.Atendimento;
import model.Servico;
import util.Util;

/**
 *
 * @author windows
 */
public class AtendimentoService {
    
    private AtendimentoDAO atendimentoDAO;
    private Atendimento atendimento[];
    
    public AtendimentoService() {
        atendimentoDAO= new AtendimentoDAO();
        atendimento = atendimentoDAO.getAll();
    }
    
    /**
     * Insere atendimento no banco de dados
     * @param atendimento - objeto atendimento que será inserido
     * @return true Se inserção for bem sucedida, false se ocorrer algum erro durante inserção
     */
    public boolean inserir(Atendimento atendimento){
        
        AnimalService animalService = new AnimalService();
        ServicoService servicoService= new ServicoService();
        
        int i=0;
        while(i<this.atendimento.length){ //percorre banco de dados dos atendimentos verificando se código já foi cadastrado
            if(this.atendimento[i]!=null && this.atendimento[i].getCodigo() == atendimento.getCodigo()){
                System.out.println("Código já cadastrado.");
                return false;
            }
            i++;
        }
        
        Animal animal=animalService.getAnimal(atendimento.getAnimalCodigo());  //verifica se código do animal está cadastrado
        if(animal==null){
            System.out.println("Código do animal não consta no banco de dados.");
            return false;
        }else{
            atendimento.setAnimal(animal); 
        }
        
        
        Servico servico=servicoService.getServico(atendimento.getServicoCodigo()); //verifica se código do serviço está cadastrado
        if(servico==null){
            System.out.println("Código do serviço não consta no banco de dados.");
            return false;
        }else{
            atendimento.setServico(servico);
        }
        
        return atendimentoDAO.inserir(atendimento);// chama inserir do atendimentoDAO
    }
    
    /**
     * Altera atendimento no banco de dados
     * @param cod - código do atendimento
     * @param atendimento - objeto atendimento que será alterado
     * @return true Se ateração for bem sucedida, false se ocorrer algum erro durante alteração
     */
    public boolean alterar(int cod, Atendimento atendimento){
        
        int i=0;
        while(i<this.atendimento.length){ //percorre banco de dados dos serviços procurando código do parâmetro
            if(this.atendimento[i]!=null && this.atendimento[i].getCodigo() == atendimento.getCodigo()){
                return atendimentoDAO.alterar(i,atendimento); // chama alterar do atendimentoDAO
            }
            i++;
        }
        return atendimentoDAO.alterar(i,atendimento); // chama alterar do atendimentoDAO
    }
    
    /**
     * Remove atendimento do bando de dados
     * @param cod - código do atendimento
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod){
        int i=0;
        while(i<this.atendimento.length){  //percorre banco de dados dos animais procurando código do parâmetro
            if(this.atendimento[i]!=null && this.atendimento[i].getCodigo() == cod){
                return atendimentoDAO.remover(i); // chama alterar do atendimentoDAO
            }
            i++;
        }
        return atendimentoDAO.remover(i); // chama remover do atendimentoDAO
    }
    
    /**
     * Remove todos os dados do Banco de Dados dos atendimentos
     */
    public void limpaDados(){
        atendimentoDAO.limpaDados(); // chama limpaDados do atendimentoDAO
    }
    
    /**
     * Retorna atendimento de acordo com código passado por parâmetro
     * @param cod - código do atendimento
     * @return variável Objeto Atendimento
     */
    public Atendimento getAtendimento(int cod){
        return atendimentoDAO.getAtendimento(cod); // chama getAtendimento do atendimentoDAO
    }
    
    /**
     * Retorna dados de todos os atendimento cadastrados em forma de texto
     * @return dados de todos os atendimento 
     */
    @Override
    public String toString() {
        String listagem="";
        int i=0;
        while(i<this.atendimento.length){ //percorre todo banco de dados
            if(atendimento[i]!=null){     //quando atendimento diferente de nulo concatena toString do serviço
                listagem+=atendimento[i].toString();
            }    
            i++;
        }
        
        return listagem; 
    }
    
    /**
     * Retorna atendimento de maior valor relacionado a um animal
     * @param cod - código do animal
     * @return atendimendo de maior valor do animal
     */
    public Atendimento getMaiorAtendimento(int cod){
        
        AnimalService animalService= new AnimalService();
        Animal animal= new Animal();
        
        animal=animalService.getAnimal(cod); //puxa animal através do código
        if(animal!=null){
            int i=0, maior=0,pos=0;
            while(i<atendimento.length){ //percorre banco de dados do atendimento procurando atendimentos com animal buscado
                if(atendimento[i]!=null && atendimento[i].getAnimalCodigo()==animal.getCodigo()){
                    if(maior==0){  
                        maior=atendimento[i].getServicoCodigo();
                        pos=i;
                    }else{                  //acha maior valor de serviço e guarda posição
                        if(atendimento[i].getServicoCodigo()>maior){
                            maior=atendimento[i].getServicoCodigo();
                            pos=i;
                        }
                    }
                }
                i++;
            }
            
            if(maior!=0){
                return atendimento[pos]; //retorna atendimento de acordo com posição salva anteriormente
            }else{
                System.out.println("Não há atendimentos cadastrados para este animal");
                return null;
            }
        
        }else{
            System.out.println("Animal não cadastrado");
            return null;
        }
    }
    
    /**
     * Retorna atendimento de menor valor relacionado a um animal
     * @param cod - código do animal
     * @return atendimendo de menor valor do animal
     */
    public Atendimento getMenorAtendimento(int cod){
        
        AnimalService animalService= new AnimalService();
        Animal animal= new Animal();
        
        animal=animalService.getAnimal(cod); //puxa animal através do código
        if(animal!=null){
            int i=0, menor=0,pos=0;
            while(i<atendimento.length){ //percorre banco de dados do atendimento procurando atendimentos com animal buscado
                if(atendimento[i]!=null && atendimento[i].getAnimalCodigo()==animal.getCodigo()){
                    if(menor==0){
                        menor=atendimento[i].getServicoCodigo();
                        pos=i;
                    }else{                  //acha menor valor de serviço e guarda posição
                        if(atendimento[i].getServicoCodigo()<menor){
                            menor=atendimento[i].getServicoCodigo();
                            pos=i;
                        }
                    }
                }
                i++;
            }
            
            if(menor!=0){
                return atendimento[pos]; //retorna atendimento de acordo com posição salva anteriormente
            }else{
                System.out.println("Não há atendimentos cadastrados para este animal");
                return null;
            }
        
        }else{
            System.out.println("Animal não cadastrado");
            return null;
        }
    }
    
    /**
     * Retorna valor total de atendimentos relacionado a um animal
     * @param cod - código do animal
     * @return valor total dos atendimentos do animal
     */
    public float getTotalDosAtendimentos(int cod){
        
        
        AnimalService animalService= new AnimalService();
        Animal animal= new Animal();
        
        int total=0;
        
        animal=animalService.getAnimal(cod);//puxa animal através do código
        if(animal!=null){
            
            int i=0;
            while(i<atendimento.length){ //percorre banco de dados do atendimento procurando atendimentos com animal buscado
                if(atendimento[i]!=null && atendimento[i].getAnimalCodigo()==animal.getCodigo()){
                    Servico servico=atendimento[i].getServico();
                    total+=servico.getValor(); //adiciona valor do serviço do atendimento
                }
                i++;
            }
            if(total==0){
                System.out.println("Não há atendimentos para este animal");
                return total;
            }else{
                return total;
            }
        }else{
            System.out.println("Animal não cadastrado.");
            return total;
        }
    }
    
    /**
     * Retorna nota fiscal dos atendimentos relacionados ao animal
     * @param cod - código do animal
     * @return texto da nota fiscal do atendimento
     */
    public String getNotaFiscal(int cod){
        
        AnimalService animalService= new AnimalService();
        Animal animal= new Animal();
        
        animal=animalService.getAnimal(cod); //puxa animal através do código
        if(animal!=null){
            int total=0;
            String nota="";
            
            int i=0;
            while(i<atendimento.length){ //percorre banco de dados do atendimento procurando atendimentos com animal buscado
                if(atendimento[i]!=null && atendimento[i].getAnimalCodigo()==animal.getCodigo()){
                    if(total==0){
                        nota+="\n===========================\nNOTA FISCAL\n===========================\n"
                                +"Nome: "+animal.getNome()+"\nEndereço: "+animal.getEndereco()+"\nCidade: "
                                +animal.getCidade()+"\n===========================\n  ===ATENDIMENTOS===\n"
                                + "===========================";
                    }
                    Servico servico=atendimento[i].getServico();                            //adiciona dados no texto da nota fiscal
                    nota+="\nServiço: "+servico.getNome()+"\tValor: "+servico.getValor();
                    total+=servico.getValor();
                }
                i++;
            }
            if(total==0){ //caso não haja atendimentos
                return "Não há atendimentos para este animal";
            }else{
                
                nota+="\n\n===========================\nTotal: R$ "+total+"\n===========================";
                return nota;    //retorna nota fiscal
            }
        }else{
            return "Animal não cadastrado.";
        }
    }
    
    /**
     * Retorna dados de um atendimento em forma de texto
     * @param cod - código do atendimento
     * @return dados de atendimento
     */
    private String listaAtendimentos(int cod){
        Animal animal= atendimento[cod].getAnimal();
        Servico servico= atendimento[cod].getServico();
        
        return "\nAtendimento: "+atendimento[cod].getCodigo()+" "+animal.getNome()+" - "
                +servico.getNome()+" R$ "+servico.getValor();
    }
    
    /**
     * Retorna atendimentos que ocorreram entre o período de tempo
     * @param dti - data inicial do período
     * @param dtf - data final do período
     * @return atendimentos que ocorreram no período
     */
    public String getAtendimentosPorPeriodo(String dti, String dtf){
        
        Date datai=Util.stringParaDate(dti); //converte data digitada para tipo date
        datai.setTime(datai.getTime()-1); //subtrái um milessegundo na data para pegar atendimentos do mesmo dia
        
        Date dataf=Util.stringParaDate(dtf);//converte data digitada para tipo date
        dataf.setTime(dataf.getTime()+1);//adiciona um milessegundo na data para pegar atendimentos do mesmo dia
        
        String retorno="";
        
        
        int i=0;
        while(i<atendimento.length){ //percorre banco de dados dos atendimentos buscando períodos de tempo que ocorreram entre as datas digitadas
            if(atendimento[i]!=null && datai.before(atendimento[i].getDate()) && dataf.after(atendimento[i].getDate())){
                if(retorno.equals("")){
                    retorno="\nRELATÓRIO - ATENDIMENTOS NO PERÍODO:"+ listaAtendimentos(i);
                }else{
                    retorno+=listaAtendimentos(i);
                }
            }
            i++;
        }
        if(retorno.equals("")){
            return "Não há atendimentos entre esses períodos";
        }else{
            return retorno;
        }
        
    }
    
}
