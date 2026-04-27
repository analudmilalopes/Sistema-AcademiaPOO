package repository;

import model.Aluno;

import java.util.List;

public interface AlunoRepository {

   void cadastrarAluno(Aluno aluno);

   List<Aluno> listarTodos();
   void removerAluno(String cpf);
}
