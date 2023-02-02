package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uia.com.api.inventario.dto.PartidasDTO;
import uia.com.api.inventario.dto.ProveedoresDTO;
import uia.com.api.inventario.service.PartidaService;
import uia.com.api.inventario.service.ProveedorService;



@RestController
@RequestMapping("/Partidas")
public class PartidasController {
    private PartidaService partidaService;

    @Autowired
    public PartidasController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @PostMapping
    public ResponseEntity<PartidasDTO> save(@RequestBody PartidasDTO partidasDTO)
    {
        PartidasDTO response = partidaService.save(partidasDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
