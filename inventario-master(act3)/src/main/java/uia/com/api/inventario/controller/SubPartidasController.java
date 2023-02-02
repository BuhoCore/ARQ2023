package uia.com.api.inventario.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uia.com.api.inventario.dto.SubPartidasDTO;
import uia.com.api.inventario.service.SubPartidaService;

@RestController
@RequestMapping("/SubPartidas")
public class SubPartidasController {
    private SubPartidaService subpartidaService;

    /*
    @Autowired
    public SubPartidasController(SubPartidaService subpartidaService) {
        this.subpartidaService = subpartidaService;
    }

      */

    @PostMapping
    public ResponseEntity<SubPartidasDTO> save(@RequestBody SubPartidasDTO subpartidasDTO)
    {
        SubPartidasDTO responses = subpartidaService.save(subpartidasDTO);
        return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }

}

