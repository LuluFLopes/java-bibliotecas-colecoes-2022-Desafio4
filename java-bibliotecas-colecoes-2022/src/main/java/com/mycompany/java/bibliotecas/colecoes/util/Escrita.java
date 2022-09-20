package com.mycompany.java.bibliotecas.colecoes.util;

import com.mycompany.java.bibliotecas.colecoes.util.Ferramentas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author lucme
 */
public class Escrita {

    /**
     * Veio da classe Pergunta
     * @param perguntas
     * @return 
     */
    public List<String> escrevePergunta(List<String> perguntas) {
        
        try {
            try ( PrintWriter pw = new PrintWriter("formulario.txt")) {
                perguntas.forEach(form -> pw.println(form));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        }
        
        return perguntas;
    }
    
    // Escrevendo o arquivo após preenchimento da lista.
    /**
     * Veio da classe formulário.
     * @param lista
     * @return 
     */
    public void escreveFormulario(List<String> lista) throws FileNotFoundException {
        
        File caminho = new File("C:\\Users\\lucme\\OneDrive\\Área de Trabalho\\Desafios Movimento Codar!\\java-bibliotecas-colecoes-2022-Desafio4\\Formularios");
        
        String arquivoBruto = (caminho.list().length + 1) + " - " + lista.get(0).toUpperCase();
        
        String arquivoIntermediario = arquivoBruto.trim();

        Ferramentas tiraAcentos =  new Ferramentas();
        
        String nomeArquivo = tiraAcentos.removerAcentos(arquivoIntermediario);
        
        PrintWriter pw = null;

            pw = new PrintWriter("C:\\Users\\lucme\\OneDrive\\Área de Trabalho\\Desafios Movimento Codar!\\java-bibliotecas-colecoes-2022-Desafio4\\Formularios\\" + nomeArquivo + ".txt");

            for (int i = 0; i < lista.size(); i++) {
                pw.println(lista.get(i));
            }
            
            pw.close();

    }

}
