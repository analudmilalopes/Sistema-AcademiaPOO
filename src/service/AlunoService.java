package service;

import enums.TipoPlano;
import exception.AlunoJaCadastradoException;
import model.Aluno;
import model.Plano;
import repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

        public void cadastrarTodosAlunos(String nome, String cpf, Plano plano, double peso, double altura) {
            List<Aluno> alunos = alunoRepository.listarTodos();

            for (Aluno aluno : alunos) {
                if (aluno.getCpf().equals(cpf)) {
                    throw new AlunoJaCadastradoException("Aluno com este CPF, já cadastrado!");
                }
            }

            Aluno aluno = new Aluno(nome, cpf, plano, peso, altura);
            alunoRepository.cadastrarAluno(aluno);
        }

    public void listarTodosAlunos() {
        List<Aluno> alunos = alunoRepository.listarTodos();

        for (Aluno aluno : alunos) {
            System.out.println("ID - " +
                    aluno.getAlunoID() + "\n" +
                    "Nome: " + aluno.getNome() + "\n" +
                    "CPF: " + aluno.getCpf() + "\n" +
                    "Plano " + aluno.getPlano().getTipoPlano().name());
        }
    }

    public boolean removerAlunoPorCpf(String cpf) {

       return alunoRepository.removerAluno(cpf);

    }
    // ja que estou procurando pelo ID de um aluno especifico, retorno Aluno e nao void.
    public Optional<Aluno> buscarPorId(int alunoID) {
        // ao inves de guardar em uma variavel para usar dps como faziamos com LIST, no stream chamamos na hora

        // return capta o resultado
        return alunoRepository.listarTodos()
                .stream()                 // como o ID e um numero inteiro usamos o == como comparacao
                .filter(aluno -> aluno.getAlunoID() == alunoID)
                .findFirst();

    }

        public Optional<Aluno> buscarPorCpf (String cpf){
            return alunoRepository.listarTodos()
                    .stream()
                    .filter(aluno -> aluno.getCpf().equals(cpf))
                    .findFirst();

        }

        public Optional<Aluno> buscarPorNome (String nome){
            return alunoRepository.listarTodos()
                    .stream()
                    .filter(aluno -> aluno.getNome().toLowerCase().contains(nome.toLowerCase()))
                    .findFirst();

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
