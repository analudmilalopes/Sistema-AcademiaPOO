package repository;

import enums.TipoPlano;
import model.Plano;

import java.util.List;

public interface PlanoRepository {

    void adicionarPlano(TipoPlano plano);

    List<Plano> listarTodos();

    void buscarTodos();
}
