package repository;

import model.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository {
    private final List<Pagamento> pagamentos = new ArrayList<>();

    public void adicionarPagamento(Pagamento pagamento){
        pagamentos.add(pagamento);
    }

    public Pagamento buscarPorCpf(String cpf){
        return pagamentos.stream()
                .filter(pagamento -> pagamento.getAluno().getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
