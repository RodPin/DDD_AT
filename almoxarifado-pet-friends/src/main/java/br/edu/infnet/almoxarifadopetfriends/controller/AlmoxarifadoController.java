package br.edu.infnet.almoxarifadopetfriends.controller;

import br.edu.infnet.almoxarifadopetfriends.service.impl.AlmoxarifadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/almoxarifado")
public class AlmoxarifadoController {

    @Autowired
    private AlmoxarifadoServiceImpl almoxarifadoService;

    @GetMapping int verificaDisponibilidadeItem(@RequestBody String itemId){
        return almoxarifadoService.verificaDisponibilidadeItem(itemId);
    }
 
}
