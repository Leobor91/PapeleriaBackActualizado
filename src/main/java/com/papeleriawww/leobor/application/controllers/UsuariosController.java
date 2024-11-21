package com.papeleriawww.leobor.application.controllers;


import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Usuario;
import com.papeleriawww.leobor.domain.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/list")
    public List<Usuario> listar(){
        return usuariosService.findByAll();
    }

    @PostMapping("/create")
    public Message guardar(@RequestBody Usuario usuario){
        return usuariosService.save(usuario);
    }

    @PostMapping("/login")
    public Message login(@RequestBody Usuario usuario){
        return usuariosService.login(usuario.getUsername(), usuario.getPassword());
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable("id") Long id){
        usuariosService.deleteById(id);
    }
}
