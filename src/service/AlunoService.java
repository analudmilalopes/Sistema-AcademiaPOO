package service;

import enums.TipoPlano;
import model.Aluno;
import model.Plano;
import repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void cadastrarTodosAlunos(int alunoID, String nome, String cpf, Plano plano) {
        List<Aluno> alunos = alunoRepository.listarTodos();

        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                System.out.println("Aluno já cadastrado no sistema!");
                return;
            }
        }

        Aluno aluno = new Aluno(alunoID, nome, cpf, plano);
        alunoRepository.cadastrarAluno(aluno);
    }

    public void listarTodosAlunos() {
        List<Aluno> alunos = alunoRepository.listarTodos();

        for (Aluno aluno : alunos) {
            System.out.println("ID - " +
                    aluno.getAlunoID() + "\n" +
                    "Nome: " + aluno.getNome() + "\n" +
                    "CPF: " + aluno.getCpf() + "\n" +
                    "Plano " + aluno.getPlano());
        }
    }

    // ja que estou procurando pelo ID de um aluno especifico, retorno Aluno e nao void.
    public Aluno buscarPorId(int alunoID) {
        // ao inves de guardar em uma variavel para usar dps como faziamos com LIST, no stream chamamos na hora

        // return capta o resultado
        return alunoRepository.listarTodos()
                .stream()                 // como o ID e um numero inteiro usamos o == como comparacao
                .filter(aluno -> aluno.getAlunoID() == alunoID)
                .findFirst()
                .orElse(null);

        // usando o return nao precisamos do sout
    }

        public Aluno buscarPorCpf (String cpf){
            return alunoRepository.listarTodos()
                    .stream()
                    .filter(aluno -> aluno.getCpf().equals(cpf))
                    .findFirst()
                    .orElse(null);

        }

        public Aluno buscarPorNome (String nome){
            return alunoRepository.listarTodos()
                    .stream()
                    .filter(aluno -> aluno.getNome().contains(nome))
                    .findFirst()
                    .orElse(null);

        }

        public List<Aluno> buscarPeloTipoPlano (TipoPlano tipoPlano){
            List<Aluno> alunos = alunoRepository.listarTodos();

                    return alunos.stream()
                    .filter(aluno -> aluno.getPlano().getTipoPlano().equals(tipoPlano))
                    // usando toList para retornar todos os alunos,
                    // porque é o único que pode retornar diversos resultados
                    .toList();


        }
    }
