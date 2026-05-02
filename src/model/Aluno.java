package model;

public class Aluno extends Pessoa{
    //private int contarId = 0;
    private int alunoID;
    Plano plano;


    public Aluno(int alunoID, String nome, String cpf, Plano plano){
        super(nome, cpf);
        this.plano = plano;
    }

    public int getAlunoID(){
        return alunoID;
    }


    public void setAlunoID(int alunoID){
        this.alunoID = alunoID;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
