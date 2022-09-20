package com.mycompany.java.bibliotecas.colecoes.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 *
 * @author lucme
 */
public class Ferramentas {

    public int validadorDeTipo(String resposta) {

        int idade;

        try {

            idade = Integer.parseInt(resposta);

        } catch (NumberFormatException ex) {

            return -1;

        }

        return idade;
    }

    public static String removerAcentos(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

}
