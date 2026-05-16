    package controller;
    import enums.MetodoPagamento;
    import model.Aluno;
    import model.Pagamento;
    import model.Plano;
    import service.AlunoService;

    import java.time.LocalDate;
    import java.util.Scanner;

    public class TelaTerciaria {

        Scanner scanner = new Scanner(System.in);

        Pagamento pagamento;
        MetodoPagamento metodoPagamento;
        TelaInicial telaInicial;
        TelaSecundaria telaSecundaria;
        AlunoService alunoService;
        public TelaTerciaria(AlunoService alunoService){
            this.alunoService = alunoService;
        }


        public boolean menuSecundario(Plano plano, String nome, String cpf, double altura, double peso) {
            int opcoes = 0;

            double total = plano.getValor() + plano.getTaxaMatricula();
            System.out.println("Deseja prosseguir o pagamento de R$" + total + " reais?");
            do {
                opcoes = LeitorEntrada.lerNumerosInteiros(" 1 - Pagar | 2 - Voltar | 3 - Sair");

                if (opcoes >= 1 && opcoes <= 3) {
                    break;
                } else {
                    System.out.println("Escolher uma das 3 opções.");
                }
            } while (opcoes != 0);

            switch (opcoes) {
                case 1:
                return pagarPlano(nome, cpf, plano, metodoPagamento, altura, peso);
                case 2:
                  return false;
                case 3:
                    System.out.println("Tchauzinho!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Apenas uma das 3 opções são válidas!");
            }
            return false;
        }
        public boolean pagarPlano(String nome, String cpf, Plano plano, MetodoPagamento metodoPagamento, double altura, double peso){

            int opcoesPagamento = 0;
            System.out.println("-------- MÉTODOS DE PAGAMENTO --------\n");

            do {
                opcoesPagamento = LeitorEntrada.lerNumerosInteiros("1 - CARTÃO DE CRÉDITO/DÉBITO\n" +
                        "2 - DINHEIRO\n" + "3 - PIX");

                if (opcoesPagamento >=1 && opcoesPagamento <=3){
                    break;
                }else {
                    System.out.println("Escolha uma das 3 opções!");
                }

            }while (opcoesPagamento != 0);

            switch (opcoesPagamento){
                case 1:
                return mostrarTermo(nome, cpf, plano, MetodoPagamento.CARTAO, altura, peso);
                case 2:
                return mostrarTermo(nome, cpf, plano, MetodoPagamento.DINHEIRO, altura, peso);
                case 3:
                return mostrarTermo(nome, cpf, plano, MetodoPagamento.PIX, altura, peso);
                }
                return false;
            }

            public boolean mostrarTermo(String nome, String cpf, Plano plano, MetodoPagamento metodoPagamento, double altura, double peso){
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
                        "CPF: " + cpf + "\n" +
                        "Plano: " + plano.getTipoPlano().name() + "\n" +
                        "Valor total: [VALOR + TAXA] = R$" + total + "\n" +
                        "Método de Pagamento: " + metodoPagamento.name() +
                        "\n" +
                        "================================================\n" +
                        "   Ao continuar, você aceita este termo.\n" +
                        "================================================\n" +
                        "\n");

                int confirmarPagamento = LeitorEntrada.lerNumerosInteiros("1 - CONTINUAR PAGAMENTO | 2 - CANCELAR\n");
                if (confirmarPagamento == 1){
                    alunoService.cadastrarTodosAlunos(nome, cpf, plano, altura, peso);
                    Aluno aluno = alunoService.buscarPorCpf(cpf);
                    Pagamento pagamento = new Pagamento(aluno, total, metodoPagamento, LocalDate.now());
                    System.out.println("Pagamento efetuado! Bom treino! \uD83D\uDE09");
                    return true;
                }else {
                    return false;
                }
            }
        }

