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

Jenkins 2.568.2 se verificó activo antes del apagado de la PC: `http://192.168.0.20:8080/login` respondió `200`. Después del apagado y nuevo arranque, la VM no obtuvo una dirección IPv4 y Jenkins quedó inaccesible desde el host; la consola local espera inicio de sesión para revisar DHCP y reiniciar el servicio. No se guardan credenciales en este proyecto.


