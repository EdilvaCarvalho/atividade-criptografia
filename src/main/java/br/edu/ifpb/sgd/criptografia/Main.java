package br.edu.ifpb.sgd.criptografia;

import java.util.Scanner;

/**
 *
 * @author Edilva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Para cifrar digite 1, para decifrar digite 2.");
        System.out.print(">> ");
        int opcao = entrada.nextInt();
        entrada = new Scanner(System.in);
        System.out.print("Digite seu texto aqui: ");
        String texto = entrada.nextLine();
        System.out.print("Digite sua chave aqui: ");
        int chave = entrada.nextInt();

        String alfabeto = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        char[] letras = alfabeto.toCharArray();
        char[] msg = texto.toCharArray();

        switch (opcao) {
            case 1:
                char[] textoCifrado = cifrar(msg, chave, letras);
                for (char c : textoCifrado) {
                    System.out.print(c);
                }
                break;
            case 2:
                char[] textoDecifrar = decifrar(msg, chave, letras);
                for (char c : textoDecifrar) {
                    System.out.print(c);
                }
                break;
        }

    }

    public static char[] cifrar(char[] texto, int chave, char[] alfabeto) {

        char[] textoCifrado = new char[texto.length];

        for (int i = 0; i < texto.length; i++) {
            boolean diferente = true;
            int l = 0;
            do {
                if (texto[i] == alfabeto[l]) {
                    textoCifrado[i] = alfabeto[l + chave];
                    diferente = false;
                }
                l++;
            } while (diferente);
        }

        return textoCifrado;
    }

    private static char[] decifrar(char[] texto, int chave, char[] alfabeto) {

        char[] textoDecifrado = new char[texto.length];

        for (int i = 0; i < texto.length; i++) {
            boolean diferente = true;
            int l = 0;
            do {
                if (texto[i] == alfabeto[l]) {
                    textoDecifrado[i] = alfabeto[l + 26 - chave];
                    diferente = false;
                }
                l++;
            } while (diferente);
        }

        return textoDecifrado;
    }
}
