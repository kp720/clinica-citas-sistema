# 1.  **Ingeniería de Requerimientos: Entrevista**

### **A. Gestión de Citas**

1.  **¿Qué canales utiliza actualmente para programar citas?  **
    Las citas se programan principalmente en persona o por teléfono.
    Algunos pacientes simplemente llegan sin cita previa, lo cual es
    común.

2.  **¿Qué tan eficiente es el proceso de programación de citas?  **
    Moderadamente eficiente. Funciona bien porque el volumen de
    pacientes no es muy alto, pero en días ocupados puede ser
    desordenado debido a la falta de un sistema formal.

3.  **¿Cuánto tiempo promedio toma programar o reprogramar una cita?  **
    Entre 5 y 10 minutos, ya que la mayoría de las citas se registran
    manualmente en un cuaderno o una agenda física.

4.  **¿Se realiza algún recordatorio automático para las citas?  **
    No. Normalmente, se confía en que los pacientes recuerden sus citas.
    Algunos pacientes reciben un recordatorio verbal si llaman para
    confirmar.

5.  **¿Existen problemas frecuentes en el manejo de citas
    (cancelaciones, duplicados, olvidos)?  **
    Sí. Algunos pacientes olvidan sus citas, y otros llegan sin avisar,
    lo que puede causar retrasos y confusión.

### **B. Atención al Paciente**

1.  **¿Cómo se registra la llegada del paciente al consultorio?  **
    El registro se hace manualmente en una hoja o cuaderno. El personal
    anota el nombre del paciente y el motivo de la consulta.

2.  **¿Cuánto tiempo espera en promedio un paciente antes de ser
    atendido?  **
    Generalmente, unos 15-30 minutos, pero puede ser más en días
    concurridos o cuando hay emergencias.

3.  **¿Existen pasos redundantes o innecesarios en el flujo de atención
    al paciente?  **
    Sí. Por ejemplo, el registro manual a veces se repite si la
    información se transcribe en otro lugar después de la consulta.

4.  **¿Qué tan accesible y claro es el historial clínico del paciente
    para los médicos?  **
    El historial clínico suele ser limitado y en papel, lo que dificulta
    el acceso rápido o la actualización. Algunos pacientes no tienen un
    registro formal, y el médico depende de lo que recuerdan.

### **C. Consulta Médica**

1.  **¿Qué herramientas utiliza el médico para registrar información
    durante la consulta?  **
    Se utiliza principalmente papel y bolígrafo para registrar síntomas,
    diagnósticos y tratamientos. En algunos casos, un cuaderno exclusivo
    del consultorio.

2.  **¿Hay algún problema técnico con el sistema de registro de
    consultas (lento, desactualizado, etc.)?  **
    No aplica, ya que el sistema es manual. Sin embargo, el riesgo de
    pérdida de información o errores por caligrafía ilegible es un
    problema.

3.  **¿Se realizan diagnósticos auxiliares (exámenes básicos) en el
    consultorio?  **
    Sí, pero son limitados. Por ejemplo, se toman la presión arterial y
    los niveles de glucosa con equipos básicos.

4.  **¿Cómo se emiten las recetas médicas?  **
    Las recetas se escriben a mano. Se entregan directamente al
    paciente, y en la mayoría de los casos, el medicamento se dispensa
    en la farmacia anexa.

### **D. Dispensación de Medicamentos**

1.  **¿Qué sistema utiliza la farmacia para gestionar inventarios?  **
    El inventario se gestiona manualmente en una libreta o tabla. Se
    hace una revisión periódica para actualizar la información.

2.  **¿Cómo se verifica la validez de las recetas médicas?  **
    El personal de la farmacia revisa visualmente la receta y se asegura
    de que esté firmada y sellada por el médico.

3.  **¿Existen problemas frecuentes en el inventario, como faltantes o
    caducidades?  **
    Sí. A veces hay faltantes porque los proveedores no entregan a
    tiempo, y los medicamentos de baja rotación corren riesgo de
    caducidad.

4.  **¿El personal de la farmacia ofrece orientación técnica sobre los
    medicamentos?  **
    Sí. Se explican las dosis y cómo tomar los medicamentos, pero de
    manera básica. Para dudas más complejas, se consulta al médico
    directamente.

### **E. Gestión Operativa**

1.  **¿Qué herramientas utiliza para la gestión integral del
    consultorio/farmacia?  **
    Principalmente herramientas manuales como cuadernos y registros en
    papel. No contamos con sistemas digitales.

2.  **¿Con qué frecuencia se realizan auditorías de procesos o
    inventarios?  **
    Cada mes se revisa el inventario y los procesos de atención, pero de
    forma informal.

