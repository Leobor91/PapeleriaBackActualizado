package com.papeleriawww.leobor.application.controllers;


import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Producto;
import com.papeleriawww.leobor.domain.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("/list")
    public List<Producto> listar() {
        return productosService.findByAll();
    }

    @PostMapping("/create")
    public Message guardar(@RequestBody Producto producto) {
        return productosService.save(producto);
    }

}
