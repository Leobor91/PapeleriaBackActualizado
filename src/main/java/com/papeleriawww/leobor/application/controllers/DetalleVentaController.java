package com.papeleriawww.leobor.application.controllers;

import com.papeleriawww.leobor.domain.model.DetalleVenta;
import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/list")
    public List<DetalleVenta> getAllDetalleVentas() {
        return detalleVentaService.findAll();
    }

    @PostMapping("/create")
    public Message createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.save(detalleVenta);
    }

    @PutMapping("/update/{id}")
    public Message updateDetalleVenta(@PathVariable String id, @RequestBody DetalleVenta detalleVentaDetails) {
        return detalleVentaService.update(id, detalleVentaDetails);
    }

}
