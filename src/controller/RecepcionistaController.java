package controller;

import model.Aluno;
import model.Recepcionista;
import service.AlunoService;

import java.util.Scanner;

public class RecepcionistaController {

    private final Recepcionista recepcionista = new Recepcionista("Maria", "98765432100");
    private AlunoService alunoService;
    Scanner scanner = new Scanner(System.in);

    public RecepcionistaController(Recepcionista recepcionista, AlunoService alunoService){
        this.alunoService = alunoService;
    }

    public void TelaRecepcionista(){
        while (true){
            int opcoesRecepcionista;

            do {
                opcoesRecepcionista = LeitorEntrada.lerNumerosInteiros("1 - Listar Alunos\n"
                        + "2 - Buscar aluno por CPF\n"
                + "3 - Buscar aluno por Nome\n" + "4 - Remover aluno\n" + "5 - Sair");

                if (opcoesRecepcionista >= 1 && opcoesRecepcionista <=5){
                    break;
                }else {
                    System.err.println("Escolher entre 1 e 5.");
                }
            } while (opcoesRecepcionista !=0);

            switch (opcoesRecepcionista){
                case 1:
                    alunoService.listarTodosAlunos();
                    break;
                case 2:
                    String cpfProcurado = LeitorEntrada.lerCpf("Digite o CPF do aluno que deseja procurar:\n");
                    mostrarBusca(alunoService.buscarPorCpf(cpfProcurado));
                    break;
                case 3:
                    String nomeProcurado = LeitorEntrada.lerNomes("Digite o Nome do aluno que deseja procurar:\n");
                    mostrarBusca(alunoService.buscarPorNome(nomeProcurado));
                    break;
                case 4:
                    String cpfRemover = LeitorEntrada.lerCpf("Digite o CPF do aluno que deseja remover:\n");
                    if (alunoService.removerAlunoPorCpf(cpfRemover)){
                        System.out.println("Aluno removido!");
                    } else {
                        System.err.println("Aluno não encontrado no sistema!");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Apenas uma das 5 opções são válidas!");
            }
        }
    }

    public void mostrarBusca(Aluno aluno){
        if (aluno != null){
            System.out.println("          👤 DADOS DO ALUNO            ");
            System.out.println("Nome:   " + aluno.getNome());
            System.out.println("CPF:    " + aluno.getCpf());
            System.out.println("Plano:  " + aluno.getPlano().getTipoPlano().name());
        } else {
            System.err.println("Nenhum aluno foi encontrado.");
        }
    }
}
