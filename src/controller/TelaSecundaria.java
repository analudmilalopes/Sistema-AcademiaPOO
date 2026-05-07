package controller;
import enums.TipoPlano;
import model.Plano;
import service.PlanoService;

import java.util.Scanner;

public class TelaSecundaria {

    Scanner scanner = new Scanner(System.in);

    TelaTerciaria telaTerciaria;
    PlanoService planoService;

    public TelaSecundaria(PlanoService planoService){
        this.planoService = planoService;
    }


    public void mostrarPlano(TipoPlano tipoPlano){
        Plano plano = planoService.buscarPorTipoPlano(tipoPlano);
        System.out.println("--------- " + tipoPlano.name() + " ---------");
        System.out.println("Duração de " + plano.getDuracaoEmMeses() + " meses");
        System.out.println("Valor: R$" + plano.getValor() + " reais.");
        System.out.println("Taxa de matrícula: R$" + plano.getTaxaMatricula() + " reais.");
    }
}
