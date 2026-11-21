package com.fileflip.arquivo_service.repositories;
import com.fileflip.arquivo_service.models.Arquivo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, UUID> {
    List<Arquivo> findByUsuarioId(UUID usuarioId);
}
