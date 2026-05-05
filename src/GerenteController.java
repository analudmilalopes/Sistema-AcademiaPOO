import model.Aluno;
import model.Gerente;
import service.AlunoService;

import java.util.Scanner;

public class GerenteController {

    private final Gerente gerente = new Gerente("Ludmila", "12345678910");
    private AlunoService alunoService;
    private Scanner scanner = new Scanner(System.in);

    public GerenteController(Gerente gerente, AlunoService alunoService){
        this.alunoService = alunoService;
    }

    public void TelaGerente() {

        int opcoesGerente;


        do {

            opcoesGerente = MenuPrincipal.lerNumerosInteiros("1 - Listar Alunos | 2 - Buscar aluno por ID | " +
                    "3 - Buscar aluno por CPF | 4 - Buscar aluno por Nome | 5 - Remover Aluno | 6 - Sair ");

            if (opcoesGerente >= 1 && opcoesGerente <= 6) {
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
                int idProcurado = MenuPrincipal.lerNumerosInteiros("Digite o ID do aluno que deseja procurar:\n");
               mostrarBusca(alunoService.buscarPorId(idProcurado));
                break;
            case 3:
                String cpfProcurado = MenuPrincipal.lerCpf("Digite o CPF do aluno que deseja procurar:\n");
                mostrarBusca(alunoService.buscarPorCpf(cpfProcurado));
                break;
            case 4:
                String nomeProcurado = MenuPrincipal.lerNomes("Digite o Nome do aluno que deseja procurar:\n");
               mostrarBusca(alunoService.buscarPorNome(nomeProcurado));
                break;
            case 5:
                String cpfRemover = MenuPrincipal.lerCpf("Digite o CPF do aluno que deseja remover:\n");
               if (alunoService.removerAlunoPorCpf(cpfRemover)){
                   System.out.println("Aluno removido!");
               }else {
                   System.out.println("Aluno não encontrado no sistema!");
               }
                break;
            case 6:
                System.exit(0);
                break;

            default:
                System.out.println("Apenas uma das 6 opcoes sao validas!");
        }
    }

    public void mostrarBusca(Aluno aluno){;
        if (aluno != null){
            System.out.println("ID: " + aluno.getAlunoID());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Plano: " + aluno.getPlano().getTipoPlano());
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }
}

