package com.hache07.ForoHub.controller;


import com.hache07.ForoHub.domain.topico.DatosListaTopico;
import com.hache07.ForoHub.domain.usuario.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistrosUsuario datos, UriComponentsBuilder uriComponentsBuilder){

        // Encriptar la contraseña antes de guardar
        String contrasenaEncriptada= passwordEncoder.encode(datos.contrasena());

        var usuario= new Usuario(datos.nombre(),datos.correoElectronico(), contrasenaEncriptada);
        repository.save(usuario);

        var uri=uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaUsuario>> listar(@PageableDefault(size=10, sort={"nombre"}) Pageable paginacion){


        var page= repository.findAll(paginacion).map(DatosListaUsuario::new);

        return ResponseEntity.ok(page);

    }
}
