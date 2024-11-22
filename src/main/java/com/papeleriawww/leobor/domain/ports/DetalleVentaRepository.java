package com.papeleriawww.leobor.domain.ports;

import com.papeleriawww.leobor.domain.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, String> {
}
