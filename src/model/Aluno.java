package model;

public class Aluno {
    //private int contarId = 0;
    private int alunoID;
    private String nome;
    private String cpf;
    private Plano plano;

    public Aluno(int alunoID, String nome, String cpf, Plano plano){
        this.alunoID = alunoID;
        this.nome = nome;
        this.cpf = cpf;
        this.plano = plano;
    }

    public int getAlunoID(){
        return alunoID;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setAlunoID(int alunoID){
        this.alunoID = alunoID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
