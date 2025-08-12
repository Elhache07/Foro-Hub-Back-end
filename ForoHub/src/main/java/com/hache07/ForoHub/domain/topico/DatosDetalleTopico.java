package com.hache07.ForoHub.domain.topico;

import com.hache07.ForoHub.domain.curso.Curso;
import com.hache07.ForoHub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Estado estado,
        String autor,
        Curso curso
) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getEstado(),
                topico.getUsuario().getNombre(),
                topico.getCurso()
        );
    }
}
