package com.makaia.back4.JpaMySql.controllers;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Amistad;
import com.makaia.back4.JpaMySql.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/amistad")
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping()
    public Amistad crearAmistad(@RequestBody CrearDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Amistad> listarAmistad(@RequestParam(name="user_id", required = false) Long user_id,
        @RequestParam(name="user1_id", required = false) Long user1_id){
        if (user_id != null && user1_id == null){
            return  this.service.listarSolicitudes(user_id);
        }else {
            if (user_id != null && user1_id != null){
                return  this.service.listarAmistades(user_id,user1_id);
            }
        }
        return  this.service.listar();
    }
}
