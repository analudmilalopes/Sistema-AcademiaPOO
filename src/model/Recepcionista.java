package model;

import repository.AlunoRepositoryMemory;
import service.AlunoService;

public class Recepcionista extends Pessoa{

    private AlunoService alunoService;

    public Recepcionista(String nome, String cpf){
        super(nome, cpf);
    }

}
