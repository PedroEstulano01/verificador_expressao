/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.verificadorexpressao;

import java.util.LinkedList;
import java.util.Scanner;

public class VerificadorExpressao {

    // Função para verificar a correspondência de parênteses, colchetes e chaves
    public static boolean verificaExpressao(String expressao) {
        LinkedList<Character> pilha = new LinkedList<>();

        // Itera através dos caracteres da expressão fornecida
        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            // Verifica se o caractere atual é um parêntese, colchete ou chave de abertura
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere); // Adiciona o caractere atual à pilha
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                // Verifica se o caractere atual é um parêntese, colchete ou chave de fechamento
                if (pilha.isEmpty()) {
                    return false; // Retorna falso se a pilha estiver vazia
                }

                char topo = pilha.pop(); // Remove o caractere do topo da pilha
                // Verifica se há correspondência entre parênteses, colchetes ou chaves
                if ((caractere == ')' && topo != '(') ||
                        (caractere == ']' && topo != '[') ||
                        (caractere == '}' && topo != '{')) {
                    return false; // Retorna falso se não houver correspondência
                }
            }
        }

        return pilha.isEmpty(); // Retorna verdadeiro se a pilha estiver vazia (todos os pares foram fechados corretamente)
    }

    // Função principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma expressão matemática: ");
        String expressao = scanner.nextLine();

        // Verifica se a expressão está corretamente parametrizada e exibe uma mensagem correspondente
        if (verificaExpressao(expressao)) {
            System.out.println("Parece que a expressão está bem organizada! Legal!");
        } else {
            System.out.println("Oops! A expressão parece não estar bem organizada. Vamos tentar de novo!");
        }
    }
}