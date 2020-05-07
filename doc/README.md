# Documentació de l'Scene Maker

Aci teniu la documentació d'anàlisi i disseny sobre l'Scene Maker, així com la documentació necessària per a la seua compilació i execució.

## Compilació i execucio

Per compilar l'aplicació, des de la carpeta de fonts, invocarem el compilador de java:

```
usuari@host:~/scene-maker/src$ javac com/ieseljust/edd/scenemaker/*.java
```

I per executar-la, invoquem la classe `Cli`:

```
usuari@host:~/scene-maker/src$ java com.ieseljust.edd.scenemaker.Cli
```

En el moment de l'execució, se'ns mostrarà una *shell interactiva* amb el prompt `# Figura: `.

Aquest prompt accepta les següents ordres:

```
rectangle x y width height color
```

Afig una rectangle a l'escena, sent:

* `x` i `y` dos enters amb les coordenades del rectangle,
* `width`i `height` dos enters amb les dimensions ample i alt del rectangle,
* `color` una cadena de text amb el nom del color (`roig`, `verd`, etc.)


```
dimensions x y
```

Estableix les dimensions de l'escena, sent `x` i `y` l'ample i alt de l'escena.

```
get fitxer
```

Descarrega una escena (fitxer) en el format adeqüat des d'un servidor remot.

```
remotelist
```

Mostra l'índex de figures del servidor remot.

```
list
```
                
Mostra la llista de figures de l'escena.

```
render
```

Obre una finestra amb la imatge de l'escena que hem creat.

Per a més informació podeu consultar el [diagrama de casos](casos_us.md) d'us en aquesta mateixa carpeta, aixó com el [diagrama de classes](diagrama_classes.md)