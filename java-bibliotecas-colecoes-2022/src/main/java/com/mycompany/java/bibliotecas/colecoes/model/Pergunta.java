package com.mycompany.java.bibliotecas.colecoes.model;

import com.mycompany.java.bibliotecas.colecoes.util.Escrita;
import com.mycompany.java.bibliotecas.colecoes.util.Leitura;
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

    public void adicionaPergunta() {

        Scanner entrada = new Scanner(System.in);
        Leitura leitura = new Leitura();

        System.out.print("\nPor favor, digite a pergunta a ser adicionada: ");
        String pergunta = entrada.nextLine();

        setPerguntas(leitura.lerPergunta(getPerguntas()));

        perguntas.add("P" + (perguntas.size() + 1) + "|" + pergunta);
        retornaEscritaPergunta(perguntas);

    }

    public List<String> retornaEscritaPergunta(List<String> perguntas) {

        Escrita escrita = new Escrita();

        setPerguntas(escrita.escrevePergunta(perguntas));

        return getPerguntas();

    }

    public void removePergunta() {

        Scanner entrada = new Scanner(System.in);

        gravaPergunta();
        imprimePergunta();
        System.out.print("Por favor, selecione a pergunta a ser removida: ");
        int opcao = entrada.nextInt();

        if (opcao > 4) {
            perguntas.remove(opcao - 1);
            retornaEscritaPergunta(perguntas);
            System.out.println("Pergunta removida com sucesso!");
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
