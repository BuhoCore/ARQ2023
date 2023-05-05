package gtx18.com.renoult.Repository;

import gtx18.com.renoult.DTO.Tab_PagoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPago extends JpaRepository<Tab_PagoDTO, Long> {

      List<Tab_PagoDTO> findAll();
}
