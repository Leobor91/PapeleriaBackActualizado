package com.papeleriawww.leobor.application.controllers;

import com.papeleriawww.leobor.domain.model.Venta;
import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/list")
    public List<Venta> getAllVentas() {
        return ventaService.findAll();
    }

    @PostMapping("/create")
    public Message createVenta(@RequestBody Venta venta) {
        return ventaService.save(venta);
    }

    @PutMapping("/update/{id}")
    public Message updateVenta(@PathVariable String id, @RequestBody Venta ventaDetails) {
        return ventaService.update(id, ventaDetails);
    }

}
