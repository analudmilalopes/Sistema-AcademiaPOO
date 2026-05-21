package repository;

import enums.TipoPlano;
import model.Aluno;
import model.Plano;
import service.PlanoService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryArquivo implements AlunoRepository{

    private final String arquivo = "alunos.txt";
    private final PlanoService planoService;

    public AlunoRepositoryArquivo(PlanoService planoService){
        this.planoService = planoService;
    }
    @Override
    public void cadastrarAluno(Aluno aluno) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))){

            writer.write(
                    aluno.getAlunoID() + "," +
                            aluno.getNome() + "," +
                            aluno.getCpf() + "," +
                            aluno.getPlano().getTipoPlano().name() + "," +
                            aluno.getPeso() + "," +
                            aluno.getAltura()
            );

            writer.newLine();
        } catch (IOException e){
            System.err.println("Erro ao salvar aluno neste arquivo!");
        }
    }

    @Override
    public List<Aluno> listarTodos() {
        List<Aluno> alunos = new ArrayList<>();

        try(BufferedReader reader =  new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null){
                String[] campos = linha.split(",");

                int id = Integer.parseInt(campos[0].trim());
                String nome = campos[1];
                String cpf = campos[2];
                TipoPlano tipoPlano = TipoPlano.valueOf(campos[3]);
                double peso = Double.parseDouble(campos[4]);
                double altura = Double.parseDouble(campos[5]);

                Plano plano = planoService.buscarPorTipoPlano(tipoPlano);
                Aluno aluno = new Aluno(nome, cpf, plano, peso, altura);
                aluno.setAlunoID(id);
                alunos.add(aluno);
            }
        }catch (IOException e){
            System.err.println("Erro ao ler arquivo de alunos!");
        }

        int maiorId = alunos.stream()
                .mapToInt(Aluno::getAlunoID)
                .max()
                .orElse(0);
        Aluno.setContarId(maiorId + 1);
        return alunos;
    }

    @Override
    public boolean removerAluno(String cpf) {
        List<Aluno> alunos = listarTodos();
        boolean encontrouAlunos = alunos.removeIf(aluno -> aluno.getCpf().equals(cpf));

        if (!encontrouAlunos) {
            return false;
        }                                                                // sobrescrever o arquivo para n duplicar
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, false))) {
            for (Aluno aluno : alunos){
                writer.write(
                        aluno.getAlunoID() + "," +
                                aluno.getNome() + "," +
                                aluno.getCpf() + "," +
                                aluno.getPlano().getTipoPlano().name() + "," +
                                aluno.getPeso() + "," +
                                aluno.getAltura()
                );
                writer.newLine();
            }
        } catch (IOException e){
            System.err.println("Erro ao atualizar arquivo de alunos!");
        }

        return true;
    }

}
