# Registro de cambios

## 1.0.2 — 30 de septiembre de 2026

Cambios aplicados al backend después de probarlo junto con la aplicación
Android.

### Agregado

**Capa de API REST**

Se agregó una API REST en JSON para que la aplicación Android pueda
operar contra el backend. El código quedó separado en cuatro paquetes:

| Paquete | Responsabilidad |
|---|---|
| `api` | Servlets, uno por recurso. |
| `dao` | Acceso a datos, una clase por tabla. |
| `modelo` | Entidades que se serializan a JSON. |
| `conexion` | Apertura y cierre de la conexión a MySQL. |

Endpoints disponibles:

| Método | Ruta | Descripción |
|---|---|---|
| POST | `/api/auth` | Inicio de sesión. |
| GET | `/api/Cupos` | Disponibilidad de cupos. |
| GET · POST | `/api/Reservas` | Listar y crear reservas. |
| GET · POST | `/api/Pagos` | Listar y registrar pagos. |
| GET | `/api/Historial` | Historial de movimientos. |
| GET · POST | `/api/Usuarios` | Listar y crear usuarios. |
| GET · POST | `/api/Vehiculos` | Listar y registrar vehículos. |

Los servlets se registran con la anotación `@WebServlet`, de modo que
`web.xml` no necesita listar ninguno. Agregar un recurso nuevo es crear
la clase con su anotación.

Además, se agregó `jackson-databind` al `pom.xml` para serializar las
respuestas.

**Esquema de base de datos**

Se agregó `database/esquema.sql` con el esquema completo de las seis
tablas, sus índices y sus llaves foráneas. El script que circulaba por
fuera del repositorio no incluía la tabla `historial`, que sí necesita la
clase de acceso a datos correspondiente.

**Documentación**

Se agregó `README.md` con los requisitos, la estructura, los pasos de
puesta en marcha, el formato de cada petición, el modelo de datos y los
problemas conocidos.

### Seguridad

**Las credenciales de la base de datos estaban en el código fuente.**

La clase de conexión tenía escrita la contraseña de MySQL. Como el
repositorio es público, subir ese archivo publicaba la clave de forma
permanente en el historial, y borrar el archivo después no la elimina:
queda en los commits anteriores.

Ahora los datos de conexión se leen de `conexion.properties`, que se
busca primero en el classpath y luego en la carpeta de despliegue. Si el
archivo no existe, la conexión falla con un mensaje que dice cuál falta,
en lugar de un error genérico de SQL.

Se versiona únicamente la plantilla `conexion.example.properties`. El
archivo real quedó fuera del control de versiones.

### Correcciones

**Había dos clases registrando la misma ruta.**

Al combinar el trabajo de dos personas sobre el repositorio, quedaron
dos servlets con la ruta `/api/auth`: uno para el servicio web y otro de
la capa REST. Tomcat no arranca cuando dos servlets declaran la misma
ruta, así que el backend no habría iniciado al desplegarlo.

Se conservó el servlet que cubre inicio de sesión y registro, y se
eliminó el que quedaba redundante.

**La respuesta de inicio de sesión no incluía el identificador del
usuario.**

La consulta solo recuperaba el nombre y el rol. La aplicación Android
guarda ese identificador para asociar las reservas al usuario que las
hace, así que sin él el inicio de sesión se completaba pero ninguna
reserva quedaba vinculada a su dueño.

Se agregó el identificador tanto a la consulta como a la respuesta.

**Faltaba un import que rompía la compilación.**

Al mover la clase de conexión del paquete `servlets` al paquete
`conexion`, el servlet de autenticación dejó de resolverla y el proyecto
dejó de compilar. Se agregó el import correspondiente.

### Limpieza del repositorio

**La carpeta de compilación estaba versionada.**

`target/` tenía 58 archivos seguidos por Git: clases compiladas, el WAR y
los JAR de las dependencias. Se dejaron de seguir y se agregó la carpeta
al archivo de exclusiones. Nada se borró del disco.

**Los archivos de texto cambiaban de finales de línea.**

Veintitrés archivos entre CSS, JavaScript y JSP aparecían como modificados
completos en cada revisión, pero su contenido era idéntico: lo único que
difería era el fin de línea, de LF a CRLF. Eso ocurre al abrir y volver
a guardar los archivos desde un equipo con Windows.

Se agregó `.gitattributes` para normalizarlos a LF en el repositorio. A
partir de ahí el historial muestra cambios reales.

**Faltaba el archivo de exclusiones.**

No existía `.gitignore` en el repositorio. Se agregó uno que combina las
reglas de compilación, archivos del sistema, claves y carpetas de los
entornos de desarrollo, más la exclusión del archivo de credenciales.

**Se eliminó el README de ejemplo.**

El repositorio traía el README de ejemplo de Apache Tomcat, que no
tenía relación con el proyecto. Se reemplazó por documentación propia.

### Estado de la versión

| | |
|---|---|
| Versión del artefacto | 1.0.2 |
| GroupId | `com.eparking` |
| ArtifactId | `eparking` |
| Empaquetado | WAR |
| Bytecode generado | 19 |

> La versión 19 del bytecode requiere **JDK 21** para ejecutarse en
> Tomcat 10. Con un runtime anterior aparece
> `java.lang.UnsupportedClassVersionError` al desplegar.

### Cómo se verificó

Después de combinar el trabajo y antes de subirlo se comprobó lo
siguiente:

- El servidor arranca sin errores de mapeo de servlets.
- Los seis recursos de lectura responden 200.
- El inicio de sesión responde 200 con identificador, nombre, correo y
  rol.
- El alta de usuario responde 201 y el registro queda en la base de
  datos.
- Un intento de alta con un correo ya registrado se rechaza con 400.
- La aplicación Android inicia sesión y llega al menú principal.
- El esquema de `database/esquema.sql` se aplicó sobre una base de datos
  limpia y creó las seis tablas con sus llaves foráneas.
