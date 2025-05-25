package com.antonio.springboot.app.crudjpa.springboot_crud.controllers;

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

import com.antonio.springboot.app.crudjpa.springboot_crud.entities.Usuario;
import com.antonio.springboot.app.crudjpa.springboot_crud.services.UsuarioService;


@RestController
@RequestMapping("api/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> List(){
        return service.findByAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verDetalle(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = service.findById(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.orElseThrow());         
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario unUsuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(unUsuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody Usuario unUsuario){
        Optional <Usuario> usuarioOptional = service.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuarioexistente = usuarioOptional.get();
            usuarioexistente.setNombre(unUsuario.getNombre());
            usuarioexistente.setEmail(unUsuario.getEmail());
            usuarioexistente.setContraseña(unUsuario.getContraseña());
            Usuario usuariomodificado = service.save(usuarioexistente);
            return ResponseEntity.ok(usuariomodificado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Usuario unUsuario = new Usuario();
        unUsuario.setId(id);
        Optional<Usuario> usuarioOptional = service.delete(unUsuario);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
