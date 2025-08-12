package com.hache07.ForoHub.controller;

import com.hache07.ForoHub.domain.topico.*;
import com.hache07.ForoHub.domain.usuario.Usuario;
import com.hache07.ForoHub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistrosTopicos datos, UriComponentsBuilder uriComponentsBuilder) {

        Usuario usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        Topico topico = new Topico(datos, usuario);

        repository.save(topico);

        var uri= uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listar(@PageableDefault(size=10, sort={"fecha"}) Pageable paginacion){


        var page= repository.findAll(paginacion).map(DatosListaTopico::new);

        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){

        var topico= repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));

    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopicos datos){
        var topico = repository.getReferenceById(datos.id());
        topico.actualizarInformaciones(datos, usuarioRepository);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        repository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}