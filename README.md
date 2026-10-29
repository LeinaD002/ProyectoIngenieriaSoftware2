# Proyecto de Ingenieria de Software 2 - Fase 2

Aplicacion Java que convierte meses, semanas, dias, horas y minutos a segundos. Para este ejercicio, un mes equivale a 30 dias.

## Requisitos

- JDK 17 o superior (el proyecto se compila para Java 17)
- Apache Maven 3.10.0

## Compilar y ejecutar pruebas

Desde la carpeta que contiene pom.xml, ejecuta mvn compile y luego mvn clean test.

El reporte XML de JUnit se genera en target/surefire-reports/.

## Ejecutar la aplicacion

Ejecuta mvn compile y luego java -cp target/classes gt.edu.umes.proy.calculo.CalculaMinutos 1 2 5 3 20.
El resultado esperado es Total en segundos: 4245600.

## Pruebas automatizadas

CalculoSegundosTest valida que un argumento con letras genere IllegalArgumentException y que los valores 1 3 6 20 1 produzcan 4996860 segundos.

## Jenkins - trabajo Freestyle de Fase 2

- SCM: Git
- Repository URL: https://github.com/LeinaD002/ProyectoIngenieriaSoftware2.git
- Branch: */main
- Maven installation: Maven-3.10.0
- Build goals: compile, luego clean test
- JUnit report pattern: target/surefire-reports/*.xml

La cuenta del repositorio es publica, asi que el checkout de lectura no requiere incluir un token en el proyecto ni en el repositorio.
