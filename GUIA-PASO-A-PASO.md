# Guía paso a paso para continuar la Fase 1

Esta guía separa lo comprobado en los archivos de lo que aún debes completar en tus cuentas/equipo. La hoja que compartiste se titula “Fase 1” y menciona fecha de entrega 16 de octubre de 2026; esa fecha ya pasó.

## Estado verificado

- Las clases requeridas están en `src/gt/edu/umes/proy/calculo/`: `CalculaMinutos` y `LogicaDelNegocio`.
- La lógica valida que sean cinco enteros y calcula meses como 30 días. También maneja desbordamientos.
- Eclipse tiene el proyecto de Java, JDK 21 y Subclipse 4.3.4 instalados.
- La VM TurnKey Linux Jenkins 19.0 aparece registrada en VirtualBox. Sus recursos visibles cumplen: 1536 MB RAM, un procesador, disco de 8 GB y red en modo puente.
- Compilé las dos clases con Java 21 y ejecuté el ejemplo del PDF. Resultado: `Total en segundos: 4245600`.
- Git tiene rama `main` y commits locales, pero no hay ningún remoto `origin`; por eso el proyecto todavía no aparece publicado en GitHub desde este repositorio.
- La VM TurnKey arrancó el 23 de octubre de 2026 y su consola muestra `https://192.168.0.14`, además de Web Shell en `:12320` y Webmin en `:12321`.
- Se restableció la contraseña del usuario Linux `root` desde la consola de recuperación; TurnKey confirmó `password updated successfully`. La VM reinició y volvió a mostrar la consola azul. No se guardó la contraseña en estos archivos.
- La dirección `http://192.168.0.14:8080/login` que estaba abierta no respondió. Para TurnKey Jenkins 19, prueba la URL base que muestra la consola: `https://192.168.0.14/` (sin `:8080`).
- El login web de Jenkins es separado: TurnKey documenta el usuario `jenkins-admin` y no ofrece una contraseña predeterminada. La contraseña root cambiada no debe asumirse como contraseña de Jenkins.

## Qué abrir la próxima vez

1. Abre VirtualBox y selecciona **Jenkins TurnKey Linux 19.0**. La VM original está aquí:
   `C:\Users\rudya\Documents\Codex\2026-10-15\n\outputs\Turnkey-Jenkins-VM\Jenkins TurnKey Linux 19.0`
2. Inicia la VM desde el disco duro. Déjala terminar el arranque.
3. La consola azul de TurnKey ya muestra los accesos. En el estado actual, la URL web indicada es `https://192.168.0.14/`. Si la red de la computadora cambia, usa la dirección que aparezca en la consola.
4. Desde Windows abre `https://192.168.0.14/`. Si el navegador presenta una advertencia por el certificado autofirmado, comprueba que la dirección sea la IP local de tu VM y acepta la excepción tú mismo. No agregues `:8080`.
5. Para Jenkins prueba el usuario `jenkins-admin`. No hay contraseña predeterminada; TurnKey la establece durante la inicialización. Si no la recuerdas, la contraseña `root` de Linux no necesariamente sirve para Jenkins.
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

## Contraseñas: Jenkins y TurnKey

- **TurnKey/Linux (`root`):** permite administrar el sistema de la VM desde consola o SSH. El restablecimiento de esta sesión quedó confirmado tras usar la recuperación de VirtualBox. No repitas ese procedimiento salvo que vuelvas a perder acceso.
- **Jenkins (`jenkins-admin`):** cuenta separada para la aplicación web. TurnKey configura autenticación PAM y no publica una contraseña predeterminada; se define durante la inicialización.
- La contraseña inicial de desbloqueo de Jenkins solo aplica si todavía aparece la pantalla “Unlock Jenkins”. No sirve para restablecer un usuario ya configurado.

### Si no puedes iniciar sesión en Jenkins

Primero prueba la URL base `https://IP-DE-LA-VM/`, el usuario `jenkins-admin` y la contraseña definida al inicializar TurnKey. La documentación de TurnKey indica que Jenkins usa PAM. Cambiar `root` no cambia esa contraseña. No edites `config.xml` ni desactives la seguridad: ese procedimiento anterior no es apropiado para esta instalación PAM y podría dejar Jenkins expuesto.

Si sigue sin funcionar, confirma desde una sesión administrativa de la VM la cuenta PAM que existe y su estado antes de restablecerla. No uses `passwd jenkins-admin` sin verificar primero que esa cuenta exista y que Jenkins autentique por PAM en esta instalación. Si se necesita cambiar una credencial, hazlo en la consola local de la VM y nunca guardes la contraseña en el repositorio.

TurnKey 19 documenta la cuenta `jenkins-admin`, la autenticación PAM y la URL en la raíz del servidor. Consulta la guía oficial de TurnKey Jenkins antes de cualquier recuperación adicional.

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
- Abrí Eclipse con el proyecto y verifiqué el código (0 errores de Eclipse y una advertencia).
- Restablecí la contraseña Linux de `root` usando la consola de recuperación. La pantalla confirmó que se actualizó; luego reinicié la VM y comprobé que TurnKey volvió a la consola azul con su dirección web.

GitHub sigue pendiente: este checkout no tiene remoto y publicar requiere el repositorio destino y autenticación de tu cuenta. La contraseña de Jenkins también queda pendiente de confirmar porque no es la contraseña root y el navegador aún no llegó al login exitoso.
