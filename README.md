# Automatización de Pruebas - Examen Final

## Descripción del Proyecto

Este proyecto implementa una calculadora básica en Java con el objetivo de demostrar diferentes estrategias de automatización de pruebas, incluyendo pruebas unitarias, de integración y de interfaz de usuario.

## Características

- **Calculadora básica** con operaciones matemáticas fundamentales
- **Pruebas unitarias** implementadas con JUnit 5
- **Pruebas de integración** implementadas con TestNG
- **Configuración Maven** con todas las dependencias necesarias
- **Pipeline de CI/CD** configurado para automatización

## Operaciones Disponibles

- Suma
- Resta
- Multiplicación
- División
- Potencia
- Raíz cuadrada

## Tecnologías Utilizadas

- **Java 11**
- **Maven 3.6+**
- **JUnit 5** - Pruebas unitarias
- **TestNG** - Pruebas de integración
- **Selenium** - Pruebas de interfaz
- **Git** - Control de versiones

## Estructura del Proyecto

```
src/
├── main/java/com/examen/calculadora/
│   └── Calculator.java
└── test/java/com/examen/calculadora/
    ├── CalculatorTest.java
    └── CalculatorIntegrationTest.java
```

## Cómo Ejecutar las Pruebas

### Prerequisitos
- Java 11 o superior
- Maven 3.6 o superior

### Comandos

```bash
# Compilar el proyecto
mvn compile

# Ejecutar todas las pruebas
mvn test

# Ejecutar solo pruebas unitarias (JUnit)
mvn test -Dtest=CalculatorTest

# Ejecutar solo pruebas de integración (TestNG)
mvn test -Dtest=CalculatorIntegrationTest

# Generar reportes de pruebas
mvn surefire-report:report
```

## Estrategia de Pruebas

### Pruebas Unitarias (JUnit 5)
- Verifican el comportamiento individual de cada método
- Cubren casos normales y casos límite
- Validan el manejo de excepciones

### Pruebas de Integración (TestNG)
- Verifican el comportamiento del sistema completo
- Prueban flujos de trabajo complejos
- Validan la integración entre componentes

## Autor

[Tu Nombre] - Examen Final de Automatización de Pruebas
