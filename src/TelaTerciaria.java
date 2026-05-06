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


    // para mostrar no nosso termo de consentimento, pegamos o plano que o cliente escolheu e o seu nome.
    public void menuSecundario(Plano plano, String nome) {
        int opcoes = 0;

        double total = plano.getValor() + plano.getTaxaMatricula();
        System.out.println("Plano: R$" + plano.getValor());
        System.out.println("Taxa de matrícula: R$" + plano.getTaxaMatricula());
        System.out.println("Deseja prosseguir o pagamento de R$" + total + "?");
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
              return;
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
        System.out.println("-------- MÉTODOS DE PAGAMENTO --------\n");

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

        public void mostrarTermo(String nome, Plano plano, MetodoPagamento metodoPagamento){
            double total = plano.getValor() + plano.getTaxaMatricula();
            System.out.println("-------------------------------------------------");
            System.out.println("       TERMO DE ADESÃO - ACADEMIA MONSTERS       ");
            System.out.println("-------------------------------------------------");
            System.out.println("Ao confirmar o pagamento, o(a) aluno(a) declara\n" +
                    "que está ciente e concorda com as seguintes\n" +
                    "condições:\n" +
                    "\n" +
                    "1. O plano escolhido terá início na data do\n" +
                    "   pagamento e será renovado automaticamente\n" +
                    "   ao término do período contratado.\n" +
                    "\n" +
                    "2. O cancelamento deve ser solicitado com \n" +
                    "   30 dias de antecedência.\n" +
                    "\n" +
                    "3. A taxa de matrícula é não reembolsável.\n" +
                    "\n" +
                    "4. O aluno se compromete a respeitar as normas\n" +
                    "   de convivência e segurança da academia.\n" +
                    "\n" +
                    "5. A academia não se responsabiliza por objetos\n" +
                    "   perdidos ou roubados nas dependências.\n" +
                    "\n" +
                    "Nome: " + nome + "\n" +
                    "Plano: " + plano.getTipoPlano().name() + "\n" +
                    "Valor total: [VALOR + TAXA] = R$" + total + "\n" +
                    "Método de Pagamento: " + metodoPagamento.name() +
                    "\n" +
                    "================================================\n" +
                    "   Ao continuar, você aceita este termo.\n" +
                    "================================================\n" +
                    "\n" +
                    "1 - CONTINUAR PAGAMENTO\n" +
                    "2 - CANCELAR");

            int confirmarPagamento = MenuPrincipal.lerNumerosInteiros("1 - CONTINUAR PAGAMENTO | 2 - CANCELAR\n");
            if (confirmarPagamento == 1){
                System.out.println("Pagamento de R$" + total + " efetuado no " + metodoPagamento.name() + "! Bom treino! \uD83D\uDE09");
            }else {
                return;
            }
        }
    }

