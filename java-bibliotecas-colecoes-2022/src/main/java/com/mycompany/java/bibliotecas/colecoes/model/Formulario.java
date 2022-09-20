package com.mycompany.java.bibliotecas.colecoes.model;

import com.mycompany.java.bibliotecas.colecoes.util.Escrita;
import com.mycompany.java.bibliotecas.colecoes.util.Leitura;
import com.mycompany.java.bibliotecas.colecoes.util.Ferramentas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lucme
 */
public class Formulario {

    private List<String> formulario;
    private static List<List<String>> listaFormulario = new ArrayList<>();

    public boolean pesquisaFormulario() {

        Scanner entrada = new Scanner(System.in);

        System.out.print("\nPor favor, digite o nome: ");
        String nome = entrada.nextLine();

        System.out.print("\nPor favor, digite o email: ");
        String email = entrada.nextLine();

        for (List<String> form : listaFormulario) {

            if (form.get(0).equals(nome) && form.get(1).equals(email)) {
                return true;
            }
        }

        return false;

    }

    public void buscaDuplicado() {

        List<List<String>> listaAuxiliar = new ArrayList<>();
        List<List<String>> listaDuplicada = new ArrayList<>();
        List<List<String>> listaFormatada = new ArrayList<>();

        for (List<String> forms : listaFormulario) {

            List<String> formDuplicado = new ArrayList();

            formDuplicado.add(forms.get(0));
            formDuplicado.add(forms.get(1));
            formDuplicado.add(forms.get(2));
            formDuplicado.add(forms.get(3));
            formDuplicado.add("0");

            int contador = 0;

            for (List<String> form : listaFormulario) {
                if (!form.get(1).equals(listaFormulario.get(contador))) {
                    listaAuxiliar.add(formDuplicado);
                }
                contador++;
                break;
            }
        }

        for (int i = 0; i < listaAuxiliar.size(); i++) {
            String email = listaAuxiliar.get(i).get(1);
            for (List<String> lista : listaAuxiliar) {
                if (email.equals(lista.get(1))) {
                    lista.set(4, Integer.toString(Integer.parseInt(lista.get(4)) + 1));
                }
            }
        }

        for (List<String> lista : listaAuxiliar) {
            if (Integer.parseInt(lista.get(4)) >= 2) {
                lista.remove(4);
                listaDuplicada.add(lista);
            }
        }

        listaDuplicada.forEach(System.out::println);

    }

    public void organizaMatriz() throws IOException {

        Leitura leitura = new Leitura();

        listaFormulario = leitura.preencheMatriz();

        listaFormulario.sort((form1, form2) -> {
            return form1.get(2).compareTo(form2.get(2));
        });

    }

    // Impressao organizada.
    public void imprimeMatriz() {

        listaFormulario.forEach(System.out::println);
    }

    // Impressão por idade.
    public void imprimeMatrizIdade() {

        Set<String> memoriaIdade = new HashSet<>();

        for (int i = 0; i < listaFormulario.size(); i++) {
            int contador = 0;
            int idadeAux = Integer.parseInt(listaFormulario.get(i).get(2));
            for (int j = 0; j < listaFormulario.size(); j++) {

                if (idadeAux == Integer.parseInt(listaFormulario.get(j).get(2))) {
                    contador++;

                }
            }

            if (!memoriaIdade.contains(Integer.toString(idadeAux))) {
                System.out.printf("\nIdade: %d - Registros: %d", idadeAux, contador);
            }

            memoriaIdade.add(Integer.toString(idadeAux));

        }
        
        System.out.println(" ");

    }

    // Percorrendo as perguntas.
    public List<String> percorreLista(List<String> lista) {

        List<String> formulario = new ArrayList<String>();

        for (String posicao : lista) {
            System.out.print(posicao + " ");
            try {
                formulario = gravaInfo(formulario);
            } catch (Exception ex) {
                formulario = null;
                break;
            }
        }

        return formulario;

    }

    // Gravando as respostas em lista.
    public List<String> gravaInfo(List<String> formulario) throws Exception {
        Scanner entrada = new Scanner(System.in);
        String resposta = entrada.nextLine();
        if (validaIdade(resposta)) {
            formulario.add(resposta);
        }

        return formulario;
    }

    // Validando a idade do candidato.
    public boolean validaIdade(String resposta) throws Exception {
        Ferramentas validador = new Ferramentas();
        int idade = validador.validadorDeTipo(resposta);

        if (idade > 0 && idade < 16) {
            System.out.println("\nMuito obrigado por seu interesse de estar com a gente!");
            System.out.println("Infelizmente, você não tem a idade mínima de 16 anos para participar.");
            System.out.println("Tente novamente quando chegar na idade permitida.\n");
            throw new Exception("Idade minima não alcançada!");
        } else {
            return true;
        }
    }

    public boolean validaEscrita() {

        Escrita escrita = new Escrita();

        try {
            escrita.escreveFormulario(getFormulario());
        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possível escrever o arquivo!");
            return false;
        }
        
        return true;
    }

    public List<String> getFormulario() {
        return formulario;
    }

    public void setFormulario(List<String> formulario) {
        this.formulario = formulario;
    }

    public List<List<String>> getListaFormulario() {
        return listaFormulario;
    }

    public void setListaFormulario(List<List<String>> listaFormulario) {
        Formulario.listaFormulario = listaFormulario;
    }

}
