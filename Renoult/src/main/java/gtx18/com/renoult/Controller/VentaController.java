package gtx18.com.renoult.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class VentaController {

    @GetMapping({"/venta" })
    public String venta() {
        return "venta.html";
    }
}
