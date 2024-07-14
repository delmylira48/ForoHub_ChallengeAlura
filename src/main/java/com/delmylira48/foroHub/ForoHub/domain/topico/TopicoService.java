package com.delmylira48.foroHub.ForoHub.domain.topico;

import com.delmylira48.foroHub.ForoHub.domain.curso.Curso;
import com.delmylira48.foroHub.ForoHub.domain.curso.ICursoRepository;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.IUsuarioRepository;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.Usuario;
import com.delmylira48.foroHub.ForoHub.infra.errores.ValidacionDeIntegridad;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Service
public class TopicoService {
    @Autowired
    private ITopicoRepository topicoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ICursoRepository cursoRepository;

    @Transactional
    public DetalleTopicoDTO agregarTopico(TopicoDTO topicoDTO){
        var usuario = usuarioRepository.findById(topicoDTO.autor().id());
        var curso = cursoRepository.findById(topicoDTO.curso().id());
        if (!usuario.isPresent()){
            throw  new ValidacionDeIntegridad("no existe el usuario");
        }
        if (!curso.isPresent()){
            throw  new ValidacionDeIntegridad("no existe el curso");
        }
        Usuario user = usuario.get();
        Curso cursoN = curso.get();

        Topico topico = new Topico(null, topicoDTO.titulo(),topicoDTO.contenido(), LocalDateTime.now(), Estatus.VIGENTE, user,cursoN);

        topico= topicoRepository.save(topico);

        return new DetalleTopicoDTO(topico);
    }

    public ResponseEntity<Page<TopicoDTO>> listarTopico(Pageable datos){
        Page<Topico> topicos = topicoRepository.findAll(datos);
        return ResponseEntity.ok(topicos.map(TopicoDTO::new));
    }

    public ResponseEntity listarUnTopico( Long id){
        var opcionalTopico = topicoRepository.findById(id);
        if (!opcionalTopico.isPresent()){
            throw  new ValidacionDeIntegridad("no existe el topico");
        }
        return ResponseEntity.ok(new DetalleTopicoDTO(opcionalTopico.get()));
    }

    @Transactional
    public ResponseEntity actualizarTopico(ActualizarTopicoDTO actualizarTopicoDTO){
        var opcionalTopico = topicoRepository.findById(actualizarTopicoDTO.id());
        if (!opcionalTopico.isPresent()){
            throw  new ValidacionDeIntegridad("no existe el topico");
        }
        Topico topico = topicoRepository.getReferenceById(actualizarTopicoDTO.id());
        topico.actualizarDatos(actualizarTopicoDTO);
        return ResponseEntity.ok(new DetalleTopicoDTO(topico));

    }

    @Transactional
    public ResponseEntity eliminarTopico(Long id) {
        var opcionalTopico = topicoRepository.findById(id);
        if (!opcionalTopico.isPresent()){
            throw  new ValidacionDeIntegridad("no existe el topico");
        }
        Topico topic = topicoRepository.getReferenceById(id);
        topic.eliminarTopic();
        return ResponseEntity.noContent().build();
    }
}
