# Guía paso a paso para continuar la Fase 1

Esta guía separa lo comprobado en los archivos de lo que aún debes completar en tus cuentas/equipo. La hoja que compartiste se titula “Fase 1” y menciona fecha de entrega 16 de octubre de 2026; esa fecha ya pasó.

## Estado verificado

- Las clases requeridas están en `src/gt/edu/umes/proy/calculo/`: `CalculaMinutos` y `LogicaDelNegocio`.
- La lógica valida que sean cinco enteros y calcula meses como 30 días. También maneja desbordamientos.
- Eclipse tiene el proyecto de Java, JDK 21 y Subclipse 4.3.4 instalados.
- La VM TurnKey Linux Jenkins 19.0 aparece registrada en VirtualBox. Sus recursos visibles cumplen: 1536 MB RAM, un procesador, disco de 8 GB y red en modo puente.
- Compilé las dos clases con Java 21 y ejecuté el ejemplo del PDF. Resultado: `Total en segundos: 4245600`.
- Git tiene rama `main` y commits locales, pero no hay ningún remoto `origin`; por eso el proyecto todavía no aparece publicado en GitHub desde este repositorio.
- La VM está apagada. El registro anterior dice que tras reiniciar Windows no obtuvo IP y Jenkins no quedó accesible.

## Qué abrir la próxima vez

1. Abre VirtualBox y selecciona **Jenkins TurnKey Linux 19.0**. La VM original está aquí:
   `C:\Users\rudya\Documents\Codex\2026-10-15\n\outputs\Turnkey-Jenkins-VM\Jenkins TurnKey Linux 19.0`
2. Inicia la VM desde el disco duro. Déjala terminar el arranque.
3. Si la consola inicia sesión, el usuario del sistema es `root`; esta es la contraseña del servidor TurnKey que se estableció durante el primer arranque. No es necesariamente la contraseña de Jenkins.
4. En la consola de TurnKey revisa la IPv4 con:
   `ip -4 addr`
   Busca la dirección asignada a la interfaz Ethernet, normalmente algo como `192.168.x.x`. Si no aparece dirección, revisa en VirtualBox: **Configuración > Red > Adaptador 1**, marca **Habilitar adaptador de red**, selecciona **Adaptador puente** y el adaptador físico que esté conectado a Internet. Guarda y reinicia la VM.
5. Desde Windows abre en el navegador `http://DIRECCION-IP:8080/login`, sustituyendo `DIRECCION-IP` por la IP que mostró la VM. Si no carga, vuelve a la consola y ejecuta `systemctl status jenkins --no-pager` para comprobar el servicio.
6. Abre Eclipse desde la carpeta de recuperación:
   `C:\Users\rudya\Documents\Codex\2026-10-15\n\work\Eclipse-recovery\eclipse\eclipse.exe`
7. Cuando Eclipse pregunte por el workspace, selecciona la carpeta del workspace que ya usabas. Para importar este proyecto: **File > Import > General > Existing Projects into Workspace**, y selecciona la carpeta donde está el proyecto descargado/clonado. El proyecto de esta entrega está en `outputs\Proyecto-Ingenieria-Software-2-Fase-1` de esta sesión.
8. Para correrlo en Eclipse: abre `CalculaMinutos.java`, clic derecho > **Run As > Java Application**. En **Run Configurations > Arguments** escribe `1 2 5 3 20`.

## Publicar el proyecto en tu GitHub

El repo local ya tiene commits. Primero crea en GitHub un repositorio nuevo y vacío para esta tarea, sin agregarle README ni archivos iniciales. Copia la dirección HTTPS del repositorio y sustituye `TU-USUARIO` y `TU-REPO` en estos comandos:

```powershell
cd "C:\Users\rudya\Documents\Codex\2026-10-23\necesito\outputs\Proyecto-Ingenieria-Software-2-Fase-1"
git remote add origin https://github.com/TU-USUARIO/TU-REPO.git
git push -u origin main
```

Completa la autenticación que Git solicite en el navegador o con Git Credential Manager. No pegues aquí tu contraseña ni un token. Confirma en GitHub que aparezcan `src`, `README.md` y los commits. Para guardar cambios posteriores:

```powershell
git add .
git commit -m "Describe el cambio"
git push
```

