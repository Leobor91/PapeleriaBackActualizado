package com.papeleriawww.leobor.domain.services;

import com.papeleriawww.leobor.domain.model.Venta;
import com.papeleriawww.leobor.domain.ports.VentaRepository;
import com.papeleriawww.leobor.domain.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    public Venta findById(String id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Message save(Venta venta) {
        Venta savedVenta = ventaRepository.save(venta.toBuilder().codigoVenta(UUID.randomUUID().toString()).build());
        return Message.builder()
                .message("Venta guardada exitosamente")
                .data(savedVenta)
                .build();
    }

    public Message update(String id, Venta ventaDetails) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        if (venta == null) {
            return Message.builder().message("Venta no encontrada").data(null).build();
        }
        Venta updatedVenta = Venta.builder()
                .codigoVenta(venta.getCodigoVenta())
                .cedulaCliente(ventaDetails.getCedulaCliente())
                .valorVenta(ventaDetails.getValorVenta())
                .ivaVenta(ventaDetails.getIvaVenta())
                .totalVenta(ventaDetails.getTotalVenta())
                .nombreCliente(ventaDetails.getNombreCliente())
                .build();
        updatedVenta = ventaRepository.save(updatedVenta);
        return Message.builder()
                .message("Venta actualizada exitosamente")
                .data(updatedVenta)
                .build();
    }

    public void deleteById(String id) {
        ventaRepository.deleteById(id);
    }
}
