package com.hache07.ForoHub.domain.topico;

import com.hache07.ForoHub.domain.curso.Curso;
import com.hache07.ForoHub.domain.curso.DatosCurso;
import com.hache07.ForoHub.domain.usuario.DatosDetalleUsuario;
import com.hache07.ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListaTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Estado estado,
        String autor,
        Curso curso
) {

    public DatosListaTopico(Topico topico){

        this(

                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getEstado(),
                topico.getUsuario().getNombre(),
                topico.getCurso()
        );
    }
}
