package controller;

import java.util.Scanner;

public class LeitorEntrada {

    static Scanner scanner = new Scanner(System.in);

    public static int lerNumerosInteiros(String mensagemUsuario) {
        while (true) {
            System.out.println(mensagemUsuario);

            String entradaMensagem = scanner.nextLine();

            try {
                return Integer.parseInt(entradaMensagem);
                // a entrada so pode ser numero inteiro, nada de double ou string
            } catch (NumberFormatException e) {
                System.err.println("Somente números");
            }
        }
    }

    public static double lerNumerosQuebrados(String mensagemUsuario) {

        while (true){
            System.out.println(mensagemUsuario);

            String entradaMensagem = scanner.nextLine();

            try {
                return Double.parseDouble(entradaMensagem);
            } catch (NumberFormatException e){
                System.err.println("Use ponto para decimais! Exemplo: 1.20 ou 65.00");
            }
        }
    }

    public static String lerNomes(String entradaUsuario) {

        while (true) {
            System.out.println(entradaUsuario);
            String entradaMensagem = scanner.nextLine().trim();

            try {
            if (entradaMensagem.isEmpty()){
                throw new NumberFormatException("Nome não pode estar vazio.");
            } if (!entradaMensagem.matches("[a-zA-ZÀ-ÿ ]+")) {
                throw new NumberFormatException("Somente letras.");
            }

            return entradaMensagem;

            } catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }
        }
    }


    public static String lerCpf(String entradaUsuario){
        while (true){
            System.out.println(entradaUsuario);

            String entradaMensagem = scanner.nextLine();

            if (entradaMensagem.matches("\\d{11}")){
                return entradaMensagem;
            }else {
                System.out.println("CPF inválido!");
            }
        }
    }
}
