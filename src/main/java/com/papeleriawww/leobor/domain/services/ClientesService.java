package com.papeleriawww.leobor.domain.services;

import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Cliente;
import com.papeleriawww.leobor.domain.ports.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientesService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findByAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Message save(Cliente cliente) {
        return existingEmail(cliente.getEmail())
                ? Message.builder().message("El email ya existe").data(null).build()
                : existingCliente(cliente.getDocumentNumber(), cliente.getDocumentType())
                ? Message.builder().message("El cliente ya existe").data(null).build()
                : Message.builder()
                .message("Cliente guardado")
                .data(clienteRepository.save(cliente.toBuilder()
                        .id(UUID.randomUUID().toString()).build()))
                .build();
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    private boolean existingCliente(String documentNumber, String documentType) {
        return clienteRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber).isPresent();
    }

    private boolean existingEmail(String emailCliente) {
        return clienteRepository.findByEmail(emailCliente).isPresent();
    }
}