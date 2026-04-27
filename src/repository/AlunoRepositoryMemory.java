package repository;

import model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryMemory implements AlunoRepository{


    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public List<Aluno> listarTodos() {
        return alunos;
    }

    @Override
    public void removerAluno(String cpf) {

        // utilizando lambda para a estrutura ficar mais limpa
        alunos.removeIf(aluno -> aluno.getCpf().equals(cpf));
    }
}
