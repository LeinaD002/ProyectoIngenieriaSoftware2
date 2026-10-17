# Proyecto Ingeniería de Software 2 - Fase 1

## Programa

Aplicación Java de consola que convierte cinco cantidades (meses, semanas, días, horas y minutos) a segundos. Para el ejercicio, un mes se toma como 30 días, de acuerdo con el ejemplo de la guía.

## Estructura

- `src/gt/edu/umes/proy/calculo/CalculaMinutos.java`: método `main`, recibe argumentos y muestra el resultado.
- `src/gt/edu/umes/proy/calculo/LogicaDelNegocio.java`: valida los cinco argumentos y realiza la conversión.
- Paquete: `gt.edu.umes.proy.calculo`.

## Ejecución

En Eclipse ejecuta `CalculaMinutos` como Java Application y configura estos argumentos en **Run Configurations > Arguments > Program arguments**:

`1 2 5 3 20`

Salida esperada: `Total en segundos: 4245600`.

El programa requiere exactamente cinco valores enteros. Si la cantidad o el formato no es válido, informa el error y muestra el uso esperado.

## Estado del trabajo

- Eclipse IDE for Java Developers está instalado y el proyecto `ProyectoIngenieriaSoftware2` está importado en el workspace local. El ejemplo se ejecutó y produjo `Total en segundos: 4245600`.
- El repositorio Git local está inicializado y contiene los commits `db65987` (programa) y `4319d2a` (este estado).
- VirtualBox tiene registrada la VM `Jenkins TurnKey Linux 19.0` con 1536 MB de RAM, 1 CPU, disco virtual dinámico de 8 GB, red puenteada y el ISO oficial conectado. La ISO está en `../Turnkey-Jenkins-VM/turnkey-jenkins-19.0-trixie-amd64.iso`.
- La VM queda apagada: el equipo reportó aproximadamente 0.9 GB de RAM libre, menos de los 1.5 GB que necesita la máquina virtual. Al iniciar TurnKey, completa personalmente cualquier pantalla que solicite contraseñas.
- Subclipse 4.3.4 quedó instalado desde Eclipse Marketplace (con JavaHL, SVNKit y Revision Graph; Mylyn se omitió por incompatibilidad con el Eclipse instalado). Falta publicar en GitHub: no hay aún un repositorio remoto creado para este proyecto. Cuando exista, conecta con `git remote add origin <URL>` y publica con `git push -u origin main`.

