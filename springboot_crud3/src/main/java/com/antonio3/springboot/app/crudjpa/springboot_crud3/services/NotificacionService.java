package com.antonio3.springboot.app.crudjpa.springboot_crud3.services;

import java.util.List;
import java.util.Optional;

import com.antonio3.springboot.app.crudjpa.springboot_crud3.entities.Notificacion;

public interface NotificacionService {

    List<Notificacion> findByAll();

    Optional<Notificacion> findById(Long id);

    Notificacion save(Notificacion uNotificacion);

    Optional<Notificacion> delete (Notificacion uNotificacion);

}
