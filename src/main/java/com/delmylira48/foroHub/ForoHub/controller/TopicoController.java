package com.delmylira48.foroHub.ForoHub.controller;

import com.delmylira48.foroHub.ForoHub.domain.topico.ActualizarTopicoDTO;
import com.delmylira48.foroHub.ForoHub.domain.topico.DetalleTopicoDTO;
import com.delmylira48.foroHub.ForoHub.domain.topico.TopicoDTO;
import com.delmylira48.foroHub.ForoHub.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalleTopicoDTO> agregarNuevoTopico(@RequestBody @Valid TopicoDTO topicoDTO, UriComponentsBuilder uriComponentsBuilder){
        var content= topicoService.agregarTopico(topicoDTO);

        URI uri=uriComponentsBuilder.path("/topico/{id}").buildAndExpand(content.id()).toUri();
        return ResponseEntity.created(uri).body(content);

    }

    @GetMapping
    public ResponseEntity<Page<TopicoDTO>> listar(@PageableDefault Pageable datos){
        return topicoService.listarTopico(datos);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarUnTopico(@PathVariable Long id){
        return topicoService.listarUnTopico(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity listarUnTopico(@RequestBody ActualizarTopicoDTO actualizarTopicoDTO){
        return topicoService.actualizarTopico(actualizarTopicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        return topicoService.eliminarTopico(id);
    }
}
