package com.mycompany.java.bibliotecas.colecoes.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucme
 */
public class Leitura {
    
    /**
     * Vem da classe Formulário
     * Preenchendo a matriz com os arquivos para organizar.
     * @return
     * @throws IOException 
     */
    public List<List<String>> preencheMatriz() throws IOException {

        File caminho = new File("C:\\Users\\lucme\\OneDrive\\Área de Trabalho\\Desafios Movimento Codar!\\java-bibliotecas-colecoes-2022-Desafio4\\Formularios");
        List<List<String>> listaFormulario = new ArrayList<>();

        List<String> formulario;

        String[] forms = caminho.list();

        for (int i = 0; i < forms.length; i++) {
            try {

                BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\lucme\\OneDrive\\Área de Trabalho\\Desafios Movimento Codar!\\java-bibliotecas-colecoes-2022-Desafio4\\Formularios\\" + forms[i]));
                formulario = new ArrayList<String>();

                String linha = "";

                while (linha != null) {
                    linha = bf.readLine();
                    if (linha != null && !linha.equals("")) {
                        formulario.add(linha);
                    }
                }

                listaFormulario.add(formulario);

            } catch (FileNotFoundException ex) {
                System.out.println("Não foi possível ler o arquivo.");
            }
        }

        return listaFormulario;
    }
    
    
    /**
     * Vem da classe Perguntas
     * @param perguntas
     * @return 
     */
    public List<String> lerPergunta(List<String> perguntas) {

        perguntas = new ArrayList<>();

        try {
            BufferedReader buff = new BufferedReader(new FileReader("formulario.txt"));

            String linha = "";

            while (linha != null) {
                linha = buff.readLine();

                if (linha != null && !linha.equals("")) {
                    perguntas.add(linha);
                }

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Não foi possível realizar a leitura!");
        }

        return perguntas;
    }

}
