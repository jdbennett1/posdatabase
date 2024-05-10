package App.Domain;

import App.Domain.Pos.Pasta_Rice;

import java.util.List;

public interface IPasta_RiceRepository {
    Pasta_Rice create(Pasta_Rice pasta_rice);

    int update(String id, Pasta_Rice pasta_rice);

    boolean delete(String id);

    List<Pasta_Rice> get(String id);

    List<Pasta_Rice> get();
}
