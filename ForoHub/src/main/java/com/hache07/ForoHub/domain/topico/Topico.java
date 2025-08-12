package com.hache07.ForoHub.domain.topico;

import com.hache07.ForoHub.domain.curso.Curso;
import com.hache07.ForoHub.domain.usuario.Usuario;
import com.hache07.ForoHub.domain.usuario.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nombre", column = @Column(name = "curso_nombre")),
            @AttributeOverride(name = "categoria", column = @Column(name = "curso_categoria"))
    })
    private Curso curso;

    public Topico(@Valid DatosRegistrosTopicos datos,Usuario usuario) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = LocalDateTime.now();
        this.estado = Estado.ABIERTO;
        this.curso = new Curso(datos.curso());
        this.usuario = usuario;
    }

    public void actualizarInformaciones(DatosActualizacionTopicos datos, UsuarioRepository usuarioRepository) {
        if (datos.idUsuario() != null){
            this.usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        }

        if (datos.titulo() != null){
            this.titulo=datos.titulo();
        }

        if (datos.mensaje() != null){
            this.mensaje=datos.mensaje();
        }
        if (datos.estado() != null){
            this.estado=datos.estado();
        }

        if (datos.curso() != null){
            this.curso=new Curso(datos.curso());
        }

    }
}
