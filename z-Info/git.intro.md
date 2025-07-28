# Git

## Estado de los archivos

- Untracked
- Tracked
  - Commited
  - Staged
  - Modified

## Zonas

- Repository
- Stage Area (Index)
- Work Area

### Instalación y configuración inicial

Disponible en la [web](https://git-scm.com/) para Windows, Mac y Linux.
En este momento (octubre 2024) la versión disponible es la 2.46.2.

En la instalación guiada pueden indicarse algunos elementos de configuración como:

- los complementos incluidos (iconos, integración con el entorno)
- el editor que utilizará Git (e.g. Visual Studio Code o VSC).
- el ajuste del path para permitir su uso en diversos terminales
- el transporte HTTPS, generalmente openSSH
- la codificación de los saltos de línea (CRLF o LF)
- las opciones de terminal (minTTY, cmd, powershell)
- la gestión de las credenciales (credential helper)
- la cache de ficheros y la posibilidad de incluir enlaces simbólicos (desactivada por defecto)

#### Terminales

Git es una herramienta de línea de comandos desarrollada inicialmente para el Bash de Linux. En Windows, Git se instala con un terminal propio que es una versión de MinTTY, un emulador de terminal para Windows que permite el uso de Bash, conocida como **GitBash**.

Sin embargo, Git puede utilizarse en cualquier terminal de Windows, como el **cmd** o el **PowerShell**. Para ello, es necesario ajustar el path de Windows para que el ejecutable de Git esté disponible en todas las terminales, lo que se puede hacer en la instalación de Git.

##### El comando less

git muestra la información usando el comande less, que permite desplazarse por la información mostrada. Los comandos básicos son

:f -> scroll next page
:b -> scroll previous page
:q -> quit

#### Configuración

Git se configura a tres niveles

- **Sistema**. Archivo /etc/gitconfig: Contiene valores para todos los usuarios del sistema y todos sus repositorios. Si pasas la opción `--system` a git config, lee y escribe específicamente en este archivo.
- **Global o usuario**. Archivo ~/.gitconfig: Específico a tu usuario. Puedes hacer que Git lea y escriba específicamente en este archivo pasando la opción `--global`.
- **Repositorio**. Archivo config "local", en el directorio de Git (es decir, .git/config) del repositorio que estés utilizando actualmente: Específico a ese repositorio.

Cada nivel sobrescribe los valores del nivel anterior, por lo que los valores de .git/config tienen preferencia sobre los de /etc/gitconfig

Para conocer la configuración actual de Git, se puede utilizar el comando

```shell
git config --list
git config --list --show-origin
```

que mostrará la configuración actual de Git y en el segundo caso, el archivo donde se ha definido.

Para ver solo la configuración global, se puede utilizar

```shell
git config --global -l
```

Para editar la configuración global, se puede utilizar el comando `git config --global` añadiendo la clave y el valor que se quiere añadir.

Los valores imprescindibles son

```shell
git config --global user.name "Alejandro Cerezo"
git config --global user.email "alce65@hotmeil.es"
```

Si no se define el name y el email, Git no permitirá hacer commits.

Otros valores que se pueden definir son

```shell
git config --global core.editor "code --wait --new-window"
git config --global init.defaultBranch main
git config --global core.autocrlf false
git config --global core.ignorecase true
```

Los dos primeros, probablemente estarán definidos a nivel system durante la instalación de Git.
El segundo es una opción que se ha añadido en la versión 2.28 de Git para cambiar el nombre de la rama principal de los repositorios de Git de master a main.

En caso de tener un repo cuya rama principal se llame master, se puede cambiar el nombre de la rama principal con el comando

```shell
git branch -m master main
```

El tercero y el cuarto son recomendables para evitar problemas con los saltos de línea en Windows y con la sensibilidad a mayúsculas y minúsculas.

### Referencias

- [Git Reference](https://git-scm.com/docs)
  Documentación oficial de Git.

- [Pro Git](https://git-scm.com/book/en/v2)
  Free book on Git. _Scott Chacon_ and _Ben Straub_. 2014.

- [Gitting Things Done – A Visual and Practical Guide to Git [Full Book]](https://www.freecodecamp.org/news/gitting-things-done-book/) _Omer Rosenbaum_. 2024

- [git - the simple guide](https://rogerdudler.github.io/git-guide/)
  Cheat sheet de git. _Roger Dudler_. 2013.

- [Think Like (a) Git](https://think-like-a-git.net/)
