package controller;
import enums.TipoPlano;
import model.Aluno;
import model.Gerente;
import service.AlunoService;

import java.util.List;
import java.util.Scanner;

public class GerenteController {

    private final Gerente gerente = new Gerente("Ludmila", "12345678910");
    private AlunoService alunoService;
    private Scanner scanner = new Scanner(System.in);

    public GerenteController(Gerente gerente, AlunoService alunoService){
        this.alunoService = alunoService;
    }

    public void TelaGerente() {

        while (true) {
            int opcoesGerente;


            do {

                opcoesGerente = LeitorEntrada.lerNumerosInteiros("1 - Listar Alunos\n" + "2 - Buscar aluno por ID\n" +
                        "3 - Buscar aluno por CPF\n" + "4 - Buscar aluno por Nome\n" + "5 - Remover Aluno\n" +
                        "6 - Buscar aluno por Tipo de Plano\n" + "7 - Sair");

                if (opcoesGerente >= 1 && opcoesGerente <= 7) {
                    break;
                } else {
                    System.out.println("Escolher entre 1 e 6.");
                }
            } while (opcoesGerente != 0);

            switch (opcoesGerente) {
                case 1:
                    alunoService.listarTodosAlunos();
                    break;
                case 2:
                    int idProcurado = LeitorEntrada.lerNumerosInteiros("Digite o ID do aluno que deseja procurar:\n");
                    mostrarBusca(alunoService.buscarPorId(idProcurado));
                    break;
                case 3:
                    String cpfProcurado = LeitorEntrada.lerCpf("Digite o CPF do aluno que deseja procurar:\n");
                    mostrarBusca(alunoService.buscarPorCpf(cpfProcurado));
                    break;
                case 4:
                    String nomeProcurado = LeitorEntrada.lerNomes("Digite o Nome do aluno que deseja procurar:\n");
                    mostrarBusca(alunoService.buscarPorNome(nomeProcurado));
                    break;
                case 5:
                    String cpfRemover = LeitorEntrada.lerCpf("Digite o CPF do aluno que deseja remover:\n");
                    if (alunoService.removerAlunoPorCpf(cpfRemover)) {
                        System.out.println("Aluno removido!");
                    } else {
                        System.out.println("Aluno não encontrado no sistema!");
                    }
                    break;
                case 6:
                    String planoProcurado = LeitorEntrada.lerNomes("Digite o nome do Plano que deseja procurar:\n");
                    mostrarBuscaLista(alunoService.buscarPeloTipoPlano(TipoPlano.valueOf(planoProcurado.toUpperCase())));
                    break;
                case 7:
                   return;
                default:
                    System.out.println("Apenas uma das 6 opções são válidas!");
            }
        }
    }

    public void mostrarBusca(Aluno aluno){;
        if (aluno != null){
            System.out.println("ID: " + aluno.getAlunoID());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Plano: " + aluno.getPlano().getTipoPlano().name());
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    public void mostrarBuscaLista(List<Aluno> alunos){
        if (alunos.isEmpty()){
            System.out.println("Nenhum aluno foi encontrado.");
            return;
        }
        for (Aluno aluno : alunos){
            mostrarBusca(aluno);
            System.out.println("---");
        }
    }
}

