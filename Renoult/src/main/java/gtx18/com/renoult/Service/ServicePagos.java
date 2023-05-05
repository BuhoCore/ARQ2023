package gtx18.com.renoult.Service;


import gtx18.com.renoult.DTO.Tab_PagoDTO;
import gtx18.com.renoult.Repository.RepositoryPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePagos {

      @Autowired
      RepositoryPago repositoryPago;
      ServicePagos servicePagos;
      JdbcTemplate jdbcTemplate;


      public List<Tab_PagoDTO> getPagos() {
            return repositoryPago.findAll();
      }

      public Optional<Tab_PagoDTO> getPago(Long id) {
            return repositoryPago.findById(id);
      }

      public void saveOrUpdatePago(Tab_PagoDTO pago) {
            repositoryPago.save(pago);
      }

      public void delete(Long id) {
            repositoryPago.deleteById(id);
      }


}