Si Git dice que `origin` ya existe, revisa `git remote -v` y actualiza con `git remote set-url origin https://github.com/TU-USUARIO/TU-REPO.git`.

## Contraseñas: Jenkins y TurnKey son accesos distintos

- **Contraseña del sitio web Jenkins:** protege la página `:8080`.
- **Contraseña de TurnKey/Linux (`root`):** permite administrar la VM desde su consola o SSH. Se necesita para los pasos de recuperación siguientes.
- La contraseña inicial de desbloqueo de Jenkins solo aplica si todavía aparece la pantalla “Unlock Jenkins”. No sirve para restablecer un usuario ya configurado.

### Si recuerdas la contraseña root de TurnKey pero olvidaste la de Jenkins

Sigue el procedimiento oficial de Jenkins para restablecer la contraseña del administrador. La edición de configuración desactiva temporalmente el control de acceso, así que hazlo solo desde la consola de VirtualBox y, antes de iniciar Jenkins sin autenticación, desconecta temporalmente el adaptador puente en **Configuración > Red** para no exponer el servicio a la red.

En la consola de TurnKey inicia sesión como `root`, luego ejecuta:

```bash
systemctl stop jenkins
cp /var/lib/jenkins/config.xml /var/lib/jenkins/config.xml.respaldo
nano /var/lib/jenkins/config.xml
```

Busca `<useSecurity>true</useSecurity>` y cámbialo por `<useSecurity>false</useSecurity>`. Guarda en nano con `Ctrl+O`, `Enter`, `Ctrl+X`. Luego:

```bash
systemctl start jenkins
```

Vuelve a conectar la red, averigua la IP con `ip -4 addr` y entra a `http://DIRECCION-IP:8080`. Sin dejar pasar tiempo, en Jenkins abre **Manage Jenkins > Security**. Selecciona la base de usuarios interna de Jenkins, confirma que el registro público de usuarios esté desmarcado y guarda. Entra al usuario administrador desde **Users**, abre **Configure**, cambia la contraseña y guarda. Finalmente confirma en **Security** que la autorización sea para usuarios autenticados, que el acceso anónimo esté desactivado y que la seguridad esté habilitada. Cierra sesión y vuelve a iniciar con la nueva contraseña para confirmar.

Si el archivo no contiene exactamente `<useSecurity>true</useSecurity>` o `/var/lib/jenkins/config.xml` no existe, no improvises sobre otro archivo: revisa el estado/ubicación de Jenkins y consulta su directorio `JENKINS_HOME`. Puedes restaurar el respaldo con el servicio detenido si necesitas deshacer el cambio.

### Si olvidaste también la contraseña root de TurnKey

La recuperación requiere acceso de consola y depende de cómo esté instalado el disco. No es la misma contraseña que la de Jenkins. No reinstales la VM ni formatees el disco: ahí está la configuración de Jenkins. Conserva el disco y busca el procedimiento de recuperación de contraseña root para Debian/TurnKey con acceso al arranque de VirtualBox; verifica con cuidado el usuario y el dispositivo raíz antes de escribir cualquier cambio. Si no puedes confirmar que tienes un respaldo de la VM, crea primero una copia del archivo `Jenkins-TurnKey-19.vdi` con la VM apagada.

## Comprobación para demostrar el programa

Desde la consola de Windows, dentro de la carpeta del proyecto, puedes comprobar la salida así:

```powershell
java -cp bin gt.edu.umes.proy.calculo.CalculaMinutos 1 2 5 3 20
```

Debe imprimir `Total en segundos: 4245600`. Para demostrar la validación, prueba una cantidad incorrecta de argumentos o un texto que no sea entero: debe mostrar un mensaje de error y las instrucciones de uso.

## Qué hice en esta revisión

- Comparé los requisitos del PDF con las clases, configuración del proyecto, commits, instalación encontrada de Eclipse/Subclipse y la VM registrada.
- Copié el proyecto local con su historial Git a la carpeta de resultados de esta sesión.
- Actualicé el README del proyecto con el estado comprobado y preparé esta guía para que puedas retomarlo en tu computadora.
- Compilé y ejecuté el ejemplo esperado.

No asocié GitHub porque no hay una dirección de repositorio ni una sesión de GitHub confirmada en este checkout. No cambié contraseñas porque la VM está apagada y no se encontró una sesión root abierta; no guardaré credenciales en archivos.
