package com.antonio.springboot.app.crudjpa.springboot_crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.antonio.springboot.app.crudjpa.springboot_crud.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
