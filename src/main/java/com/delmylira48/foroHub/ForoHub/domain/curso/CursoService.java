package com.delmylira48.foroHub.ForoHub.domain.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CursoService {

    @Autowired
    private ICursoRepository cursoRepository;

    public CursoDTO agregarCurso(CursoDTO cursoDTO){
        Curso curso;
        var opcionalCurso = cursoRepository.findByNombre(cursoDTO.nombre());
        if(opcionalCurso.isPresent()){
            throw new RuntimeException("Ya existe el curso");
        }else{
            curso = new Curso(cursoDTO);
            cursoRepository.save(curso);
        }
        return new CursoDTO(curso);
    }

    public Page<CursoDTO> listar(Pageable paginacion){
        Page<Curso> cursos = cursoRepository.findAll(paginacion);
        return cursos.map(CursoDTO::new);
    }

}
