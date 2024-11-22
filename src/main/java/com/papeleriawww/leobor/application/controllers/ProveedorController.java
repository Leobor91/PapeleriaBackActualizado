package com.papeleriawww.leobor.application.controllers;


import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Proveedor;
import com.papeleriawww.leobor.domain.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/list")
    public List<Proveedor> getAllProveedores() {
        return proveedorService.findAll();
    }

    @PostMapping("/create")
    public Message createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.save(proveedor);
    }

    @DeleteMapping("/delete/{id}")
    public void  deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteById(id);
    }
}