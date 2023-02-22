package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uia.com.api.inventario.dto.UbicacionDTO;
import uia.com.api.inventario.model.Ubicacion;
import uia.com.api.inventario.service.UbicacionService;

@RestController
@RequestMapping("/Ubicacion")
public class UbicacionController {

    private UbicacionService ubicacionService;

    @Autowired
    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @PostMapping
    public ResponseEntity<Ubicacion> save(@RequestBody UbicacionDTO ubicacionDT)
    {
        Ubicacion response = ubicacionService.save(ubicacionDT);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
