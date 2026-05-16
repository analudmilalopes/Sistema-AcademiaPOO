package app;
import controller.TelaInicial;
import controller.TelaSecundaria;
import controller.TelaTerciaria;
import controller.GerenteController;
import model.Gerente;
import repository.*;
import service.AlunoService;
import service.PlanoService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        AlunoRepository alunoRepo = new AlunoRepositoryMemory();
        AlunoService alunoService = new AlunoService(alunoRepo);

        PlanoRepository planoRepo = new PlanoRepositoryMemory();
        PlanoService planoService = new PlanoService(planoRepo);

        Gerente gerente = new Gerente("Ludmila", "12345678910");
        GerenteController gerenteController = new GerenteController(gerente, alunoService);
        PagamentoRepository pagamentoRepository = new PagamentoRepository();

        TelaTerciaria telaTerciaria = new TelaTerciaria(alunoService, pagamentoRepository);
        TelaSecundaria telaSecundaria = new TelaSecundaria(planoService);
        TelaInicial telaInicial = new TelaInicial(alunoService, gerenteController, planoService, telaSecundaria, telaTerciaria, pagamentoRepository);

        telaInicial.opcoesMenu();


    }
}