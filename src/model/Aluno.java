package model;

public class Aluno extends Pessoa{
    private static int contarId = 1;
    private int alunoID;
    Plano plano;
    private double peso;
    private double altura;


    public Aluno(String nome, String cpf, Plano plano){
        super(nome, cpf);
        this.alunoID = contarId++;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
