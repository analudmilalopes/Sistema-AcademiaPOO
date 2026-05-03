package service;

import enums.TipoPlano;
import model.Plano;
import repository.PlanoRepository;

import java.util.List;

public class PlanoService {

    private PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository){
        this.planoRepository = planoRepository;
    }

    public void adicionarTodosPlanos(TipoPlano tipoPlano, int duracaoEmMeses, double valor, double taxaMatricula){
        List<Plano> planos = planoRepository.listarTodos();

        for (Plano plano : planos){
            if (plano.getTipoPlano().equals(tipoPlano)){
                System.out.println("Plano ja cadastrado!");
                return;
            }
        }
        Plano plano = new Plano(tipoPlano, duracaoEmMeses, valor, taxaMatricula);
        planoRepository.adicionarPlano(plano);
    }

    public void listaTodosPlanos(){
        List<Plano> planos = planoRepository.listarTodos();

        for (Plano plano : planos){
            System.out.println("1 - " + plano.getTipoPlano().name() + "\n");
            System.out.println("Duração de " + plano.getDuracaoEmMeses() + " meses\n");
            System.out.println("Valor: R$" + plano.getValor() + "\n");
            System.out.println("Taxa de matrícula" + plano.getTaxaMatricula());
        }
    }

}
