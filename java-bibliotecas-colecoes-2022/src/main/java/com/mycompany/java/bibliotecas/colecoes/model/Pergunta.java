package com.mycompany.java.bibliotecas.colecoes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lucme
 */
public class Pergunta {

    private static List<String> perguntas;

    public void gravaPergunta() {

        Leitura leitura = new Leitura();
        setPerguntas(leitura.lerPergunta(perguntas));

    }

    public void imprimePergunta() {

        int i = 1;
        for (String form : perguntas) {
            System.out.println(i++ + " - " + form);
        }

    }

    public void adicionaPergunta(String pergunta) {
        
        Leitura leitura = new Leitura();
        
        setPerguntas(leitura.lerPergunta(perguntas));
        
        perguntas.add("P" + (perguntas.size() + 1) + "|" + pergunta);
        retornaEscritaPergunta();

    }

    public void escrevePergunta() {

        Escrita escrita = new Escrita();
        
        List<String> perguntas = new ArrayList();

        setPerguntas(escrita.escrevePergunta());

    }

    public List<String> retornaEscritaPergunta(List<String> perguntas) {
        Escrita escrita = new Escrita();

        setPerguntas(escrita.escrevePergunta());

        return getPerguntas();

    }

    public List<String> retornaEscritaPergunta() {
        Escrita escrita = new Escrita();

        setPerguntas(escrita.escrevePergunta());

        return getPerguntas();

    }

    public void removePergunta() {

        Scanner entrada = new Scanner(System.in);

        imprimePergunta();
        System.out.print("Por favor, selecione a pergunta a ser removida: ");
        int opcao = entrada.nextInt();

        if (opcao > 4) {
            perguntas.remove(opcao - 1);
            retornaEscritaPergunta();
        } else {
            System.out.println("\nNão é possível remover perguntas padrão do sistema!");
        }

    }

    public static List<String> getPerguntas() {
        return perguntas;
    }

    public static void setPerguntas(List<String> perguntas) {
        Pergunta.perguntas = perguntas;
    }

}
