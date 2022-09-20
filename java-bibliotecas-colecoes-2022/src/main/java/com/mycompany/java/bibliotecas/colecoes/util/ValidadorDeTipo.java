package com.mycompany.java.bibliotecas.colecoes.util;

/**
 *
 * @author lucme
 */
public class ValidadorDeTipo {

    public int converte(String resposta) {
        
        int idade;
        
        try {

            idade = Integer.parseInt(resposta);

        } catch (NumberFormatException ex) {

            return -1;

        }

        return idade;
    }

}
