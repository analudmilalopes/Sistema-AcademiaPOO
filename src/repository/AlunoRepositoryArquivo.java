package repository;

import model.Aluno;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryArquivo implements AlunoRepository{

    private final String arquivo = "alunos.txt";

    @Override
    public void cadastrarAluno(Aluno aluno) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))){

            writer.write(
                    aluno.getAlunoID() + ";" +
                            aluno.getNome() + ";" +
                            aluno.getCpf() + ";" +
                            aluno.getPlano().getTipoPlano().name() + ";" +
                            aluno.getPeso() + ";" +
                            aluno.getAltura()
            );

            writer.newLine();
        } catch (IOException e){
            System.err.println("Erro ao salvar aluno neste arquivo!");
        }
    }

    @Override
    public List<Aluno> listarTodos() {
        return new ArrayList<>();
    }

    @Override
    public boolean removerAluno(String cpf) {
        return false;
    }
}
