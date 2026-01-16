# 🤖Framework de Automatización con Selenium y Java.

## 📖 Descripción

Este proyecto consiste en la automatización de pruebas funcionales para la página [DemoQA](https://demoqa.com/), está construido con **Java** y utiliza **Selenium WebDriver** para la automatización de navegadores, **TestNG** como framework de testing y **Extent Reports** para la generación de reportes profesionales, con el objetivo de validar el correcto funcionamiento de los principales componentes y formularios de la aplicación web.

La automatización fue desarrollada siguiendo buenas prácticas de testing, aplicando el patrón de diseño Page Object Model (POM) para mejorar la mantenibilidad, reutilización y escalabilidad del código.

## 🎯 Alcance de la Automatización

Se han automatizado 60 casos de prueba que validan las funcionalidades clave del aplicación. La cobertura incluye:

- Elementos y formularios básicos (TextBox, RadioButtons, CheckBox).
- Widgets interactivos (Tabs, ToolTips, DatePicker, Accordion).
- Manejo de alerts, ventanas y frames.
- Tablas dinámicas y CRUD en WebTables.
- Subida y descarga de archivos.
- Links, navegación y comprobación de enlaces rotos.
- Propiedades dinámicas (visibilidad, enable/disable).
- Validaciones de formularios y flujos de navegación.

## 🧠 Habilidades y Conocimientos Adquiridos

### 1. **Automatización Web con Selenium**
- Localización avanzada de elementos (XPath, CSS Selectors, IDs).
- Manejo de waits: implícitas y explícitas.
- Interacción con elementos complejos.
- Manejo de ventanas, pestañas y frames múltiples.
- Gestión de alerts y popups.

### 2. **Arquitectura y Patrones de Testing**
- **Page Object Model (POM)**: Separación de lógica de test y localización de elementos.
- **BasePage Pattern**: Métodos reutilizables para acciones comunes.
- **Factory Pattern**: Gestión de drivers e instancias.
- **BaseTest**: Controla el setup y teardown de la ejecución.

### 3. **Framework de Testing - TestNG**
- Organización de tests con @Test, @BeforeMethod, @AfterMethod.
- Parametrización de tests.
- Grupos de tests.
- Suite XML para ejecución ordenada.

### 4. **Generación de Reportes**
- Extent Reports para reportes HTML profesionales.
- Capturas de pantalla en fallos.
- Logs detallados de ejecución.
- Métricas y estadísticas de tests.

### 5. **Herramientas y Build**
- Maven como gestor de dependencias y build tool.
- POM.xml para configuración de proyecto.
- Compilación y ejecución de tests.
- Gestión de versiones de librerías.

### 6. **Manejo de Datos**
- Lectura de archivos Excel (.xlsx) con Apache POI.
- Validación de respuestas HTTP.

### 7. **Mejores practicas implementadas**
- Código limpio y bien documentado.
- Manejo robusto de errores.
- Configuración centralizada.
- Nomenclatura consistente de variables.
- Reutilización máxima de código.


## 📁 Estructura del Proyecto

```
DemoQA/
├── src/
│   └── test/
│       └── java/
│           ├── Pages/
│           │   ├── BasePage.java                    # Clase base con métodos comunes
│           │   ...
│           │
│           ├── Tests/
│           │   ├── BaseTest.java                    # Clase base para tests
│           │   ...                         
│           │
│           └── Utilities/
│               ├── DriverFactory.java               # Factory para crear/cerrar drivers
│               ├── ExtentManager.java               # Gestión de reportes
│               └── ReadExcel.java                   # Lectura de archivos Excel
│
├── test-output/                                     # Reportes de TestNG 
│   └── emailable-report.html
│
├── extent-reports/                                  # Reportes Extent Reports
│   └── ExtentReport_*.html
│
├── screenshots/                                     # Capturas en caso de fallos
│   └── test_screenshot_*.png
│
├── data/                                            # Datos de prueba (Excel, archivos)
│   └── test-data.xlsx
│
├── pom.xml                                          # Configuración Maven
├── base.xml                                         # Suite de tests básica
├── regressionTesting.xml                            # Suite de tests de regresión
└── testngCrossBrowsing.xml                          # Suite para testing multi-navegador

```


## 🛠️ Tecnologías Utilizadas

### Core Testing Framework
| Tecnología | Versión | Propósito |
|------------|---------|----------|
| **Java** | 17 | Lenguaje principal |
| **Selenium WebDriver** | 4.39.0 | Automatización de navegadores |
| **TestNG** | 7.11.0 | Framework de testing |
| **Maven** | 3.6.0+ | Build tool y gestor de dependencias |


### Reporting & Logging
| Tecnología | Versión | Propósito |
|------------|---------|----------|
| **Extent Reports** | 5.1.2 | Reportes HTML profesionales |

### Data & File Handling
| Tecnología | Versión | Propósito |
|------------|---------|----------|
| **Apache POI OOXML** | 5.4.1 | Lectura de archivos Excel |
| **Commons IO** | 2.20.0 | Utilidades de I/O |

---

📌 Autor: Rebeca C. Santiago

💬 Proyecto con fines de práctica en automatización de pruebas en aplicaciones web.