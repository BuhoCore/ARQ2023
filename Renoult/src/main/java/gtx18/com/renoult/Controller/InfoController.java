package gtx18.com.renoult.Controller;


import gtx18.com.renoult.DTO.CarroDTO;
import gtx18.com.renoult.DTO.CarrosDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class InfoController {

    @GetMapping({"/info"})
    public String info(Model model){
        CarroDTO carro = new CarroDTO();
        carro.setMarca("Renault");
        carro.setModelo("Kangoo");
        carro.setAnno("2018");
        carro.setColor("Blanco");

        model.addAttribute("carro", carro);
        model.addAttribute("titulo", "Informacaion Sobre Renault México: ".concat(carro.getMarca()));

        return "Info.html";
    }
    @RequestMapping("/list")
    public String list(Model model){

        ArrayList<CarrosDTO> carros = new ArrayList<>();
           carros.add(new CarrosDTO("Renault", "DUSTER", "2020", "Café Caoba"));
              carros.add(new CarrosDTO("Renault", "KWID", "2013", "Blanco Glaciar"));
                 carros.add(new CarrosDTO("Renault", "LOGAN", "2015", "Rogo Fuego"));

        model.addAttribute("titulo", "LISTAS DE CARROS: ".concat(carros.get(0).getMarca()));
        model.addAttribute("carros", carros);

        /*Optimizar el codigo con el Metodo de Arreglo (Arrays.asList) que convierte los arreglo en una lista que esten perados por comas (,)
        List<CarrosDTO> carros = Arrays.asList(new CarrosDTO("Renault", "DUSTER", "2020", "Café Caoba"),
                new CarrosDTO("Renault", "KWID", "2013", "Blanco Glaciar"),
                new CarrosDTO("Renault", "LOGAN", "2015", "Rogo Fuego"));
         */


        return "lista.html";
    }
    /*Mostrar los datos en todos los html del controller
    @ModelAttribute("carros")
    public List<CarrosDTO> Todoscarros(){
        List<CarrosDTO> carros = Arrays.asList(new CarrosDTO("Renault", "DUSTER", "2020", "Café Caoba"),
                new CarrosDTO("Renault", "KWID", "2013", "Blanco Glaciar"),
                new CarrosDTO("Renault", "LOGAN", "2015", "Rogo Fuego"));

        return carros;
    }

     */
}


