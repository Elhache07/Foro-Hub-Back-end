package com.hache07.ForoHub.domain.usuario;

import com.hache07.ForoHub.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


    UserDetails findByCorreoElectronico(String login);

    Page<Usuario> findAll(Pageable paginacion);
}
