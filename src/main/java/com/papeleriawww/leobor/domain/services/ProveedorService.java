package com.papeleriawww.leobor.domain.services;


import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Proveedor;
import com.papeleriawww.leobor.domain.ports.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    public Proveedor findById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Message save(Proveedor proveedor) {
        if (isProveedorNitExists(proveedor.getNit())) {
            throw new IllegalArgumentException("El proveedor con este NIT ya existe");
        }
        Proveedor savedProveedor = proveedorRepository.save(proveedor);
        return Message.builder()
                .message("Proveedor guardado exitosamente")
                .data(savedProveedor)
                .build();
    }

    public void deleteById(Long id) {
        proveedorRepository.deleteById(id);
    }

    private boolean isProveedorNitExists(long nit) {
        return proveedorRepository.findAll().stream().anyMatch(proveedor -> proveedor.getNit() == nit);
    }
}