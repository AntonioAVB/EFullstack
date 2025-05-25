package com.antonio2.springboot.app.crudjpa.springboot__crud2.services;

import java.util.List;
import java.util.Optional;

import com.antonio2.springboot.app.crudjpa.springboot__crud2.entities.Curso;

public interface CursoService {

    List<Curso> findByAll();

    Optional<Curso> findById(Long id);

    Curso save(Curso unCurso);

    Optional<Curso> delete (Curso unCurso);
}
