package repository;

import enums.TipoPlano;
import model.Plano;

import java.util.List;

public interface PlanoRepository {

    void adicionarPlano(Plano plano);

    List<Plano> listarTodos();

}
