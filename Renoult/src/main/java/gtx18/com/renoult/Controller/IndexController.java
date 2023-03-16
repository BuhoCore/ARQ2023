package gtx18.com.renoult.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/home" , "/index", "/"})
    public String index(Model model) {
        model.addAttribute("titulo", "Joel");

        return "Index.html";
    }
}

