package com.makaia.back4.JpaMySql.repositories;

import com.makaia.back4.JpaMySql.entities.Amistad;
import com.makaia.back4.JpaMySql.entities.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AmistadRepository extends CrudRepository<Amistad, Long> {

    @Query(value = "select a from Amistad a where a.solicitante = ?1 OR a.solicitado = ?1")
    List<Amistad> findByEnvia(Usuario usuario);

    @Query(value = "select a from Amistad a where (a.solicitante = :solicitante AND a.solicitado = :solicitado) OR (a.solicitante = :solicitado AND a.solicitado = :solicitante)")
    List<Amistad> findAmistad(@Param("solicitante") Usuario usuarioSolicitante,
            @Param("solicitado") Usuario usuarioSolicitado);
}
