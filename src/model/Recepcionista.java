package model;

import repository.AlunoRepositoryMemory;

public class Recepcionista extends Pessoa{

    private AlunoRepositoryMemory alunoRepository;

    public Recepcionista(String nome, String cpf, AlunoRepositoryMemory alunoRepository){
        super(nome, cpf);
        this.alunoRepository = alunoRepository;
    }

}
