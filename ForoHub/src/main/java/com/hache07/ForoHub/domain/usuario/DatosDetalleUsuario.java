package com.hache07.ForoHub.domain.usuario;



public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        String contrasena) {

    public DatosDetalleUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                usuario.getContrasena()
        );
    }
}
