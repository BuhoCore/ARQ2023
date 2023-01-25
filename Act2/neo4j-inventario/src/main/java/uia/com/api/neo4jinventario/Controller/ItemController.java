package uia.com.api.neo4jinventario.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uia.com.api.neo4jinventario.DTO.ItemDTO;
import uia.com.api.neo4jinventario.Service.ItemService;


@RestController
@RequestMapping("/Item")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping()
    @ResponseBody
    public ResponseEntity<ItemDTO> save(@RequestBody ItemDTO itemDTO){
       ItemDTO response = itemService.save(itemDTO);
       return new ResponseEntity<>(response, HttpStatus.CREATED);

        }
    }



