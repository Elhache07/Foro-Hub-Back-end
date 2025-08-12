package com.hache07.ForoHub.domain.topico;

import com.hache07.ForoHub.domain.curso.DatosCurso;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopicos(
        @NotNull Long id,
        Long idUsuario,
        String titulo,
        String mensaje,
        Estado estado,
        DatosCurso curso
) {
}
