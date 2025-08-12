package com.hache07.ForoHub.domain.usuario;



public record DatosListaUsuario(
        String nombre,
        String correoElectronico

) {
    public DatosListaUsuario(Usuario usuario){
        this(
                usuario.getNombre(),
                usuario.getCorreoElectronico()
        );
    }
}
