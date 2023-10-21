//GRUPO: Thomas Santos Pollarini, Carlos Costa

package visao;

import util.Cadastro;
import util.Login;
import util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.Animal;
import model.Atendimento;
import model.Servico;
import service.AnimalService;
import service.AtendimentoService;
import service.ServicoService;


/**
 *
 * @author alunos
 */
public class Principal {

    /**
     * Código principal
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        String user, password;

        System.out.println("=============================================");
        System.out.println("Bem vindo ao Sistema de Petshop BIXIM");
        System.out.println("=============================================");

        System.out.println("Usuario:");
        user = Util.leString();

        System.out.println("Senha:");
        password = Util.leString();
        
        if (Login.logar(user, password)) {//chama função logar para verificar usuario e senha

            int x = 1;

            while (true) {
                System.out.println("===================Menu de Opções===================\n"
                        + "1 -  Cadastro de Animal\n2 -  Cadastro de Serviço\n3 -  Lançamento de Atendimentos\n"
                        + "4 -  Listar dados dos Animais\n5 -  Listar dados dos Serviços\n"
                        + "6 -  Listar Atendimentos cadastrados\n7 -  Emitir nota fiscal\n"
                        + "8 -  Limpar banco de dados\n9 -  Relatório - Maior valor do atendimento do animal\n"
                        + "10 - Relatório - Menor valor do atendimento do animal\n"
                        + "11 - Relatório - Totalizar os atendimentos do animal\n"
                        + "12 - Relatório - Atendimento entre um período\n13 - Cadastrar usuário\n"
                        + "Digite zero para terminar");

                x = Util.leInteiro();

                switch (x) {

                    case 1:
                        menuAnimal(); //chama submenu dos animais
                        break;

                    case 2:
                        menuServico(); //chama submenu dos serviços
                        break;
                        
                    case 3:
                        lancaAtendimento(); //chama função que auxilia no lançamento de atendimentos
                        break;
                        
                    case 4:
                        listarAnimais(); //chama função auxiliar para listagem de animais
                        break;
                        
                    case 5:
                        listarServicos(); //chama função auxiliar para listagem de serviços
                        break;    
                        
                    case 6:
                        listarAtendimentos(); //chama função auxiliar para listagem de atendimentos
                        break;     
                        
                    case 7:
                        emitirNota();  //chama função auxiliar para emição de notas fiscais
                        break;
                        
                    case 8:
                        deletarBancoDeDados(); //chama função auxiliar para deletar banco de dados             
                        break;
                        
                    case 9:
                        maiorAtendimento();  //chama função auxiliar para verificar maior valor de atendimento de um animal
                        break;
                        
                    case 10:
                        menorAtendimento(); //chama função auxiliar para verificar menor valor de atendimento de um animal
                        break;
                     
                    case 11:
                        totalAtendimentos(); //chama função auxiliar para verificar valor total de atendimentos  de um animal
                        break;
                        
                    case 12:
                        atendimentosPeriodo();  //chama função auxiliar para verificar atendimentos durante um periodo de tempo
                        break;
                    case 13: 
                        cadastrarUsuario(); //chama função auxiliar para cadastrar novos logins
                        break;
                        
                    case 0:
                        System.out.println("Finalizando ...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

            }

        } else {
            System.out.println("Senha ou usuario incorretos."); //mensagem de erro caso login inicial não seja valido
            System.exit(0);
        }

    }

    /**
     * Submenu animal
     */
    public static void menuAnimal() {

        AnimalService animalService= new AnimalService();
        
        int x = 1,cod;

        while (true) {
            Animal animal= new Animal();
            
            System.out.println("===================Menu de Opções do Animal===================\n"
                    + "1 - Inserir Animal\n2 - Deletar Animal\n3 - Alterar Animal\n"
                    + "Digite zero para voltar ao menu anterior");

            x = Util.leInteiro();
            
            switch (x) {
                case 1:
                    
                    System.out.println("================");         //coleta dados do animal
                    System.out.println("CADASTRO ANIMAL");
                    System.out.println("================");
                    System.out.println("Insira seu código:");
                    animal.setCodigo(Util.leInteiro());
                    System.out.println("Nome do ANIMAL:");
                    animal.setNome(Util.leString());
                    System.out.println("Endereço do ANIMAL:");
                    animal.setEndereco(Util.leString());
                    System.out.println("Cidade do ANIMAL:");
                    animal.setCidade(Util.leString());
                    
                    if(animalService.inserir(animal)){             //chama inserir do AnimalService
                        System.out.println("Dados inseridos com sucesso."); 
                    }else{
                        System.out.println("Falha ao inserir dados.");
                    }
                    
                    
                    
                    break;
                
                case 2:
                    System.out.println("================");
                    System.out.println("DELETAR ANIMAL");
                    System.out.println("================");
                    System.out.println("Informe o codigo do animal que sera deletado:");
                    cod=Util.leInteiro();               //coleta dados
                   
                    if(animalService.remover(cod)){         //chama remover do animalService
                        System.out.println("Dados deletados com sucesso."); 
                    }else{
                        System.out.println("Falha ao deletar dados.");
                    }
                    
                    break;
                    
                case 3:
                    System.out.println("================");     //coleta dados para alteração
                    System.out.println("ALTERAR ANIMAL");
                    System.out.println("================");
                    System.out.println("Informe o codigo do animal que sera alterado:");
                    animal.setCodigo(Util.leInteiro());
                    System.out.println("Novo nome do ANIMAL:");
                    animal.setNome(Util.leString());
                    System.out.println("Novo endereço do ANIMAL:");
                    animal.setEndereco(Util.leString());
                    System.out.println("Nova cidade do ANIMAL:");
                    animal.setCidade(Util.leString());
                    
                    if(animalService.alterar(animal.getCodigo(), animal)){  //chama alterar do animalService
                        System.out.println("Dados alterados com sucesso.");
                    }else{
                        System.out.println("Falha ao alterar dados.");
                    }
                    break;
                    
                case 0:
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }

    }

    /**
     * Submenu serviço
     */
    public static void menuServico() {

        ServicoService servicoService= new ServicoService();
        
        
        int x = 1,cod;

        while (true) {
            Servico servico= new Servico();
            
            System.out.println("===================Menu de Opções do Serviço===================\n"
                    + "1 - Inserir Serviço\n2 - Deletar Serviço\n3 - Alterar Serviço\n"
                    + "Digite zero para voltar ao menu anterior");

            x = Util.leInteiro();

            switch (x) {

                case 1:
                    
                    System.out.println("================"); //coleta dados de serviço
                    System.out.println("CADASTRO SERVIÇO");
                    System.out.println("================");
                    System.out.println("Insira seu código:");
                    servico.setCodigo(Util.leInteiro());
                    System.out.println("Nome do SERVIÇO:");
                    servico.setNome(Util.leString());
                    System.out.println("Valor do SERVIÇO:");
                    servico.setValor(Util.leFloat());
                    
                    if(servicoService.inserir(servico)){        //chama inserir do servicoService
                        System.out.println("Dados inseridos com sucesso."); 
                    }else{
                        System.out.println("Falha ao inserir dados.");
                    }
                    
                    
                    
                    break;
                
                case 2:
                    System.out.println("================");
                    System.out.println("DELETAR SERVIÇO");      //coleta dados
                    System.out.println("================");
                    System.out.println("Informe o codigo do serviço que sera deletado:");
                    cod=Util.leInteiro();
                   
                    if(servicoService.remover(cod)){    //chama remover do servicoService
                        System.out.println("Dados deletados com sucesso."); 
                    }else{
                        System.out.println("Falha ao deletar dados.");
                    }
                    
                    break;
                    
                case 3:
                    System.out.println("================");     //coleta dados de serviço
                    System.out.println("ALTERAR SERVIÇO");
                    System.out.println("================");
                    System.out.println("Informe o codigo do serviço que sera alterado:");
                    servico.setCodigo(Util.leInteiro());
                    System.out.println("Novo nome do SERVIÇO:");
                    servico.setNome(Util.leString());
                    System.out.println("Valor do SERVIÇO:");
                    servico.setValor(Util.leFloat());
                    
                    if(servicoService.alterar(servico.getCodigo(), servico)){   //chama alterar do servicoService
                        System.out.println("Dados alterados com sucesso.");
                    }else{
                        System.out.println("Falha ao alterar dados.");
                    }
                    
                    break;
                    
                case 0:
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        }

    }
    
    /**
     * Auxilia no lançamento de atendimentos
     */
    public static void lancaAtendimento(){
        
        AtendimentoService atendimentoService= new AtendimentoService();
        
        Atendimento atendimento= new Atendimento();
        
        System.out.println("=================\nLANÇAR ATENDIMENTO\n=================\nInsira seu código:");
        atendimento.setCodigo(Util.leInteiro());
        
        System.out.println("Insira o código do animal: ");
        atendimento.setAnimalCodigo(Util.leInteiro());
        
        System.out.println("Insira o código do serviço: ");     //coleta dados para atendimento
        atendimento.setServicoCodigo(Util.leInteiro());
        
        System.out.println("Insira a data (dd/mm/aaaa): ");
        atendimento.setDate(Util.leData());

        if(atendimentoService.inserir(atendimento)){            //chama inserir do atendimento
            System.out.println("Dados inseridos com sucesso.");
        }else{
            System.out.println("Falha ao inserir dados.");
        }
    }
    
    /**
     * Auxilia na listagem de animais
     */
    public static void listarAnimais(){
    
        System.out.println("================================\nLISTAGEM DE ANIMAIS CADASTRADOS\n================================\n"
                            +"Deseja realmente imprimir o relatório? (S/N)");
        char resposta=Util.leChar();
                                    
        switch(resposta){
            case 'S':
            case 's':
                AnimalService animalService= new AnimalService();
                String listagem = animalService.toString();     //chama toString do animalService
                
                if(!listagem.equals("")){           //confere se o retorno é diferente de nulo
                    System.out.println(listagem);
                }else{
                    System.out.println("Não existem animais cadastrados no sistema!");
                }
                break;
             
            case 'N':
            case 'n':
                System.out.println("Retornando ao menu...");
                break;
            
            default:
                System.out.println("Opção inválida");
                break;
        }
        
        return;
    }

    /**
     * Auxilia na listagem de serviços
     */
    public static void listarServicos(){
    
        System.out.println("=================================\nLISTAGEM DE SERVIÇOS CADASTRADOS\n=================================\n"
                            +"Deseja realmente imprimir o relatório? (S/N)");
        char resposta=Util.leChar();
                                    
        switch(resposta){
            case 'S':
            case 's':
                ServicoService servicoService= new ServicoService();
                String listagem = servicoService.toString();    //chama toString do servicoService
                
                if(!listagem.equals("")){       //confere se o retorno é diferente de nulo
                    System.out.println(listagem); 
                }else{
                    System.out.println("Não existem serviços cadastrados no sistema!");
                }
                break;
             
            case 'N':
            case 'n':
                System.out.println("Retornando ao menu...");
                break;
            
            default:
                System.out.println("Opção inválida");
                break;
        }
        
        return;
    }
    
    /**
     * Auxilia na listagem de atendimentos
     */
    public static void listarAtendimentos(){
    
        System.out.println("====================================\nLISTAGEM DE ATENDIMENTO CADASTRADOS\n====================================\n"
                            +"Deseja realmente imprimir o relatório? (S/N)");
        char resposta=Util.leChar();
                                    
        switch(resposta){
            case 'S':
            case 's':
                AtendimentoService atendimentoService= new AtendimentoService();
                String listagem = atendimentoService.toString();  //chama toString do atendimentoService
                
                 if(!listagem.equals("")){      //confere se o retorno é diferente de nulo
                    System.out.println(listagem); 
                }else{
                    System.out.println("Não existem atendimentos cadastrados no sistema!");
                }
                break;
             
            case 'N':
            case 'n':
                System.out.println("Retornando ao menu...");
                break;
            
            default:
                System.out.println("Opção inválida");
                break;
        }
        
        return;
    }
    
    /**
     * Auxilia na emição de notas fiscais
     */
    public static void emitirNota(){
        AtendimentoService atendimentoService= new AtendimentoService();
        
        System.out.println("Digite o código do animal: ");
        String nota=atendimentoService.getNotaFiscal(Util.leInteiro()); //chama getNotaFiscal do atendimentoService 
        System.out.println(nota);                                       //de acordo com a leitura
        
        return;
    }
    
    /**
     * Auxilia a deletar banco de dados
     */
    public static void deletarBancoDeDados(){
        
        System.out.println("=======================\nDELETAR BANCO DE DADOS\n=======================\n"
                          + "Deseja Realmente APAGAR todos os dados cadastrados? (S/N)");
        
        char resposta=Util.leChar();
                                    
        switch(resposta){
            case 'S':
            case 's':
                AtendimentoService atendimentoService= new AtendimentoService();
                AnimalService animalService= new AnimalService();
                ServicoService servicoService= new ServicoService();
                
                animalService.limpaDados();         //chama limpaDados de todos os Services
                atendimentoService.limpaDados();
                servicoService.limpaDados();
                
                System.out.println("Banco de Dados deletado com sucesso");
                break;
             
            case 'N':
            case 'n':
                System.out.println("Retornando ao menu...");
                break;
            
            default:
                System.out.println("Opção inválida");
                break;
        }
        
        return;
    }
    
    /**
     * Auxilia na procura de maior atendimento
     */
    public static void maiorAtendimento(){
        
        AtendimentoService atendimentoService= new AtendimentoService();
        
        System.out.println("Digite o código do animal: ");
        Atendimento atendimento=atendimentoService.getMaiorAtendimento(Util.leInteiro()); //Chama getMaiorAtendimento 
        //inicia atendimento com retorno da função
        
        if(atendimento!=null){ //verifica se retorno foi nulo
            Servico servico=atendimento.getServico();
            
            System.out.println("RELATÓRIO - ATENDIMENTO DE MAIOR VALOR: "+servico.getNome()+" Valor: "+ servico.getValor());
        }else{
            System.out.println("Falha ao buscar atendimento");
        }
        
        return;
    }
    
    /**
     * Auxilia na procura de menor atendimento
     */
    public static void menorAtendimento(){
        AtendimentoService atendimentoService= new AtendimentoService();
        
        System.out.println("Digite o código do animal: ");
        Atendimento atendimento=atendimentoService.getMenorAtendimento(Util.leInteiro()); //Chama getMenorAtendimento
        //inicia atendimento com retorno da função
        
        if(atendimento!=null){  //verifica se retorno foi nulo
            Servico servico=atendimento.getServico(); 
            
            System.out.println("RELATÓRIO - ATENDIMENTO DE MENOR VALOR: "+servico.getNome()+" Valor: "+ servico.getValor());
        }else{
            System.out.println("Falha ao buscar atendimento");
        }
        
        return;
    }
    
    /**
     * Auxilia a busca de valor total no atendimento de um animal
     */
    public static void totalAtendimentos(){
        AtendimentoService atendimentoService= new AtendimentoService();
        
        System.out.println("Digite o código do animal: ");
        float total=atendimentoService.getTotalDosAtendimentos(Util.leInteiro()); //Chama getTotalDosAtendimento
        //retorna o valor para variável total
        
        if(total!=0){
            System.out.println("RELATÓRIO - O TOTAL DOS ATENDIMENTOS DO ANIMAL É: R$ "+ total);
        }else{
            System.out.println("Falha ao buscar atendimento");
        }
        
        return;
    }
    
    /**
     * Auxilia na procura atendimentos por determinados períodos
     */
    public static void atendimentosPeriodo(){
        AtendimentoService atendimentoService= new AtendimentoService();
        
        System.out.println("Insira a data inicial (dd/mm/aaaa):");
        String datai = Util.leString();
        System.out.println("Insira a data final (dd/mm/aaaa) :");
        String dataf = Util.leString();         //coleta periodo de tempo 
        
        String retorno=atendimentoService.getAtendimentosPorPeriodo(datai,dataf);//chama função getAtendimentosPorPeriodo
        
        System.out.println(retorno);
        
        return;
    }

    /**
     * Auxilia no cadastro de novos logins
     */
    public static void cadastrarUsuario() throws FileNotFoundException {
        String user,password;
        System.out.println("Insira o usuario: ");
        user = Util.leString();
        System.out.println("Insira a senha: ");         //coleta dados para novo login
        password = Util.leString();
        
        if(Cadastro.cadastrar(user, password)){     //chama função cadastrar
            System.out.println("Cadastro realizado com sucesso");
        }else{
            System.out.println("Erro ao cadastrar o usuario");
        }
        
        return;
    }
}
        