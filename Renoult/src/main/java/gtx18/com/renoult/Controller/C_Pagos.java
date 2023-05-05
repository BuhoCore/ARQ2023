package gtx18.com.renoult.Controller;

import gtx18.com.renoult.DTO.Tab_Pago;
import gtx18.com.renoult.Repository.RepositoryPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Configuration
public class C_Conexion {

    @RestController
    public class C_C_Controller {
        @Autowired

        private RepositoryPago tuPagoRepository;
        private JdbcTemplate jdbcTemplate;
        @GetMapping("/pago")

        public List<Map<String, Object>> getTuTabla() {
            String query = "SELECT * FROM tu_tabla";
            List<Map<String, Object>> pago = jdbcTemplate.queryForList(query);

            return pago;
        }
        /*
         @GetMapping("/tu_tabla/texto/{texto}")
    public List<TuTabla> getTuTablaPorTexto(@PathVariable("texto") String texto) {
        return tuTablaRepository.findByTexto(texto);
    }

    @PostMapping("/tu_tabla")
    public TuTabla guardarTuTabla(@RequestBody TuTabla tuTabla) {
        return tuTablaRepository.save(tuTabla);
    }

        */

        // otros métodos para manejar otras solicitudes HTTP (por ejemplo, POST, PUT, DELETE)
    }

}
