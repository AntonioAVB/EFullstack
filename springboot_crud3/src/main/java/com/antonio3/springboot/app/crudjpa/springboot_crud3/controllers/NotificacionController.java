package com.antonio3.springboot.app.crudjpa.springboot_crud3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonio3.springboot.app.crudjpa.springboot_crud3.entities.Notificacion;
import com.antonio3.springboot.app.crudjpa.springboot_crud3.services.NotificacionService;

@RestController
@RequestMapping("api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @GetMapping
    public List<Notificacion> List(){
        return service.findByAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verDetalle(@PathVariable Long id){
        Optional<Notificacion> notificacionOptional = service.findById(id);
        if (notificacionOptional.isPresent()) {
            return ResponseEntity.ok(notificacionOptional.orElseThrow());         
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Notificacion> crear(@RequestBody Notificacion unNotificacion){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(unNotificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody Notificacion unNotificacion){
        Optional <Notificacion> notificacionOptional = service.findById(id);
        if (notificacionOptional.isPresent()){
            Notificacion notificacionexistente = notificacionOptional.get();
            notificacionexistente.setDestinatario(unNotificacion.getDestinatario());
            notificacionexistente.setMensaje(unNotificacion.getMensaje());
            Notificacion notificacionmodificado = service.save(notificacionexistente);
            return ResponseEntity.ok(notificacionmodificado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Notificacion unNotificacion = new Notificacion();
        unNotificacion.setId(id);
        Optional<Notificacion> notificacionOptional = service.delete(unNotificacion);
        if (notificacionOptional.isPresent()) {
            return ResponseEntity.ok(notificacionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
