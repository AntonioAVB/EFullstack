package com.antonio2.springboot.app.crudjpa.springboot__crud2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antonio2.springboot.app.crudjpa.springboot__crud2.entities.Curso;
import com.antonio2.springboot.app.crudjpa.springboot__crud2.repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository repository;
    
    @Override
    @Transactional
    public Optional<Curso> delete(Curso uncCurso) {
        Optional<Curso> cursoOptional = repository.findById(uncCurso.getId());
        cursoOptional.ifPresent(cursoDb->{
            repository.delete(uncCurso);
        });
        return cursoOptional;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findByAll() {
        return (List<Curso>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Curso save(Curso uncCurso) {
        return repository.save(uncCurso);
    }

}
