# Sistema de gestion de solicitudes (JavaFX)

Aplicación de escritorio desarrollada para la asignatura **Programación de Aplicaciones de Escritorio** (Semana 6). El sistema permite gestionar y registrar solicitudes mediante mutiples fomrularios de navegacion
[![Repo GitHub](https://img.shields.io/badge/GitHub-AplicacionRegistro-blue?style=flat&logo=github)](https://github.com/Jesy05/AplicacionRegistro)
[![JavaFX](https://img.shields.io/badge/JavaFX-17%2B-orange?style=flat&logo=java)](https://openjfx.io/)
[![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-purple?style=flat&logo=intellijidea)](https://www.jetbrains.com/idea/)

---

## Integrantes del Equipo

| Nombre Integrante | Rol / Función Desarrollada |
| :--- | :--- |
| **[Jose Cristo Carvallo ]** |  |
| **[Gabriela Ezpinoza]** | |
| **[ Fabiola Lanuza ]** |  |
| **[Jesy Gonzales]** |  |

---

##  Requisitos del Sistema y Tecnologías

* **Lenguaje:** Java 17 o superior.
* **Framework GUI:** JavaFX.
* **Diseñador Visual:** Scene Builder.
* **Entorno de Desarrollo:** IntelliJ IDEA.
* **Gestor de Dependencias:** Maven.

---

##  Estructura del Proyecto

```text
Corte 1 [ExamenC1PAA]/
├── .mvn/wrapper/                # Archivos del envoltorio de Maven (Maven Wrapper)
├── src/
│   ├── main/
│   │   ├── java/ni/edu/uam/examenc1paa/
│   │   │   ├── HelloApplication.java            # Clase de prueba/ejemplo inicial JavaFX
│   │   │   ├── HelloController.java             # Controlador para la vista inicial
│   │   │   ├── Launcher.java                    # Clase principal para iniciar la aplicación
│   │   │   ├── RegistroSolicitudController.java # Controlador para la vista de registro de solicitudes
│   │   │   └── Solicitud.java                   # Modelo de datos para las solicitudes
│   │   │   └── module-info.java                 # Configuración de módulos de Java
│   │   └── resources/ni/edu/uam/examenc1paa/
│   │       └── hello-view.fxml                  # Vista FXML para la interfaz gráfica
├── .gitignore                   # Archivos/carpetas ignorados por Git
├── mvnw / mvnw.cmd              # Ejecutables de Maven Wrapper
├── pom.xml                      # Archivo de configuración de dependencias de Maven
└── README.md                    # Documentación del proyecto



