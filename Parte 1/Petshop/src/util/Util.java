package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Util {

    public Util() {
        
    }

    /**
     * Lê inteiro do teclado
     * @return valor lido
     */
    public static int leInteiro() {
        Scanner entrada;
        int valor = 0;
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.nextInt();
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    /**
     * Lê float do teclado
     * @return valor lido
     */
    public static float leFloat() {
        Scanner entrada;
        float valor = 0;
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.nextFloat();
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }

        }
        return valor;
    }

    /**
     * Lê string do teclado
     * @return valor lido
     */
    public static String leString() {
        Scanner entrada;
        String valor = "";
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.nextLine();
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    /**
     * Lê char do teclado
     * @return valor lido
     */
    public static char leChar() {
        Scanner entrada;
        char valor = 0;
        boolean erro = true;
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                valor = entrada.next().charAt(0);
                erro = false;
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    /**
     * Lê data do teclado
     * @return valor lido
     */
    public static Date leData() {
        Scanner entrada;
        Date valor = null;
        boolean erro = true;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        while (erro) {
            try {
                entrada = new Scanner(System.in);
                String dtString = entrada.next();
                valor = df.parse(dtString);
                erro = false;
                
            } catch (ParseException e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                entrada = null;
            }
        }
        return valor;
    }

    /**
     * converte string para date
     * @param dt - data digitada
     * @return data em Date
     */
    public static Date stringParaDate(String dt) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date retorno = null;
        try {
            retorno = df.parse(dt);
            return retorno;

        } catch (ParseException e) {
            System.out.println("Erro ao digitar a data. Tente novamente.");
            retorno = null;
            
            return retorno;
        }
    }

    /**
     * converte date para string
     * @param dt - data
     * @return data em string
     */
    public static String dateParaString(Date dt) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String retorno = null;
        try {
            retorno = df.format(dt);
        } catch (Exception e) {
            System.out.println("Erro ao converter a data. Tente novamente.");
            retorno = null;
        }
        return retorno;
    }

}
