CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    usuario_id BIGINT NOT NULL,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensaje VARCHAR(100) NOT NULL UNIQUE,
    estado VARCHAR(100) NOT NULL,
    fecha DATETIME NOT NULL,
     curso_nombre VARCHAR(255) NOT NULL,
     curso_categoria VARCHAR(50) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_topicos_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
