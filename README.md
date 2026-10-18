# Ingeniería de Software 2 — Fase 1

## Aplicación Java

Aplicación de consola que recibe cinco enteros en este orden: meses, semanas, días, horas y minutos. Convierte el tiempo a segundos; cada mes se considera de 30 días, como en el ejemplo de la guía.

Paquete: `gt.edu.umes.proy.calculo`

- `CalculaMinutos`: punto de entrada, procesa los argumentos y muestra el total.
- `LogicaDelNegocio`: valida cantidad y formato, y calcula el total usando operaciones que detectan desbordamiento.

Ejemplo:

```text
java gt.edu.umes.proy.calculo.CalculaMinutos 1 2 5 3 20
Total en segundos: 4245600
```

El proyecto Eclipse usa JDK 21 y está importado en el workspace local.

## Entorno solicitado

- Eclipse IDE for Java Developers está instalado.
- Subclipse 4.3.4 y el adaptador JavaHL 1.14 para Windows x64 están instalados desde el paquete oficial y descubiertos desde `dropins` de Eclipse.
- La VM `Jenkins TurnKey Linux 19.0` está instalada en VirtualBox: 1 CPU, 1536 MB de RAM, disco de 8 GB, red puenteada y arranque desde disco. ISO oficial conectada como segundo dispositivo de arranque.
- La VM arranca y muestra `192.168.0.20`. TurnKey informa los servicios web, Webmin y SSH.

## Estado de publicación y Jenkins

El repositorio Git local está en la rama `main`. Aún no tiene remoto GitHub, por lo que falta publicarlo en la cuenta del estudiante.

La VM arranca y Jenkins quedó activo tras reiniciar el servicio desde la consola local. Verificado desde el host: `http://192.168.0.20:8080/login` responde `200` y Jetty anuncia Jenkins 2.568.2. HTTPS ya alcanza Jenkins; su página principal responde `403` a visitantes anónimos, como corresponde a las reglas de permisos. No se guardan credenciales en este proyecto.

