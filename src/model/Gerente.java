package model;

import repository.AlunoRepositoryMemory;
import service.AlunoService;

public class Gerente extends Pessoa{

    private AlunoService alunoService;

    public Gerente(String nome, String cpf){
        super(nome, cpf);
    }
}
