📌 ForoHub – API REST
ForoHub es una API REST desarrollada con Spring Boot que implementa un sistema básico de foros con autenticación JWT. Permite gestionar usuarios, iniciar sesión y administrar tópicos (publicaciones) de manera segura.

✨ Funcionalidades principales
🔐 Autenticación
Inicio de sesión (POST /login):
Autentica al usuario con correo y contraseña, generando un token JWT para acceder a los demás endpoints protegidos.

Validación de credenciales usando AuthenticationManager.

Generación de token con TokenService.

Respuesta con DatosTokenJWT.

👤 Gestión de usuarios (UsuarioController)
Registrar usuario (POST /usuarios):

Recibe datos del nuevo usuario.

Encripta la contraseña con PasswordEncoder.

Guarda el usuario en la base de datos.

Listar usuarios (GET /usuarios):

Soporta paginación y ordenamiento (por defecto por nombre).

Eliminar usuario (DELETE /usuarios/{id}):

Elimina el usuario por su ID.

📝 Gestión de tópicos (TopicoController)
Registrar tópico (POST /topicos):

Crea un nuevo tópico asociado a un usuario existente.

Devuelve el detalle del tópico creado.

Listar tópicos (GET /topicos):

Devuelve lista paginada y ordenada (por defecto por fecha).

Obtener detalle de un tópico (GET /topicos/{id}):

Devuelve información completa de un tópico.

Actualizar tópico (PUT /topicos):

Permite modificar título, mensaje o datos asociados.

Eliminar tópico (DELETE /topicos/{id}):

Elimina un tópico por su ID.

🛡️ Seguridad
Uso de JWT para proteger rutas.

Control de acceso mediante la anotación @SecurityRequirement(name = "bearer-key").

Contraseñas cifradas con BCrypt.

📂 Tecnologías usadas
Java 17+

Spring Boot

Spring Security

JPA / Hibernate

Swagger/OpenAPI (documentación automática)

JWT (Json Web Token)

MySQL / PostgreSQL (dependiendo de configuración)
