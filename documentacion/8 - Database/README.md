
# 8. Funcionamiento y estructura de la base de datos

Como se ha señalado antes, esta base de datos se adecuo a las necesidades del sistema para poder llevar un buen orden
y registro de todos los datos necesarios para su funcionamiento.
Fue desarrollado con **Spring Boot**, **JPA/Hibernate**, **MySQL** y **Thymeleaf**.

El sistema incluye funcionalidades para:
- Registrar y visualizar **pacientes**.  
- Asignar **doctores** con horarios disponibles.  
- Administrar **encargados** del área de atención.  
- Registrar, listar y filtrar **citas médicas pendientes, completadas o canceladas**.

---

##  Estructura General

###  Tabla: doctores
| Campo              | Tipo         | Descripción                          |
|--------------------|--------------|--------------------------------------|
| id_doctor (PK)     | BIGINT       | Identificador único del doctor.      |
| nombre             | VARCHAR(100) | Nombre completo del doctor.          |
| especialidad       | VARCHAR(100) | Especialidad médica.                 |
| horario_disponible | VARCHAR(50)  | Matutino o Vespertino.               |
| telefono           | VARCHAR(20)  | Número de contacto.                  |
| email              | VARCHAR(100) | Correo electrónico profesional.      |

---

###  Tabla: encargados
| Campo              | Tipo         | Descripción                         |
|--------------------|--------------|-------------------------------------|
| id_encargado (PK)  | BIGINT       | Identificador único del encargado.  |
| nombre             | VARCHAR(100) | Nombre completo del encargado.      |
| telefono           | VARCHAR(20)  | Teléfono de contacto.               |
| turno              | VARCHAR(50)  | Turno asignado (Matutino/Vespertino). |

---

### Tabla: pacientes
| Campo            | Tipo         | Descripción                          |
|------------------|--------------|--------------------------------------|
| id_paciente (PK) | BIGINT       | Identificador único del paciente.    |
| nombre           | VARCHAR(100) | Nombre completo.                     |
| edad             | INT          | Edad del paciente.                   |
| genero           | VARCHAR(10)  | Masculino/Femenino/Otro.             |
| telefono         | VARCHAR(20)  | Número de contacto.                  |

---

###  Tabla: citas
| Campo               | Tipo         | Descripción                                 |
|---------------------|--------------|---------------------------------------------|
| id_cita (PK)        | BIGINT       | Identificador único de la cita.             |
| fecha               | DATE         | Fecha programada de la cita.                |
| hora                | TIME         | Hora asignada.                              |
| motivo              | VARCHAR(200) | Motivo o descripción breve.                 |
| estado              | VARCHAR(50)  | pendiente / completada / cancelada.         |
| fk_id_paciente (FK) | BIGINT       | Paciente asignado.                          |
| fk_id_doctor (FK)   | BIGINT       | Doctor asignado.                            |
| fk_id_encargado (FK)| BIGINT       | Encargado que registró la cita.             |

---

## Consultas Principales

###  Obtener todas las citas
```sql
SELECT * FROM citas;
```

###  Ver citas pendientes
```sql
SELECT * FROM citas WHERE estado = 'pendiente';
```

###  Ver citas completadas
```sql
SELECT * FROM citas WHERE estado = 'completada';
```

###  Ver citas de un doctor específico
```sql
SELECT * FROM citas WHERE fk_id_doctor = ?;
```

###  Obtener pacientes atendidos por un doctor
```sql
SELECT p.nombre, c.fecha, c.estado
FROM citas c
JOIN pacientes p ON c.fk_id_paciente = p.id_paciente
WHERE c.fk_id_doctor = ?;
```

###  Listar doctores y sus horarios
```sql
SELECT nombre, especialidad, horario_disponible FROM doctores;
```

###  Citas gestionadas por un encargado
```sql
SELECT c.id_cita, p.nombre AS paciente, d.nombre AS doctor, c.fecha, c.hora
FROM citas c
JOIN pacientes p ON c.fk_id_paciente = p.id_paciente
JOIN doctores d ON c.fk_id_doctor = d.id_doctor
WHERE c.fk_id_encargado = ?;
```

---

## Funcionamiento simplificado

1. **Los pacientes** se registran en la base.  
2. **Los encargados** crean nuevas citas asignando doctor, paciente y fecha.  
3. **Los doctores** pueden visualizar sus citas pendientes en su vista.  
4. **El sistema** actualiza el estado de la cita cuando se completa o cancela.
5. **Los encargados** son los únicos que pueden crear nuevos doctores o pacientes en el sistema.

