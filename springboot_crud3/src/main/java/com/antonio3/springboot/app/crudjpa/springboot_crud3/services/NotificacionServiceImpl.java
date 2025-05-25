package com.antonio3.springboot.app.crudjpa.springboot_crud3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antonio3.springboot.app.crudjpa.springboot_crud3.entities.Notificacion;
import com.antonio3.springboot.app.crudjpa.springboot_crud3.repository.NotificacionesRepository;

@Service
public class NotificacionServiceImpl implements NotificacionService{

    @Autowired
    private NotificacionesRepository repository;

    @Override
    @Transactional
    public Optional<Notificacion> delete(Notificacion unNotificacion) {
        Optional<Notificacion> notificacionOptional = repository.findById(unNotificacion.getId());
        notificacionOptional.ifPresent(notificacionDb->{
            repository.delete(unNotificacion);
        });
        return notificacionOptional;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notificacion> findByAll() {
        return (List<Notificacion>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Notificacion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Notificacion save(Notificacion unNotificacion) {
        return repository.save(unNotificacion);
    }

}
