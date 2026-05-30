package controller;

import enums.TipoPlano;
import exception.AlunoJaCadastradoException;
import model.Aluno;
import model.Plano;
import repository.PagamentoRepository;
import service.AlunoService;
import service.PlanoService;

import java.util.Optional;
import java.util.Scanner;

public class TelaInicial {
    int opcoes = 0;

    Scanner scanner = new Scanner(System.in);
    Plano plano;
    AlunoService alunoService;
    PlanoService planoService;
    GerenteController gerenteController;
    RecepcionistaController recepcionistaController;
    TelaSecundaria telaSecundaria;
    TelaTerciaria telaTerciaria;
    PagamentoRepository pagamentoRepository;
    public TelaInicial(AlunoService alunoService, GerenteController gerenteController,
                       RecepcionistaController recepcionistaController, PlanoService planoService,
                       TelaSecundaria telaSecundaria, TelaTerciaria telaTerciaria, PagamentoRepository pagamentoRepository){
        this.alunoService = alunoService;
        this.gerenteController = gerenteController;
        this.recepcionistaController = recepcionistaController;
        this.planoService = planoService;
        this.telaSecundaria = telaSecundaria;
        this.telaTerciaria = telaTerciaria;
        this.pagamentoRepository = pagamentoRepository;
    }

    public void opcoesMenu(){

        while (true) {
            do {
                opcoes = LeitorEntrada.lerNumerosInteiros("1 - Cadastrar | 2 - Login | 3 - Sair");

                if (opcoes >= 1 && opcoes <= 3) {
                    break;
                } else {
                    System.err.println("Escolher entre 1 e 3.");
                }
            } while (opcoes != 0);

            switch (opcoes) {
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
                    System.err.println("Apenas uma das 3 opcoes sao validas!");
            }
        }
    }

    public void criarConta(){

        String nome = LeitorEntrada.lerNomes("Nome:");
        String cpf = LeitorEntrada.lerCpf("CPF:");

        if (alunoService.buscarPorCpf(cpf).isPresent()){
          throw new AlunoJaCadastradoException("Aluno com este CPF, já cadastrado!");
        }
        double altura = LeitorEntrada.lerNumerosQuebrados("Altura:");
        double peso = LeitorEntrada.lerNumerosQuebrados("Peso:");

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
                    pagamentoFoiEfetuado = telaTerciaria.menuSecundario(planoMensal, nome, cpf, peso, altura);
                    break;
                case 2:
                    Plano planoTrimestral = planoService.buscarPorTipoPlano(TipoPlano.TRIMESTRAL);
                    telaSecundaria.mostrarPlano(TipoPlano.TRIMESTRAL);
                    pagamentoFoiEfetuado = telaTerciaria.menuSecundario(planoTrimestral, nome, cpf, peso, altura);
                    break;
                case 3:
                    Plano planoAnual = planoService.buscarPorTipoPlano(TipoPlano.ANUAL);
                    telaSecundaria.mostrarPlano(TipoPlano.ANUAL);
                    pagamentoFoiEfetuado = telaTerciaria.menuSecundario(planoAnual, nome, cpf, peso, altura);
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
            System.out.println("Faça o login.");
            login();
    }


    public void login() {
        while (true) {

            String nomeLogin = LeitorEntrada.lerNomes("Nome: ");
            String cpfLogin = LeitorEntrada.lerCpf("CPF: ");
            if (cpfLogin.equals("12345678910") && nomeLogin.equalsIgnoreCase("Ludmila")) {
                gerenteController.TelaGerente();
                break;
            } else if (cpfLogin.equals("98765432100") && nomeLogin.equalsIgnoreCase("Maria")) {
                recepcionistaController.TelaRecepcionista();
                break;
            } else {
                Optional<Aluno> aluno = alunoService.buscarPorCpf(cpfLogin);
                if (aluno.isPresent() && aluno.get().getCpf().equals(cpfLogin) && aluno.get().getNome().equalsIgnoreCase(nomeLogin)) {
                    AlunoController alunoController = new AlunoController(aluno.get(), pagamentoRepository);
                    alunoController.TelaAluno();
                    break;
                } else {
                    System.err.println("Nome e/ou CPF inválido.");
                }
            }

        }

    }

}