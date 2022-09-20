package com.mycompany.java.bibliotecas.colecoes.main;

import com.mycompany.java.bibliotecas.colecoes.util.Escrita;
import com.mycompany.java.bibliotecas.colecoes.model.Pergunta;
import com.mycompany.java.bibliotecas.colecoes.model.Formulario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lucme
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        Pergunta pergunta = new Pergunta();
        Formulario formulario = new Formulario();
        Escrita escrita = new Escrita();
        List<String> questoes = new ArrayList<>();

        boolean itera = true;

        while (itera) {
            System.out.println("\n1 - Candidatar-se.");
            System.out.println("2 - Adicionar pergunta ao formulário.");
            System.out.println("3 - Remover pergunta do formulário.");
            System.out.println("4 - Listar formulários cadastrados.");
            System.out.println("5 - Pesquisar repetições.");
            System.out.println("6 - Pesquisar cadastro.");
            System.out.println("7 - Sair");

            System.out.print("\nPor favor, selecione uma opção: ");
            int opcao = entrada.nextInt();
            
            System.out.println("");

            switch (opcao) {
                case 1:

                    questoes = pergunta.retornaEscritaPergunta(questoes);

                    List<String> respostas = formulario.percorreLista(questoes);

                    escrita.escreveFormulario(respostas);

                    break;
                case 2:

                    pergunta.adicionaPergunta();

                    break;
                case 3:

                    pergunta.removePergunta();

                    break;
                case 4:

                    boolean iteraSub = true;

                    while (iteraSub) {

                        System.out.println("\n1 - Listar organizando por idade.");
                        System.out.println("2 - Listar agrupando por idade.");
                        System.out.println("3 - Retornar ao menu principal.");

                        System.out.print("\nPor favor, seleciona a opção desejada: ");
                        int exibeListas = entrada.nextInt();

                        switch (exibeListas) {

                            case 1:
                                formulario.organizaMatriz();
                                formulario.imprimeMatriz();
                                iteraSub = false;
                                break;
                            case 2:
                                formulario.organizaMatriz();
                                formulario.imprimeMatrizIdade();
                                iteraSub = false;
                                break;
                            case 3:
                                iteraSub = false;
                                break;
                            default:
                                System.out.print("\nValor inválido!");
                        }
                    }

                    break;
                case 5:

                    System.out.println("Formulários repetidos: ");

                    formulario.organizaMatriz();
                    formulario.buscaDuplicado();

                    break;
                case 6:

                    if (formulario.pesquisaFormulario()) {
                        System.out.println("\nCadastro existente!");
                    } else {
                        System.out.println("\nNão cadastrado!");
                    }

                    break;
                case 7:
                    System.out.println("Obrigado por utilizar o nosso sistema! Volte Sempre!");
                    itera = false;
                    break;
                default:
                    System.out.println("\nValor inválido!\n");
            }

        }

    }

}
