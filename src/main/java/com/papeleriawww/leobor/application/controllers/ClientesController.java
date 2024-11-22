package com.papeleriawww.leobor.application.controllers;

import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Cliente;
import com.papeleriawww.leobor.domain.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/list")
    public List<Cliente> listar() {
        return clientesService.findByAll();
    }

    @PostMapping("/create")
    public Message guardar(@RequestBody Cliente cliente) {
        return clientesService.save(cliente);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        clientesService.deleteById(id);
    }
}
