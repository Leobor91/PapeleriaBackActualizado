package com.papeleriawww.leobor.domain.services;

import com.papeleriawww.leobor.domain.model.DetalleVenta;
import com.papeleriawww.leobor.domain.ports.DetalleVentaRepository;
import com.papeleriawww.leobor.domain.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta findById(String id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public Message save(DetalleVenta detalleVenta) {
        DetalleVenta savedDetalleVenta = detalleVentaRepository.save(detalleVenta);
        return Message.builder()
                .message("Detalle de venta guardado exitosamente")
                .data(savedDetalleVenta)
                .build();
    }

    public Message update(String id, DetalleVenta detalleVentaDetails) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id).orElse(null);
        if (detalleVenta == null) {
            return Message.builder().message("Detalle de venta no encontrado").data(null).build();
        }
        DetalleVenta updatedDetalleVenta = DetalleVenta.builder()
                .codigoDetalleVenta(detalleVenta.getCodigoDetalleVenta())
                .cantidadProducto(detalleVentaDetails.getCantidadProducto())
                .codigoProducto(detalleVentaDetails.getCodigoProducto())
                .codigoVenta(detalleVentaDetails.getCodigoVenta())
                .valorTotal(detalleVentaDetails.getValorTotal())
                .valorVenta(detalleVentaDetails.getValorVenta())
                .valorIva(detalleVentaDetails.getValorIva())
                .build();
        updatedDetalleVenta = detalleVentaRepository.save(updatedDetalleVenta);
        return Message.builder()
                .message("Detalle de venta actualizado exitosamente")
                .data(updatedDetalleVenta)
                .build();
    }

    public void deleteById(String id) {
        detalleVentaRepository.deleteById(id);
    }
}