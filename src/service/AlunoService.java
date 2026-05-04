package service;

import enums.TipoPlano;
import model.Aluno;
import model.Plano;
import repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public void cadastrarTodosAlunos(int alunoID, String nome, String cpf, Plano plano){
        List<Aluno> alunos = alunoRepository.listarTodos();

        for (Aluno aluno : alunos){
            if (aluno.getCpf().equals(cpf)){
                System.out.println("Aluno já cadastrado no sistema!");
                return;
            }
        }

        Aluno aluno = new Aluno(alunoID, nome, cpf, plano);
        alunoRepository.cadastrarAluno(aluno);
    }

    public void listarTodosAlunos(){
        List<Aluno> alunos = alunoRepository.listarTodos();

        for (Aluno aluno : alunos){
            System.out.println("ID - " +
                    aluno.getAlunoID() + "\n" +
                    "Nome: " + aluno.getNome() + "\n" +
                    "CPF: " + aluno.getCpf() + "\n" +
                    "Plano " + aluno.getPlano());
        }
    }

    // ja que estou procurando pelo ID de um aluno especifico, retorno Aluno e nao void.
    public Aluno listarPorId(int alunoID) {
        List<Aluno> alunos = alunoRepository.listarTodos();

        alunos.stream()                 // como o ID e um numero inteiro usamos o == como comparacao
                .filter(aluno -> aluno.getAlunoID() == alunoID)
                .forEach(System.out::println);


    }
}
