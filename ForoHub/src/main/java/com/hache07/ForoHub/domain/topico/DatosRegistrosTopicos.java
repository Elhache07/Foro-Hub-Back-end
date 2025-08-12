package com.hache07.ForoHub.domain.topico;

import com.hache07.ForoHub.domain.curso.Curso;
import com.hache07.ForoHub.domain.curso.DatosCurso;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistrosTopicos(
        @NotNull Long idUsuario,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull @Valid DatosCurso curso


) {
}
