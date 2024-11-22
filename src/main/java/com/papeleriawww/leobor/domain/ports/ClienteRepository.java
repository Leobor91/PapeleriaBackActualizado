package com.papeleriawww.leobor.domain.ports;

import com.papeleriawww.leobor.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);
}
