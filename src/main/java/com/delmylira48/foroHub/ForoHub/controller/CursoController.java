package com.delmylira48.foroHub.ForoHub.controller;

import com.delmylira48.foroHub.ForoHub.domain.curso.CursoDTO;
import com.delmylira48.foroHub.ForoHub.domain.curso.CursoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @Transactional
    public CursoDTO agregarCurso(@RequestBody @Valid CursoDTO cursoDTO){
        return cursoService.agregarCurso(cursoDTO);
    }

    @GetMapping
    public Page<CursoDTO> listar(@PageableDefault  Pageable paginacion){
        return cursoService.listar(paginacion);
    }

}
