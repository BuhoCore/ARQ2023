package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.Ubicacion;

import java.util.List;

public interface UbicacionRepository extends CrudRepository<Ubicacion, String>, QueryByExampleExecutor<Ubicacion> {

    List<Ubicacion> findByName(String name);
    List<Ubicacion> findByIdUbicacion(String idUbicacion);
    Boolean existsByIdUbicacion(String idUbicacion);
}
