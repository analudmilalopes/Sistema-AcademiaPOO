package controller;

import enums.TipoPlano;
import model.Aluno;
import model.Plano;
import service.AlunoService;
import service.PlanoService;

import java.util.Scanner;

public class TelaInicial {
    int opcoes = 0;

    Scanner scanner = new Scanner(System.in);
    Plano plano;
    AlunoService alunoService;
    PlanoService planoService;
    GerenteController gerenteController;
    TelaSecundaria telaSecundaria;
    TelaTerciaria telaTerciaria;
    public TelaInicial(AlunoService alunoService, GerenteController gerenteController, PlanoService planoService, TelaSecundaria telaSecundaria, TelaTerciaria telaTerciaria){
        this.alunoService = alunoService;
        this.gerenteController = gerenteController;
        this.planoService = planoService;
        this.telaSecundaria = telaSecundaria;
        this.telaTerciaria = telaTerciaria;
    }

    public void opcoesMenu(){

        do {
            opcoes = LeitorEntrada.lerNumerosInteiros("1 - Cadastrar | 2 - Login | 3 - Sair");

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
            case 2:
                login();
                break;
            case 3:
                System.out.println("Tchauzinho!!");
                System.exit(0);
                break;
            default:
                System.out.println("Apenas uma das 3 opcoes sao validas!");
        }

    }

    public void criarConta(){

        // aqui eu uso a classe menu principal com o try catch e chamo os metodos aqui, ao inves de ficar criando println
        String nome = LeitorEntrada.lerNomes("Nome:");

        String cpf = LeitorEntrada.lerCpf("CPF:");

        Double altura = LeitorEntrada.lerNumerosQuebrados("Altura:");

        Double peso = LeitorEntrada.lerNumerosQuebrados("Peso:");

        int opcoesPlano = 0;


        boolean pagamentoFoiEfetuado = false;
        while (!pagamentoFoiEfetuado) {
            // aqui vai mostrar a lista com cada plano, valor e duracao. ai a pessoa tb vai escolher um dos 3 planos
            System.out.println("Qual plano deseja?");
            do {
                opcoesPlano = LeitorEntrada.lerNumerosInteiros("1 - MENSAL\n" +
                        "2 - TRIMESTRAL\n" + "3 - ANUAL\n" + "4 - Ver todos os planos\n" + "5 - Sair");


                if (opcoesPlano >= 1 && opcoesPlano <= 5) {
                    break;
                } else {
                    System.out.println("Escolha uma das 5 opções!");
                }
            } while (opcoesPlano != 0);

            switch (opcoesPlano) {
                case 1:
                    Plano planoMensal = planoService.buscarPorTipoPlano(TipoPlano.MENSAL);
                    telaSecundaria.mostrarPlano(TipoPlano.MENSAL);
                    pagamentoFoiEfetuado = telaTerciaria.menuSecundario(planoMensal, nome, cpf);
                    break;
                case 2:
                    Plano planoTrimestral = planoService.buscarPorTipoPlano(TipoPlano.TRIMESTRAL);
                    telaSecundaria.mostrarPlano(TipoPlano.TRIMESTRAL);
                    pagamentoFoiEfetuado = telaTerciaria.menuSecundario(planoTrimestral, nome, cpf);
                    break;
                case 3:
                    Plano planoAnual = planoService.buscarPorTipoPlano(TipoPlano.ANUAL);
                    telaSecundaria.mostrarPlano(TipoPlano.ANUAL);
                    pagamentoFoiEfetuado = telaTerciaria.menuSecundario(planoAnual, nome, cpf);
                    break;
                case 4:
                    planoService.listaTodosPlanos();
                    break;
                case 5:
                    System.out.println("Até logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Apenas uma das 5 opções são validas!");
            }

        }
        if (pagamentoFoiEfetuado) {
            System.out.println("Cadastro realizado " + nome + "! Faça o login:");
            login();
        }
    }


    public void login() {
        while (true) {

            String nomeLogin = LeitorEntrada.lerNomes("Nome: ");
            String cpfLogin = LeitorEntrada.lerCpf("CPF: ");
            if (cpfLogin.equals("12345678910") && nomeLogin.equalsIgnoreCase("Ludmila")) {
                gerenteController.TelaGerente();
                break;
            } else {
                Aluno aluno = alunoService.buscarPorCpf(cpfLogin);
                if (aluno != null) {

                } else {
                    System.out.println("CPF não encontrado no sistema!");
                }
            }

        }

    }

}