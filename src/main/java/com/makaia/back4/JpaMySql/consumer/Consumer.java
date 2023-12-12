package com.makaia.back4.JpaMySql.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.dtos.NotificacionData;
import com.makaia.back4.JpaMySql.entities.Amistad;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.repositories.AmistadRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import com.makaia.back4.JpaMySql.services.Service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @Autowired
    Service amistadService;

    @Autowired
    AmistadRepository amistadRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @RabbitListener(queues = { "comentario_creado" }) // user_created: Nombre de la cola que se quiere escuchar
    public void receive(@Payload Message object) {
        try {
            String json = new String(object.getBody(), StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            NotificacionData notificacionData = objectMapper.readValue(json, NotificacionData.class);
            log.info("Enviando amistad para el usuario {}", notificacionData.getNotificadoId());
            CrearDTO defaultP = new CrearDTO(new Date(), false, notificacionData.getEmisorId(), notificacionData.getNotificadoId());
            List<Amistad> amistads = this.amistadRepository.findAmistad(getUser(notificacionData.getEmisorId()), getUser(notificacionData.getNotificadoId()));
            if (amistads.isEmpty()){
                Amistad amistad = amistadService.crear(defaultP);
                log.info("Solicitud enviada exitosamente {}", amistad);
            }
        } catch (IOException e) {
            log.error("Error al procesar el Solicitud: {}", e.getMessage());
        }

    }

    private Usuario getUser(Long user_id){
        Optional<Usuario> usuario =  usuarioRepository.findById(user_id);
        if (usuario.isPresent()){
            return usuario.get();
        }
        return null;
    }
        
}
