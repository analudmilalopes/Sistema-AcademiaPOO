package model;

import enums.TipoPlano;

public class Plano {
    private TipoPlano tipoPlano;
    private int duracaoEmMeses;
    private double valor;
    private double taxaMatricula;

    public Plano(TipoPlano tipoPlano, int duracaoEmMeses, double valor, double taxaMatricula){
        this.tipoPlano = tipoPlano;
        this.duracaoEmMeses = duracaoEmMeses;
        this.valor = valor;
        this.taxaMatricula = taxaMatricula;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public int getDuracaoEmMeses() {
        return duracaoEmMeses;
    }

    public void setDuracaoEmMeses(int duracaoEmMeses) {
        this.duracaoEmMeses = duracaoEmMeses;
    }

    public double getTaxaMatricula() {
        return taxaMatricula;
    }

    public void setTaxaMatricula(double taxaMatricula) {
        this.taxaMatricula = taxaMatricula;
    }
}
