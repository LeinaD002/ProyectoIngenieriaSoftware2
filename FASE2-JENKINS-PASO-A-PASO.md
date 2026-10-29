# Fase 2: configurar el trabajo Maven en Jenkins

Esta guia corresponde a la VM TurnKey Jenkins del proyecto y al repositorio publico:

https://github.com/LeinaD002/ProyectoIngenieriaSoftware2

## 1. Preparar Eclipse

1. Abre el proyecto ProyectoIngenieriaSoftware2 en Eclipse.
2. Si Eclipse no reconoce Maven automaticamente, haz clic derecho sobre el proyecto y selecciona Maven > Update Project... Marca el proyecto y pulsa OK.
3. Espera que Maven descargue JUnit 6.1.3 y que Eclipse termine el build.
4. Abre src/test/java > gt.edu.umes.proy.calculo > CalculoSegundosTest.java.
5. Haz clic derecho sobre la clase y selecciona Run As > JUnit Test. Deben aparecer 2 tests, 0 failures y 0 errors.

## 2. Comprobar plugins y Maven en Jenkins

1. Inicia la VM Jenkins y abre la URL que muestra su consola.
2. Inicia sesion como admin.
3. Abre Manage Jenkins > Plugins > Installed plugins y busca Maven Integration. Si falta, instalalo desde Available plugins junto con sus dependencias.
4. En Manage Jenkins > Tools, busca Maven installations y agrega una instalacion con nombre exacto Maven-3.10.0.
5. Marca Install automatically, selecciona Install from Apache y elige la version 3.10.0. Guarda.

No actualices la version principal de Jenkins. Si Jenkins muestra actualizaciones de plugins pendientes, revisa la lista y aplica solo las que pueda soportar la version del controlador; reinicia Jenkins cuando el administrador de plugins lo solicite.

## 3. Crear el trabajo Freestyle

1. En Jenkins, pulsa New Item.
2. Escribe ProyectoIngenieriaSoftware2, selecciona Freestyle project y pulsa OK.
3. En Source Code Management, selecciona Git.
4. En Repository URL, pega:

   https://github.com/LeinaD002/ProyectoIngenieriaSoftware2.git

5. En Branch Specifier, escribe */main.
6. El repositorio es publico: deja Credentials en - none - para permitir el checkout de lectura sin guardar un token. Si el repositorio se vuelve privado, crea una credencial de tipo username/password usando un token de GitHub; nunca guardes el token en el codigo ni en el repositorio.

## 4. Compilar, ejecutar las pruebas y publicar el reporte

1. En Build Steps, agrega Invoke top-level Maven targets.
2. En Maven Version, elige Maven-3.10.0; en Goals, escribe compile.
3. Agrega un segundo paso Invoke top-level Maven targets con la misma instalacion de Maven. En Goals, escribe clean test.
4. En Post-build Actions, agrega Publish JUnit test result report.
5. En Test report XMLs, escribe target/surefire-reports/*.xml.
6. Guarda el trabajo y pulsa Build Now.

## 5. Verificar el resultado

1. Abre el numero del build mas reciente y selecciona Console Output. Debe terminar con BUILD SUCCESS.
2. La fila del build debe mostrar el indicador verde.
3. En el resumen del build, abre Test Result y confirma 2 tests, 0 failures y 0 errors.
4. Abre Workspace y confirma que aparezcan pom.xml, src/main/java y src/test/java.

Cada vez que subas cambios desde Eclipse, el repositorio ya esta conectado. Jenkins puede ejecutar el trabajo con Build Now; para dispararlo automaticamente despues de un push se necesita configurar adicionalmente un webhook o polling de SCM.
