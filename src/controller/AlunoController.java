package controller;

import enums.TipoPlano;
import model.Aluno;
import model.Pagamento;
import repository.PagamentoRepository;

import java.util.Scanner;

public class AlunoController {

    Aluno aluno;
    TipoPlano tipoPlano;
    Pagamento pagamento;
    PagamentoRepository pagamentoRepository;
    Scanner scanner = new Scanner(System.in);

    public AlunoController(Aluno aluno, PagamentoRepository pagamentoRepository){
        this.aluno = aluno;
        this.pagamentoRepository = pagamentoRepository;
    }
    public void TelaAluno(){

        while (true) {
            int opcoesAluno;

            do {

                opcoesAluno = LeitorEntrada.lerNumerosInteiros("1 - Ver meus treinos\n" +
                        "2 - Ver meu IMC\n" + "3 - Ver dados do pagamento\n"
                        + "4 - Sair");

                if (opcoesAluno >= 1 && opcoesAluno <= 4) {
                    break;
                } else {
                    System.out.println("Escolha uma das 4 opções!");
                }
            } while (opcoesAluno != 0);

            switch (opcoesAluno) {
                case 1:
                    treinosDaSemana(aluno.getPlano().getTipoPlano());
                    break;
                case 2:
                    verIMC(aluno);
                    imcAlto(aluno);
                    break;
                case 3:
                    verPagamento(pagamentoRepository.buscarPorCpf(aluno.getCpf()));
                    break;
                case 4:
                    System.out.println("Até logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Apenas uma das 4 opções são válidas!");

            }
        }
    }

    public void treinosDaSemana(TipoPlano tipoPlano){
        System.out.println("MEU TREINO");

        switch (tipoPlano){
            case MENSAL:
                System.out.println("Segunda: Peito e Tríceps\n" +
                        "Terça: Costas e Bíceps\n" +
                        "Quarta: Descanso\n" +
                        "Quinta: Pernas\n" +
                        "Sexta: Ombro e Abdômen\n" +
                        "Sábado: Cardio leve\n" +
                        "Domingo: Descanso");
                break;
            case TRIMESTRAL:
                System.out.println("Segunda: Peito, Tríceps e Ombro\n" +
                    "Terça: Costas e Bíceps\n" +
                    "Quarta: Pernas\n" +
                    "Quinta: Peito e Tríceps\n" +
                    "Sexta: Costas, Bíceps e Abdômen\n" +
                    "Sábado: Cardio + Core\n" +
                    "Domingo: Descanso");
                break;
            case ANUAL:
                System.out.println("Segunda: Quadríceps e Posterior\n" +
                    "Terça: Costas, Bíceps e Trapézio\n" +
                    "Quarta: Pernas e Glúteos\n" +
                    "Quinta: Peito e Ombro\n" +
                    "Sexta: Costas e Bíceps\n" +
                    "Sábado: Panturrilha, Abdômen e Cardio HIIT\n" +
                    "Domingo: Descanso ativo com alongamento");
                break;
        }
    }

    public void verIMC(Aluno aluno){
        double IMC = aluno.getPeso()
                / (aluno.getAltura() * aluno.getAltura());

        if (IMC < 18.5){
            System.out.printf("IMC = %.2f, você está abaixo do peso.%n", IMC);

        } else if (IMC <= 24.9) {
            System.out.printf("IMC = %.2f, você está com o peso normal.%n", IMC);
        } else if (IMC <= 29.9) {
            System.out.printf("IMC = %.2f, você está sobrepeso.%n", IMC);
        }else if (IMC <= 34.9){
            System.out.printf("IMC = %.2f, você está com obesidade grau 1.%n", IMC);
        } else if (IMC <= 39.9) {
            System.out.printf("IMC = %.2f, você está com obesidade grau 2.%n", IMC);
        }else {
            System.out.printf("IMC = %.2f, você está com obesidade grau 3.%n", IMC);
        }

        //
    }

    public void imcAlto(Aluno aluno){
        double IMC = aluno.getPeso() / (aluno.getAltura() * aluno.getAltura());

        if (IMC > 29.9 && IMC <= 34.9) {
            System.out.println("Recomendação: Devido ao seu IMC alto," +
                    " é indicado aumentar mais 20 minutos no seu cardio e fazer déficit calórico!");
        } else if (IMC <= 39.9) {
            System.out.println("Recomendação: Devido ao seu IMC alto," +
                    " é indicado aumentar mais 30 minutos no seu cardio e fazer déficit calórico!");
        } else {
            System.out.println("Recomendação: Devido ao seu IMC alto," +
                    " é indicado aumentar mais 35 minutos no seu cardio e fazer déficit calórico!");
        }
    }

    public void verPagamento(Pagamento pagamento){
        System.out.println("-------- \uD83D\uDCB3 DADOS DO PAGAMENTO --------");
        System.out.println("Plano: " + pagamento.getAluno().getPlano().getTipoPlano().name());
        System.out.println("Valor pago: " + pagamento.getValorPagamento());
        System.out.println("Método de pagamento: " + pagamento.getMetodoPagamento());
        System.out.println("Data: " + pagamento.getDataPagamento());

    }
}
