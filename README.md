# Proyecto Ingeniería de Software 2 - Fase 1

## Programa

Aplicación Java de consola que convierte cinco cantidades (meses, semanas, días, horas y minutos) a segundos. Para el ejercicio, un mes se toma como 30 días, de acuerdo con el ejemplo de la guía.

## Estructura

- `src/gt/edu/umes/proy/calculo/CalculaMinutos.java`: método `main`, recibe argumentos y muestra el resultado.
- `src/gt/edu/umes/proy/calculo/LogicaDelNegocio.java`: valida los cinco argumentos y realiza la conversión.
- El paquete de ambas clases es `gt.edu.umes.proy.calculo`.

## Ejecución

Desde Eclipse, ejecuta `CalculaMinutos` como Java Application y configura estos argumentos en **Run Configurations > Arguments > Program arguments**:

`1 2 5 3 20`

Salida esperada:

`Total en segundos: 4245600`

En terminal, después de compilar y desde la carpeta que contiene el directorio `gt`:

`java gt.edu.umes.proy.calculo.CalculaMinutos 1 2 5 3 20`

El programa requiere exactamente cinco valores enteros. Si la cantidad o el formato no es válido, informa el error y muestra el uso esperado.

## Pasos de entrega de Fase 1 según la guía

1. Instala Eclipse para Java Standard y agrega **Subclipse** desde Eclipse Marketplace.
2. Crea una cuenta o usa tu cuenta de GitHub.
3. Crea un proyecto Java en Eclipse llamado, por ejemplo, `ProyectoIngenieriaSoftware2`.
4. Copia las dos clases de `src/` en el mismo paquete `gt.edu.umes.proy.calculo`.
5. Ejecuta el ejemplo y verifica que Eclipse muestre `Total en segundos: 4245600`.
6. Crea un repositorio GitHub y publica el proyecto. La guía asignada indica seguir el video del PDF: https://www.youtube.com/watch?v=QvwDbf3kalw
7. Descarga el ISO **TurnKey Linux Jenkins 19.0** desde https://www.turnkeylinux.org/jenkins. Crea una VM con al menos 1.5 GB RAM, 8 GB de disco, una tarjeta de red y un procesador virtual; conecta el ISO como CDROM y arranca la instalación. La guía recomienda red en modo Bridge.
8. Para la presentación individual, ten Eclipse abierto con el programa y la VM encendida. Prepárate para explicar la instalación, mostrar el repositorio y hacer un cambio pequeño en el código y subirlo a GitHub.

## Estado del trabajo\n\n- Eclipse IDE for Java Developers está instalado y el proyecto `ProyectoIngenieriaSoftware2` está importado en el workspace local. El ejemplo se ejecutó y produjo `Total en segundos: 4245600`.\n- El repositorio Git local está inicializado y contiene el commit `db65987` (`Crear proyecto de conversion a segundos para Fase 1`).\n- VirtualBox tiene registrada la VM `Jenkins TurnKey Linux 19.0` con 1536 MB de RAM, 1 CPU, disco virtual dinámico de 8 GB, red puenteada y el ISO oficial conectado. La ISO está en `../Turnkey-Jenkins-VM/turnkey-jenkins-19.0-trixie-amd64.iso`.\n- La VM queda apagada: el equipo reportó aproximadamente 0.9 GB de RAM libre, menos de los 1.5 GB que necesita la máquina virtual. Al iniciar TurnKey, completa personalmente cualquier pantalla que solicite contraseñas.\n- Subclipse y la publicación en GitHub quedan pendientes. No hay aún un repositorio remoto creado para este proyecto; la cuenta debe crear un repositorio nuevo y luego conectar esta carpeta con `git remote add origin <URL>` y `git push -u origin main`.\n
