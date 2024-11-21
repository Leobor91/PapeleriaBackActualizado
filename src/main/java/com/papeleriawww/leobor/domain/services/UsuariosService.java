package com.papeleriawww.leobor.domain.services;


import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Usuario;
import com.papeleriawww.leobor.domain.ports.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> findByAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Message save(Usuario usuario) {
        return existingEmail(usuario.getEmail())
                ? Message.builder().message("El email ya existe").data(null).build()
                : existingUsuario(usuario.getDocumentNumber(), usuario.getDocumentType())
                ? Message.builder().message("El usuario ya existe").data(null).build()
                : existingUsername(usuario.getUsername())
                ? Message.builder().message("El nombre de usuario ya existe").data(null).build()
                : Message.builder()
                .message("Usuario guardado")
                .data(usuarioRepository.save(usuario.toBuilder()
                        .id(UUID.randomUUID().toString())
                        .password(passwordEncoder.encode(usuario.getPassword())).build()))
                .build();
    }

    public Message login(String username, String rawPassword) {
        return usuarioRepository.findByUsername(username)
                .map(usuario -> passwordEncoder.matches(rawPassword, usuario.getPassword()) ?
                        Message.builder().message("Usuario logueado").data(usuario).build() :
                        Message.builder().message("Contraseña incorrecta").data(null).build())
                .orElse(Message.builder().message("Usuario no encontrado").data(null).build());
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    private boolean existingUsuario(String documentNumber, String documentType) {
        return usuarioRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber).isPresent();
    }

    private boolean existingEmail(String emailUsuario) {
        return usuarioRepository.findByEmail(emailUsuario).isPresent();
    }

    private boolean existingUsername(String username) {
        return usuarioRepository.findByUsername(username).isPresent();
    }

}
