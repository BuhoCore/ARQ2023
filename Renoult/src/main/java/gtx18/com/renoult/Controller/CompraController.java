package gtx18.com.renoult.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/app")
public class CompraController {

    @GetMapping({"/compra" })
    public String compra() {
        return "compra.html";
    }
}