3.  **¿Qué tan eficiente considera la comunicación entre las áreas
    (consultorio, farmacia)?  **
    Es buena, ya que el personal es reducido y trabaja en el mismo
    espacio, pero a veces hay confusión en los horarios o registros.

4.  **¿Qué tan accesibles son los reportes técnicos o financieros para
    la toma de decisiones?  **
    Los reportes financieros son básicos y se llevan en hojas de cálculo
    o manualmente, lo que dificulta un análisis detallado.

### **F. Identificación de Problemas y Mejoras**

1.  **¿Cuáles son los principales problemas técnicos que enfrenta
    actualmente en los procesos?**

    - Retrasos por registros manuales.

    - Riesgo de pérdida de información.

    - Dificultad para manejar un inventario exacto.

2.  **¿Qué tecnología o automatización adicional considera que mejoraría
    los procesos?**

    - Un sistema básico de gestión de citas e inventarios.

    - Digitalización del historial clínico y las recetas.

3.  **¿Hay capacitación continua para el personal en el uso de
    herramientas técnicas?  **
    No, porque actualmente no usamos tecnología avanzada. Sin embargo,
    sería útil capacitar al personal en el manejo de sistemas básicos si
    se implementaran.

4.  **¿Cómo evalúa la satisfacción del paciente respecto a los tiempos y
    calidad de los servicios?  **
    Los pacientes están generalmente satisfechos con el trato personal y
    la atención. Sin embargo, los tiempos de espera y la falta de
    medicamentos son las quejas más comunes.

## **1. Requerimientos funcionales**

- **Registro de pacientes:** El sistema debe permitir registrar
  información básica de los pacientes.

<!-- -->

- **Creación de citas:** El sistema debe permitir a los usuarios crear
  citas para los pacientes, especificando:

<!-- -->

- Fecha y hora de la cita.

<!-- -->

- Tipo de consulta.

<!-- -->

- Médico asignado.

<!-- -->

- Duración de la cita.

<!-- -->

- **Asignación de recursos:** El sistema debe determinar y asignar
  recursos a cada cita.

<!-- -->

- **Visualización de agenda:** El sistema debe mostrar una vista de la
  agenda de citas para los usuarios.

**Incluyendo:**

- Pacientes.

<!-- -->

- Fecha y hora de las citas.

<!-- -->

- Tipo de consulta.

<!-- -->

- Médico.

<!-- -->

- **Modificación y cancelación de citas:** El sistema debe permitir
  modificar o cancelar citas existentes.

<!-- -->

- **Notificaciones:** El sistema debe enviar notificaciones a los
  pacientes y médicos sobre:

> \+ Citas programadas,
>
> \+ Cambio sobre las citas.
>
> \+ Recordatorio de próximas citas.

## **2. Requerimientos no funcionales**

- **Seguridad:** El sistema debe cumplir con estándares de seguridad
  para proteger la información del paciente.

<!-- -->

- **Usabilidad:** El sistema debe de ser fácil de usar para el
  encargado.

<!-- -->

- **Escalabilidad:** El sistema debe poder manejar un aumento en el
  número de usuarios y citas.

<!-- -->

- **Recuperación:** El sistema debe crear copias de seguridad de todas
  las citas.

<!-- -->

- **Mantenibilidad actualizaciones o del sistema:** El sistema debe
  permitir agregar modificaciones sin afectar el resto del sistema.

## **3. Requerimientos de dominio**

> -El sistema debe permitir a cada paciente tener un único registro en
> el sistema basado en su información personal para evitar duplicados.
>
> -El sistema solo debe mostrar el registro del paciente con información
> mínima pero necesaria para la atención médica.
>
> -El sistema solo debe permitir agendar citas al médico dentro de su
> horario de trabajo. No puede tener más citas de las que su horario
> permite.
>
> -El sistema debe permitir el auto-rellenado de datos específicos en la
> agendación de citas.
>
> -El sistema solo debe permitir a la agenda mostrar las citas
> confirmadas y los cambios importantes a las mismas.

-El sistema debe mostrar las citas de forma jerárquica y visual según
fecha y hora.

## Condiciones de éxito

- **Documentación correcta:** los datos ingresados al sistema deben ser
  ingresados para su correcto almacenamiento.

<!-- -->

- **Simplicidad en la gestión:** la interfaz es intuitiva, permitiendo
  al médico o encargado registrar, modificar o cancelar citas
  rápidamente.

<!-- -->

- **Optimización de tiempo:** El sistema reduce el tiempo necesario
  ofreciendo autocompletado para datos recurrentes o plantillas para
  citas.
