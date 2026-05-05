import model.Gerente;
import repository.AlunoRepository;
import repository.AlunoRepositoryMemory;
import service.AlunoService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        AlunoRepository repo = new AlunoRepositoryMemory();
        AlunoService service = new AlunoService(repo);

        Gerente gerente = new Gerente("Ludmila", "12345678910");

        GerenteController gerenteController = new GerenteController(gerente, service);

        TelaInicial telaInicial = new TelaInicial(service, gerenteController);

        telaInicial.opcoesMenu();


    }
}