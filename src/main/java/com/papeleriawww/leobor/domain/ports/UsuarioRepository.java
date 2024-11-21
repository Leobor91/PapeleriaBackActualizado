package com.papeleriawww.leobor.domain.ports;

import com.papeleriawww.leobor.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);
    Optional<Usuario> findByUsername(String username);

}
