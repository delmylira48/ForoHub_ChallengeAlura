package com.delmylira48.foroHub.ForoHub.domain.topico;

import com.delmylira48.foroHub.ForoHub.domain.curso.Curso;
import com.delmylira48.foroHub.ForoHub.domain.curso.ICursoRepository;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.IUsuarioRepository;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            throw new RuntimeException("Usuario invalido");
        }
        if (!curso.isPresent()){
            throw new RuntimeException("Curso invalido");
        }
        Usuario user = usuario.get();
        Curso cursoN = curso.get();

        Topico topico = new Topico(null, topicoDTO.titulo(),topicoDTO.contenido(), LocalDateTime.now(), Estatus.VIGENTE, user,cursoN);

        topico= topicoRepository.save(topico);

        return new DetalleTopicoDTO(topico);
    }

    public Page<TopicoDTO> listarTopico(Pageable datos){
        Page<Topico> topicos = topicoRepository.findAll(datos);
        return topicos.map(TopicoDTO::new);
    }

    public DetalleTopicoDTO listarUnTopico( Long id){
        var opcionalTopico = topicoRepository.findById(id);
        if (!opcionalTopico.isPresent()){
            throw  new RuntimeException("no existe el topico");
        }
        return new DetalleTopicoDTO(opcionalTopico.get());
    }

    @Transactional
    public DetalleTopicoDTO actualizarTopico(ActualizarTopicoDTO actualizarTopicoDTO){
        var opcionalTopico = topicoRepository.findById(actualizarTopicoDTO.id());
        if (!opcionalTopico.isPresent()){
            throw  new RuntimeException("no existe el topico");
        }
        Topico topico = topicoRepository.getReferenceById(actualizarTopicoDTO.id());
        topico.actualizarDatos(actualizarTopicoDTO);
        return new DetalleTopicoDTO(topico);

    }

    @Transactional
    public DetalleTopicoDTO eliminarTopico(Long id) {
        var opcionalTopico = topicoRepository.findById(id);
        if (!opcionalTopico.isPresent()){
            throw  new RuntimeException("no existe el topico");
        }
        Topico topic = topicoRepository.getReferenceById(id);
        topic.eliminarTopic();
        return new DetalleTopicoDTO(topic);
    }
}
