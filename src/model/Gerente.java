package model;

import repository.AlunoRepositoryMemory;

public class Gerente extends Pessoa{

    private AlunoRepositoryMemory alunoRepository;

    public Gerente(String nome, String cpf, AlunoRepositoryMemory alunoRepository){
        super(nome, cpf);
        this.alunoRepository = alunoRepository;
    }
}
