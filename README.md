# Ingeniería de Software 2 — Fase 1

## Aplicación Java

Aplicación de consola que recibe cinco enteros en este orden: meses, semanas, días, horas y minutos. Convierte el tiempo a segundos; cada mes se considera de 30 días, como en el ejemplo de la guía.

Paquete: `gt.edu.umes.proy.calculo`

- `CalculaMinutos`: punto de entrada.
- `LogicaDelNegocio`: validación y cálculo con detección de desbordamiento.

Ejemplo:

```text
java gt.edu.umes.proy.calculo.CalculaMinutos 1 2 5 3 20
Total en segundos: 4245600
```

## Verificación de esta sesión

- Proyecto Eclipse Java con JDK 21 y estructura de paquetes solicitada.
- Eclipse tiene Subclipse 4.3.4 y sus adaptadores instalados en `dropins`.
- La VM TurnKey Jenkins 19.0 está registrada en VirtualBox con 1536 MB de RAM, 1 CPU, disco virtual de 8 GB y adaptador puente.
- Compilación y ejecución del ejemplo confirmadas el 23 de octubre de 2026.
- El repositorio local `main` contiene commits, pero no tiene remoto GitHub configurado. La publicación requiere crear/seleccionar el repositorio en tu cuenta e iniciar sesión.
- La VM está apagada. El último registro encontrado indica que al reiniciar el host no obtuvo IPv4 y que Jenkins dejó de ser accesible. Confirma el arranque y la red antes de dar esta parte por terminada.

Consulta `GUIA-PASO-A-PASO.md` para continuar, publicar el repositorio y recuperar el acceso a Jenkins.
