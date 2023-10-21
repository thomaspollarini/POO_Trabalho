package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Cadastro {
    public Cadastro() throws FileNotFoundException {
        
    }
    
    /**
     * Cadastra novo usuário e senha
     * @param user - nome do usuário
     * @param password - senha do usuário
     * @return true se login foi cadastrado com sucesso, false se ocorreu um erro no cadastro
     */
    public static boolean cadastrar(String user, String password){
        String teste = new String();
        teste += "\n"+user + "\n"+password;
        byte[] b = teste.getBytes();
        Path caminho;
        caminho = Paths.get("src\\cadastro.txt");
        try {
            Files.write(caminho, b, StandardOpenOption.APPEND);
            return true;
        } catch (IOException erro) {
            System.out.println("Erro na abertura do programa");
        }

        return false;
    }
}
