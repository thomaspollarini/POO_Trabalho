/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AtendimentoDAO;
import java.util.Date;
import java.util.Map;
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
    private Map<Integer,Atendimento> atendimento;
    
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
        
        ServicoService servicoService= new ServicoService();
        
        if(this.atendimento.containsKey(atendimento.getCodigo())){
            System.out.println("Código já cadastrado.");
            return false;
        }
        
        Animal animal=atendimento.getAnimal();  //verifica se código do animal está cadastrado
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
        
        if(this.atendimento.containsKey(cod)){
            return atendimentoDAO.alterar(cod,atendimento);
        }
        System.out.println("Código não cadastrado");
        return false;
    }
    
    /**
     * Remove atendimento do bando de dados
     * @param cod - código do atendimento
     * @return true Se remoção for bem sucedida, false se ocorrer algum erro durante remoção
     */
    public boolean remover(int cod){
        if(this.atendimento.containsKey(cod)){
            return atendimentoDAO.remover(cod);
        }
        System.out.println("Código não cadastrado");
        return false; 
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
        for(int key : this.atendimento.keySet()){
            listagem+=this.atendimento.get(key);
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
        Animal animal;
        
        animal=animalService.getAnimal(cod); //puxa animal através do código
        if(animal!=null){
            float maior=0;
            int pos=0;
            
            for(int key : this.atendimento.keySet()){
                if(atendimento.get(key).getAnimal().equals(animal)){
                    if(atendimento.get(key).getServico().getValor()>maior){
                        maior=atendimento.get(key).getServico().getValor();
                        pos=key;
                    }
                }
            }
            
            
            if(maior!=0){
                return atendimento.get(pos); //retorna atendimento de acordo com posição salva anteriormente
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
        Animal animal;
        
        animal=animalService.getAnimal(cod); //puxa animal através do código
        if(animal!=null){
            float menor=9999999;
            int pos=0;
            
            for(int key : this.atendimento.keySet()){
                if(atendimento.get(key).getAnimal().equals(animal)){
                    if(atendimento.get(key).getServico().getValor()<menor){
                        menor=atendimento.get(key).getServico().getValor();
                        pos=key;
                    }
                }
            }
            
            if(menor!=0){
                return atendimento.get(pos); //retorna atendimento de acordo com posição salva anteriormente
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
        
        float total=0;
        
        Animal animal=animalService.getAnimal(cod);//puxa animal através do código
        if(animal!=null){
            
            for(int key : this.atendimento.keySet()){  //percorre banco de dados do atendimento procurando atendimentos com animal buscado
                if(atendimento.get(key).getAnimal().equals(animal)){
                    Servico servico=atendimento.get(key).getServico();
                    total+=servico.getValor()*animal.getTaxa(); //adiciona valor do serviço do atendimento
                }
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
        Animal animal=animalService.getAnimal(cod); //puxa animal através do código
        
        if(animal!=null){
            float total=0;
            String nota="";
            
           for(int key : this.atendimento.keySet()){ //percorre banco de dados do atendimento procurando atendimentos com animal buscado
                if(atendimento.get(key).getAnimal().equals(animal)){
                    if(total==0){
                        nota+="\n===========================\nNOTA FISCAL\n===========================\n"
                                +"Nome: "+animal.getNome()+"\nEndereço: "+animal.getEndereco()+"\nCidade: "
                                +animal.getCidade()+"\n===========================\n  ===ATENDIMENTOS===\n"
                                + "===========================";
                    }
                    Servico servico=atendimento.get(key).getServico();                            //adiciona dados no texto da nota fiscal
                    nota+="\nServiço: "+servico.getNome()+"\tValor: "+servico.getValor()*animal.getTaxa();
                    total+=servico.getValor()*animal.getTaxa();
                }
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
        Animal animal= atendimento.get(cod).getAnimal();
        Servico servico= atendimento.get(cod).getServico();
        
        return "\nAtendimento: "+atendimento.get(cod).getCodigo()+" "+animal.getNome()+" - "
                +servico.getNome()+" R$ "+servico.getValor()*animal.getTaxa();
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
        
        
        for(int key : this.atendimento.keySet()){ //percorre banco de dados dos atendimentos buscando períodos de tempo que ocorreram entre as datas digitadas
            if(datai.before(atendimento.get(key).getDate()) && dataf.after(atendimento.get(key).getDate())){
                if(retorno.equals("")){
                    retorno="\nRELATÓRIO - ATENDIMENTOS NO PERÍODO:"+ listaAtendimentos(key);
                }else{
                    retorno+=listaAtendimentos(key);
                }
            }
        }
        if(retorno.equals("")){
            return "Não há atendimentos entre esses períodos";
        }else{
            return retorno;
        }
    }
    
}
