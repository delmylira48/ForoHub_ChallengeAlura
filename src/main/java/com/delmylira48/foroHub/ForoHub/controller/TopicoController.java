package com.delmylira48.foroHub.ForoHub.controller;

import com.delmylira48.foroHub.ForoHub.domain.topico.ActualizarTopicoDTO;
import com.delmylira48.foroHub.ForoHub.domain.topico.DetalleTopicoDTO;
import com.delmylira48.foroHub.ForoHub.domain.topico.TopicoDTO;
import com.delmylira48.foroHub.ForoHub.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public DetalleTopicoDTO agregarNuevoTopico(@RequestBody TopicoDTO topicoDTO){
        return topicoService.agregarTopico(topicoDTO);
    }

    @GetMapping
    public Page<TopicoDTO> listar(@PageableDefault Pageable datos){
        return topicoService.listarTopico(datos);
    }

    @GetMapping("/{id}")
    public DetalleTopicoDTO listarUnTopico(@PathVariable Long id){
        return topicoService.listarUnTopico(id);
    }

    @PutMapping
    @Transactional
    public DetalleTopicoDTO listarUnTopico(@RequestBody ActualizarTopicoDTO actualizarTopicoDTO){
        return topicoService.actualizarTopico(actualizarTopicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public DetalleTopicoDTO eliminarTopico(@PathVariable Long id){
        return topicoService.eliminarTopico(id);
    }
}
