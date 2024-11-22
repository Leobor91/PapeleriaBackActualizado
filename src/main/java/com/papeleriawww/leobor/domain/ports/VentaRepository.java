package com.papeleriawww.leobor.domain.ports;

import com.papeleriawww.leobor.domain.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, String> {
}
