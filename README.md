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

- Eclipse IDE for Java Developers está instalado y el proyecto `ProyectoIngenieriaSoftware2` está importado en el workspace local. El ejemplo se compiló y ejecutó nuevamente; produjo `Total en segundos: 4245600`.
- El repositorio Git local está inicializado y contiene los commits `db65987` (programa) y `4319d2a` (este estado).
- VirtualBox tiene registrada la VM `Jenkins TurnKey Linux 19.0` con 1536 MB de RAM, 1 CPU, disco virtual dinámico de 8 GB, red puenteada, controlador gráfico VMSVGA con 32 MB y el ISO oficial conectado. La ISO está en `../Turnkey-Jenkins-VM/turnkey-jenkins-19.0-trixie-amd64.iso`.
- TurnKey Linux 19.0 quedó instalado y arranca desde el disco virtual. La contraseña de root quedó configurada directamente por el usuario en la consola de VirtualBox. La VM está corriendo; el resumen de TurnKey mostró la dirección `192.168.0.20` y los servicios web, Web Shell, Webmin y SSH. Falta confirmar el acceso web a Jenkins desde el host.
- Se descargó el paquete oficial Subclipse 4.3.4 y sus complementos se dejaron en `eclipse/dropins/Subclipse/eclipse` para que Eclipse los descubra al iniciar. El intento de registrarlos con p2 falló por un error de estado del perfil (`ProfileNotCurrentException`); falta iniciar Eclipse y verificar que el complemento cargue y que haya un cliente SVN disponible.
- El repositorio Git local está listo en la rama `main`, pero aún no tiene remoto. Publicación pendiente: crear un repositorio para este proyecto en GitHub y ejecutar `git push -u origin main`.


