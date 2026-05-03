package repository;

import enums.TipoPlano;
import model.Plano;

import java.util.ArrayList;
import java.util.List;

public class PlanoRepositoryMemory implements PlanoRepository{

    private List<Plano> planos = new ArrayList<>();

    @Override
    public void adicionarPlano(Plano plano) {
        planos.add(plano);
    }

    @Override
    public List<Plano> listarTodos() {
        return planos;
    }


}
