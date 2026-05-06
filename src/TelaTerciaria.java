import enums.MetodoPagamento;
import enums.TipoPlano;
import model.Plano;
import service.AlunoService;

import java.util.Scanner;

public class TelaTerciaria {

    Scanner scanner = new Scanner(System.in);

    MetodoPagamento metodoPagamento;
    TelaInicial telaInicial;
    TelaSecundaria telaSecundaria;
    AlunoService alunoService;
    public TelaTerciaria(AlunoService alunoService){
        this.alunoService = alunoService;
    }


    // para mostrar no nosso termo de consentimento, pegamos o plano que o cliente utilizou e o nome do mesmo.
    public void menuSecundario(Plano plano, String nome) {
        int opcoes = 0;

        double total = plano.getValor() + plano.getTaxaMatricula();
        System.out.println("Plano: R$" + plano.getValor());
        System.out.println("Taxa de matrícula: R$" + plano.getTaxaMatricula());
        System.out.println("Total: R$" + total);
        do {
            opcoes = MenuPrincipal.lerNumerosInteiros(" 1 - Pagar | 2 - Voltar | 3 - Sair");

            if (opcoes >= 1 && opcoes <= 3) {
                break;
            } else {
                System.out.println("Escolher uma das 3 opções.");
            }
        } while (opcoes != 0);

        switch (opcoes) {
            case 1:
            pagarPlano(metodoPagamento);
            break;
            case 2:
             telaInicial.criarConta();
            case 3:
                System.out.println("Tchauzinho!!");
                System.exit(0);
                break;
            default:
                System.out.println("Apenas uma das 3 opções são válidas!");
        }
    }
    public void pagarPlano(MetodoPagamento metodoPagamento){

        int opcoesPagamento = 0;
        System.out.println("-------- MÉTODOS DE PAGAMENTO --------");

        do {
            opcoesPagamento = MenuPrincipal.lerNumerosInteiros("1 - CARTÃO DE CRÉDITO/DÉBITO\n" +
                    "2 - DINHEIRO\n" + "3 - PIX");

            if (opcoesPagamento >=1 && opcoesPagamento <=3){
                break;
            }else {
                System.out.println("Escolha uma das 3 opções!");
            }

        }while (opcoesPagamento != 0);

        switch (opcoesPagamento){
            case 1:
            }
        }
    }

