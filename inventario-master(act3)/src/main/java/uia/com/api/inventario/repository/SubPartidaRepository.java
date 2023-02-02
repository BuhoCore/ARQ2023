package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.SubPartida;

import java.util.List;

public interface SubPartidaRepository extends CrudRepository<SubPartida, Long>, QueryByExampleExecutor<SubPartida> {
    List<SubPartida> findByName(String name);
}

