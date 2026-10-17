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

## Nota de alcance

Este paquete contiene el código y una guía de trabajo. No instala Eclipse, no crea la VM, ni publica el repositorio en tu cuenta; esos pasos deben hacerse en tu equipo y en tus cuentas.
