package app;
import controller.*;
import model.Gerente;
import model.Recepcionista;
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
        Recepcionista recepcionista = new Recepcionista("Maria", "98765432100");
        GerenteController gerenteController = new GerenteController(gerente, alunoService);

        RecepcionistaController recepcionistaController = new RecepcionistaController(recepcionista, alunoService);
        PagamentoRepository pagamentoRepository = new PagamentoRepository();

        TelaTerciaria telaTerciaria = new TelaTerciaria(alunoService, pagamentoRepository);
        TelaSecundaria telaSecundaria = new TelaSecundaria(planoService);
        TelaInicial telaInicial = new TelaInicial(alunoService, gerenteController, recepcionistaController, planoService, telaSecundaria, telaTerciaria, pagamentoRepository);

        telaInicial.opcoesMenu();


    }
}