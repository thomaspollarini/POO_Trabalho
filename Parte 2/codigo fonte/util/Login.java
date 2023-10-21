package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    
    private static final String user= "jj";
    private static final String password= "jj";

    
    public Login() {
    }
    
    /**
     * Verifica se login é aceito no programa
     * @param user - nome do usuário
     * @param password - senha do usuário
     * @return true se login foi feito com sucesso, false se houve erro ao realizar login
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static boolean logar(String user,String password) throws FileNotFoundException, IOException{
        /*File file = new File("E:\\Arquivos\\PetshopBIXIM\\Petshop\\src\\cadastro.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        List<String> lista = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            lista.add(line);
        }
        for(int i = 0; i < lista.size(); i++){
            String usuario = lista.get(i);
            String senha = lista.get(i+1);
            i++;
            if(usuario.equals(user)&&senha.equals(password)){
                return true;
            }
        }*/
        
        if(Login.user.equals(user) && Login.password.equals(password)){
            return true;
        }
        return false;
    }
    
}