# E-Parking — Backend

Backend del sistema de parqueadero E-Parking. Expone dos capas: la aplicación
web clásica en JSP, y una API REST en JSON que consume la app Android del
mismo proyecto.

- **GroupId:** `com.eparking`
- **ArtifactId:** `eparking`
- **Versión:** 1.0.2
- **Empaquetado:** WAR

---

## 1. Requisitos

| Herramienta | Versión | Notas |
|---|---|---|
| JDK | 21 o superior | El `pom.xml` compila a bytecode 19, pero Tomcat 10 **no** ejecuta clases 19 en un runtime 17. Hay que correrlo con JDK 21. |
| Maven | 3.9 o superior | Para compilar y empaquetar. |
| MySQL | 8.0 o superior | Motor InnoDB. |
| Apache Tomcat | 10.1 o superior | Servlet 6.0. No funciona en Tomcat 9. |

> **Ojo con la versión de Java.** Es la causa más común de que no arranque.
> Si ves `java.lang.UnsupportedClassVersionError`, estás corriendo Tomcat con
> un JDK muy antiguo. Verifica con `java -version` en el servidor.

---

## 2. Estructura del proyecto

El código se organiza en capas, cada una en su paquete:

```
src/main/java/
├── api/         Servlets de la API REST. Un archivo por recurso.
├── conexion/    Apertura y gestión de la conexión a MySQL.
├── dao/         Acceso a datos. Un DAO por tabla.
├── modelo/      Entidades que se serializan a JSON.
└── servlets/    Servlets de la aplicación web en JSP.

src/main/webapp/
├── *.jsp        Las 9 páginas de la interfaz web.
├── css/
├── js/
├── img/
└── WEB-INF/
    └── web.xml  Declarado como Servlet 6.0, sin servlets mapeados.
```

La API REST se registra con anotaciones `@WebServlet`, por eso `web.xml` no
lista ningún servlet: se agrega una clase y el endpoint existe.

---

## 3. Puesta en marcha

### 3.1 Crear la base de datos

El esquema completo está en `database/esquema.sql`. Crea las seis tablas con
sus llaves foráneas:

```bash
mysql -u root -p < database/esquema.sql
```

Las tablas son `usuarios`, `cupos`, `vehiculos`, `reservas`, `pagos` e
`historial`.

> El script `eparking.sql` que circula fuera de este repositorio **no incluye
> la tabla `historial`**. Usa `database/esquema.sql`, que sí la tiene.

### 3.2 Configurar la conexión

La conexión está escrita en el código, en
`src/main/java/conexion/ConexionDB.java`:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/eparking?useSSL=false&serverTimezone=UTC",
    "root",
    "TU_CONTRASENA"
);
```

Cambia usuario y contraseña por los de tu servidor. **No hay variables de
entorno ni archivo de configuración** para estos datos.

### 3.3 Datos mínimos para poder probar

La aplicación no arranca sin un usuario administrador. Puedes insertarlo a
mano:

```sql
INSERT INTO usuarios (nombre, identificacion, telefono, correo, password, rol)
VALUES ('Admin', '123', '3000000000', 'admin@eparking.com', '1234', 'ADMIN');
```

> **Las contraseñas se guardan en texto plano**, sin hash. `LoginServlet`
> compara el valor directamente. Es un defecto conocido de esta versión y
> está pendiente de corregir.

Los cupos también son necesarios para probar las reservas:

```sql
INSERT INTO cupos (codigo, estado) VALUES
  ('A-01', 'DISPONIBLE'), ('A-02', 'DISPONIBLE'), ('B-01', 'DISPONIBLE');
```

### 3.4 Compilar y desplegar

```bash
mvn clean package
```

Queda `target/eparking.war`. Cópialo a Tomcat:

```bash
cp target/eparking.war $CATALINA_HOME/webapps/
```

La aplicación queda disponible en `http://localhost:8080/eparking`.

> El puerto 8080 es el predeterminado de Tomcat. Este proyecto se validó
> corriendo en el **8081**, porque la app Android tiene esa URL configurada.
> Para cambiarla, edita el `port` en `$CATALINA_HOME/conf/server.xml`.

---

## 4. API REST

Todos los endpoints cuelgan de `/eparking/api/`. Las respuestas son JSON.

> **Las rutas distinguen mayúsculas.** `/api/Cupos` responde;
> `/api/cupos` devuelve 404. Esto provocó fallos en la app Android durante
> las primeras pruebas y la causa no es obvia al leer el código.

| Método | Ruta | Descripción |
|---|---|---|
| POST | `/api/auth` | Inicio de sesión. Devuelve el usuario y su rol. |
| GET | `/api/Cupos` | Lista los cupos con su estado. |
| GET | `/api/Reservas` | Lista las reservas. |
| POST | `/api/Reservas` | Crea una reserva. |
| GET | `/api/Pagos` | Lista los pagos. |
| POST | `/api/Pagos` | Registra un pago. |
| GET | `/api/Historial` | Lista el historial. |
| GET | `/api/Usuarios` | Lista los usuarios. |
| POST | `/api/Usuarios` | Crea un usuario. |
| GET | `/api/Vehiculos` | Lista los vehículos. |
| POST | `/api/Vehiculos` | Registra un vehículo. |

### 4.1 Formato de las peticiones

Los nombres de los campos JSON deben coincidir con las propiedades de las
clases del paquete `modelo`. Estas usan Java en vez de `snake_case`, así que
un campo mal escrito devuelve **500** con
`UnrecognizedPropertyException`.

