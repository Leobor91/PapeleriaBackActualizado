package com.papeleriawww.leobor.domain.services;

import com.papeleriawww.leobor.domain.model.Message;
import com.papeleriawww.leobor.domain.model.Producto;
import com.papeleriawww.leobor.domain.ports.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.csv.*;

import java.io.*;
import java.util.Base64;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProductosService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findByAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }


    public Message save(Producto producto) {
        Producto existingProducto = productoRepository.findById(producto.getCodigo()).orElse(null);
        return existingProducto != null ? Message.builder()
                .message("Producto actualizado")
                .data(productoRepository.save(existingProducto.toBuilder()
                        .nombre(producto.getNombre())
                        .nitProveedor(producto.getNitProveedor())
                        .precioCompra(producto.getPrecioCompra())
                        .ivaCompra(producto.getIvaCompra())
                        .precioVenta(producto.getPrecioVenta())
                        .cantidad(existingProducto.getCantidad() + producto.getCantidad())
                        .build()))
                .build() :
                Message.builder()
                        .message("Producto guardado")
                        .data(productoRepository.save(producto))
                        .build();


    }

    public Message saveProductosFromBase64(String base64) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);
            Reader reader = new InputStreamReader(inputStream);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("codigo", "nombre", "nitProveedor", "precioCompra", "ivaCompra", "precioVenta", "cantidad").parse(reader);

            List<Producto> productos = new ArrayList<>();
            for (CSVRecord record : records) {
                Producto producto = Producto.builder()
                        .codigo(Long.parseLong(record.get("codigo")))
                        .nombre(record.get("nombre"))
                        .nitProveedor(Long.parseLong(record.get("nitProveedor")))
                        .precioCompra(Double.parseDouble(record.get("precioCompra")))
                        .ivaCompra(Double.parseDouble(record.get("ivaCompra")))
                        .precioVenta(Double.parseDouble(record.get("precioVenta")))
                        .cantidad(Integer.parseInt(record.get("cantidad")))
                        .build();
                productos.add(producto);
            }

            for (Producto producto : productos) {
                Producto existingProducto = productoRepository.findById(producto.getCodigo()).orElse(null);
                if (existingProducto != null) {
                    existingProducto.toBuilder().cantidad(existingProducto.getCantidad() + producto.getCantidad()).build();
                    productoRepository.save(existingProducto);
                } else {
                    productoRepository.save(producto);
                }
            }

            return Message.builder().message("Productos guardados o actualizados").data(productos).build();
        } catch (IOException e) {
            return Message.builder().message("Error al procesar el archivo CSV").data(null).build();
        }
    }
}


