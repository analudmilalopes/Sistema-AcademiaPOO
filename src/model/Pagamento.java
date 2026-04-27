package model;

import enums.MetodoPagamento;

import java.time.LocalDate;

public class Pagamento {
    private Aluno aluno;
    private double valorPagamento;
    private MetodoPagamento metodoPagamento;
    private LocalDate dataPagamento;

    public Pagamento(Aluno aluno, double valorPagamento, MetodoPagamento metodoPagamento, LocalDate dataPagamento){
        this.aluno = aluno;
        this.valorPagamento = valorPagamento;
        this.metodoPagamento = metodoPagamento;
        this.dataPagamento = dataPagamento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