**POST `/api/auth`** — los datos van como formulario, no como JSON:

```bash
curl -X POST http://localhost:8081/eparking/api/auth \
  -d 'action=login' \
  -d 'usuario=admin@eparking.com' \
  -d 'password=1234'
```

```json
{
  "status": "success",
  "data": {
    "id": 1,
    "nombre": "Admin",
    "correo": "admin@eparking.com",
    "rol": "ADMIN"
  }
}
```

**POST `/api/Vehiculos`**

```json
{
  "placa": "ABC123",
  "tipo": "CAMION",
  "color": "ROJO",
  "propietario": "Admin",
  "usuarioId": 1
}
```

`usuarioId` es obligatorio. Sin él la respuesta es 400.

**POST `/api/Reservas`**

```json
{
  "usuarioId": 1,
  "vehiculoId": 2,
  "cupo": "A-01",
  "fecha": "2026-10-20",
  "hora": "10:00:00",
  "estado": "Activa"
}
```

**POST `/api/Pagos`**

```json
{
  "reservaId": 1,
  "metodoPago": "NEQUI",
  "total": 15000,
  "estado": "APROBADO",
  "fechaPago": "2026-10-20 10:05:00"
}
```

### 4.2 Códigos de respuesta

| Código | Significado |
|---|---|
| 200 | Consulta correcta. |
| 201 | Recurso creado. |
| 400 | Faltan datos, o la llave foránea no existe. |
| 500 | Error interno. Lo más común es un nombre de campo mal escrito. |

Hay dos defectos conocidos que conviene tener presentes al probar:

- **Los `POST` devuelven `id: 0`.** Ningún DAO pide las claves generadas al
  insertar, así que la respuesta nunca trae el `id` real aunque MySQL lo haya
  asignado. No rompe la app, que no usa ese valor, pero engaña al que prueba
  con Postman.
- **El estado de la reserva se escribe en dos convenciones.** La app envía
  `"Activa"` y el default de la columna es `ACTIVA`. Conviven ambas en la
  tabla.

### 4.3 Colección de Postman

`e-parking-api.postman_collection.json` en la raíz del repositorio trae las
peticiones listas para probar, con los casos de error incluidos.

---

## 5. Modelo de datos

```
usuarios ──┬──< vehiculos ──┐
           │                │
           └──< reservas >──┘
                  │
                  └──< pagos
```

| Tabla | Columnas | Notas |
|---|---|---|
| `usuarios` | `id`, `nombre`, `identificacion`, `telefono`, `correo`, `password`, `rol`, `fecha_registro` | `identificacion` y `correo` son únicos. |
| `cupos` | `id`, `codigo`, `estado` | `codigo` es único. |
| `vehiculos` | `id`, `placa`, `tipo`, `color`, `propietario`, `usuario_id` | `placa` es única. `usuario_id` → `usuarios.id`. |
| `reservas` | `id`, `usuario_id`, `vehiculo_id`, `cupo`, `fecha`, `hora`, `estado` | Ambas llaves apuntan a `usuarios` y `vehiculos`. |
| `pagos` | `id`, `reserva_id`, `metodo_pago`, `total`, `estado`, `fecha_pago` | `reserva_id` → `reservas.id`. |
| `historial` | `id`, `historial_id`, `fecha`, `vehiculo`, `cupo`, `estado` | Sin llave foránea. Guarda el vehículo como texto. |

`reservas.vehiculo_id` es un entero que referencia `vehiculos.id`, **no**
acepta la placa. Si necesitas reservar por placa, primero resuelve el `id`
consultando `/api/Vehiculos`. Es lo que hace la app Android.

---

## 6. Aplicación web

Nueve páginas JSP, en `src/main/webapp/`:

`index.jsp`, `login.jsp`, `registro.jsp`, `menu-principal.jsp`,
`disponibilidad.jsp`, `reservas.jsp`, `pagos.jsp`, `vehiculos.jsp`,
`historial.jsp`

Cada una delega en su servlet del paquete `servlets/`, registrados también
con `@WebServlet`.

---

## 7. Problemas conocidos

Estos defectos están identificados y pendientes. Se documentan aquí para que
no se confundan con un error de instalación durante una prueba.

| # | Problema | Impacto |
|---|---|---|
| 1 | Contraseñas en texto plano, sin hash | Seguridad. Cualquiera con acceso a la base lee las contraseñas. |
| 2 | Los `POST` devuelven `id: 0` | Engaña al probar con Postman. No rompe la app. |
| 3 | Rutas sensibles a mayúsculas | Fuente de errores 404 confusos. |
| 4 | `estado` con dos convenciones (`Activa` / `ACTIVA`) | Inconsistencia de datos. |
| 5 | Credenciales de MySQL en el código fuente | Seguridad. |
| 6 | `jackson-databind` sin `scope=provided` | Empaqueta los JAR dentro del WAR (9.7 MB en lugar de ~1 MB). |
| 7 | Sin validación de contraseña en el registro | Se aceptan contraseñas de cualquier longitud. |
| 8 | Sin límite de intentos en `/api/auth` | Permite fuerza bruta. |

---

## 8. Estructura de este repositorio

Se versiona el código fuente, no la compilación:

- `target/` está en `.gitignore`. Es salida de Maven.
- `.gitattributes` normaliza los finales de línea a LF, para que el diff
  muestre cambios reales y no terminaciones de línea.

Estos archivos **no** se versionan, por estar en `.gitignore`:
`target/`, `.DS_Store`, `*.jks`, `*.keystore`, carpetas de IDE.
