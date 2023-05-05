package gtx18.com.renoult.Controller;


import gtx18.com.renoult.DTO.Tab_PagoDTO;
import gtx18.com.renoult.Repository.RepositoryPago;
import gtx18.com.renoult.Service.ServicePagos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Configuration
public class C_Pagos {

      @RestController
      @RequestMapping("/app")
      public class C_C_Pagos {

            @RestController
            public class TuTablaController {

                  @Autowired
                  private ServicePagos servicePagos;
                  private final RepositoryPago RepositoryPago;

                    public TuTablaController(RepositoryPago RepositoryPago) {
                         this.RepositoryPago = RepositoryPago;
                    }



                  @GetMapping("/pago")
                  public List<Tab_PagoDTO> getAll() {
                        return servicePagos.getPagos();
                  }

                  @GetMapping("/pago/{id}")
                  public Optional<Tab_PagoDTO> getById(@PathVariable("id") Long id) {
                        return servicePagos.getPago(id);
                  }


                  @PostMapping("/pago/save")
                  public void saveUpdate(@RequestBody Tab_PagoDTO pago) {
                        servicePagos.saveOrUpdatePago(pago);
                  }

                  @DeleteMapping("/pago/delete/{id}")
                  public void saveUpdate(@PathVariable("id") Long id) {
                        servicePagos.delete(id);
                  }


                  @GetMapping("/my")
                  public String m(Model model) {
                        List<Tab_PagoDTO> pagos = RepositoryPago.findAll();
                        model.addAttribute("pagos", pagos);
                        return "Pagos.html";
                  }
            }

      }

}
