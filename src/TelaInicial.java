import model.Plano;

import java.util.Scanner;

public class TelaInicial {



    int opcoes = 0;

    Scanner scanner = new Scanner(System.in);
    Plano plano;

    public void opcoesMenu(){

        do {
            opcoes = MenuPrincipal.lerNumerosInteiros("1 - Cadastrar | 2 - Login | 3 - Sair");

            if (opcoes >= 1 && opcoes <= 3){
                break;
            }else {
                System.out.println("Escolher entre 1 e 3.");
            }
        }while (opcoes !=0);

        switch (opcoes){
            case 1:
                criarConta();
                break;
            default:
                System.out.println("Apenas uma das 3 opcoes sao validas!");
        }

    }

    public void criarConta(){

        // aqui eu uso a classe menu principal com o try catch e chamo os metodos aqui, ao inves de ficar criando println
        String nome = MenuPrincipal.lerNomes("Nome: ");

        String cpf = MenuPrincipal.lerCpf("CPF: ");

        int opcoesPlano = 0;


        // aqui vai mostrar a lista com cada plano, valor e duracao. ai a pessoa tb vai escolher um dos 3 planos
        System.out.println("Qual plano deseja?");
        do {
            opcoesPlano = MenuPrincipal.lerNumerosInteiros("1 - MENSAL\n" +
                    "2 - TRIMESTRAL\n" + "3 - ANUAL");


            if (opcoesPlano >= 1 && opcoes <= 3){
                break;
            }else {
                System.out.println("Escolher um dos 3 planos.");
            }
        }while (opcoesPlano !=0);

        switch (opcoesPlano){
            case 1:
               // criarConta(); planoMensal();
                break;
            default:
                System.out.println("Apenas uma das 3 opcoes sao validas!");
        }
    }


    public void login(){

        String cpf = MenuPrincipal.lerCpf("CPF: ");
    }


   // public void planoMensal(){
    //
    //    }

}