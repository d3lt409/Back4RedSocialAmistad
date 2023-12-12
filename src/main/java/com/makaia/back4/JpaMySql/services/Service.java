package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Amistad;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.repositories.AmistadRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {

    AmistadRepository repository;
    UsuarioRepository usuarioRepository;

    @Autowired
    public Service(AmistadRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Amistad crear(CrearDTO dto) {
        Usuario usuarioEnvia = this.usuarioRepository
                .findById(dto.getSolicitanteId())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede enviar solicitud"));
        Usuario usuarioRecibe = this.usuarioRepository
                .findById(dto.getSolicitadoId())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede recibir solicitud"));
        Amistad nuevoAmistad = new Amistad(dto.getIsAceptado(), dto.getDesde(), usuarioEnvia, usuarioRecibe);
        return this.repository.save(nuevoAmistad);
    }

    public List<Amistad> listarSolicitudes(Long user_id) {
        Usuario solicitant = this.usuarioRepository
                .findById(user_id)
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede enviar solicitud"));

        List<Amistad> amistades = StreamSupport.stream(this.repository.findByEnvia(solicitant).spliterator(), false)
                .toList();
        return amistades;
    }

    public List<Amistad> listarAmistades(Long user1_id, Long user2_id) {
        Usuario solicitante = this.usuarioRepository
                .findById(user1_id)
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede enviar solicitud"));

        Usuario solicitado = this.usuarioRepository
                .findById(user2_id)
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede enviar solicitud"));

        List<Amistad> amistades = StreamSupport
                .stream(this.repository.findAmistad(solicitante, solicitado).spliterator(), false)
                .toList();
        return amistades;
    }

    public List<Amistad> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }
}
