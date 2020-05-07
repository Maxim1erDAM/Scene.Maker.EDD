# Pràctica: Ampliant la funcionalitat de l'eina SceneMaker

La part pràctica consistirà en ampliar la funcionalitat de l'eina SceneMaker, de manera que puguem afegir altres figures a les escenes, tals com quadrats, cercles, el·lipses, línies, etc.

Aquesta ampliació de la funcionalitat passarà per totes les fases del cicle de desenvolupament. És a dir, haurem d'especificar primerament els requeriments amb la corresponent ampliació del diagrama de casos d'ús, i posteriorment el diagrama de classes, per finalitzar amb la corresponent implementació.

Concretant una miqueta més, els passos que haurem de seguir seran:

1. Clona el repositori de l'aplicació al teu compte de Github. Treballareu sobre aquesta clonació.

Els nous requeriments que se'ns demanen seran:

* **Possibilita d'afegir quadrats**, en una posició donada, i del costat i color indicat. La sintaxi serà la següent:

```
quadrat x1 y1 costat color
```

Per exemple:

```
# Figura: quadrat 100 100 150 verd
```

Dibuixarà un quadrat verd en la posició (100,100), i de costat 150.

* **Possibilita d'afegir El·lipses**, en una posició donada, i radis en x i y, aixó com el color concrets. La sintaxi serà:

```
ellipse x y radi_X radi_Y color
```

Per exemple:

```
# Figura: ellipse 100 150 50 70 negre
```

Dibuixarà una el·lipse centrada en la posició (100,150), i de radis 50 i 70.


* **Possibilita d'afegir Cercles**, en una posició donada, i de radi i colors concrets. La sintaxi serà:

```
cercle x y radi color
```

Per exemple:

```
# Figura: cercle 100 150 50 blau
```

Dibuixarà un cercle blau centrat en la posició (100,150), i de radi 50.


* **Possibilita d'afegir Línies**, entre dos punts donats. La sintaxi serà:

```
linia x1 y1 x2 y2
```

Per exemple:

```
# Figura: linia 100 150 150 170 negre
```

Dibuixarà una línia entre la posició (100, 150) i la (150, 170).

2. Incorpora els diferents casos d'ús al **diagrama de casos d'ús** proporcionat, i realitza la descripció d'aquestos.

3. Amplia el **diagrama de classes** per tal que aquest dóne suport als nous casos d'ús.

4. Una vegada validats els diagrames de casos d'ús i de classes, realitza la seua implementació en Java, documentant i optimitzant el codi.

## Consideracions sobre els gràfics

Cal tindre en compte algunes idees sobre com treballa la llibreria `java.awt.Graphics`. En aquest apartat, veurem alguns detall sobre ella.

Podem trobar tota la documentació sobre l'API d'aquesta llibrería gràfica a (https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html)[https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html].


### El sistema de coordenades

Sobre el **sistema de coordenades**, quan indiqueu una posició en l'àrea de dibuix, heu de tindre en compte que **la posició (0,0) es correspon al cantó superior esquerre de la imatge**. Tenint en compte açò, valors de posició positius suposaran un desplaçament cap avall i cap a la dreta.

Gràficament podem representar aquest sistema de la següent manera:

!(Sistema de coordenades)[http://underpop.online.fr/j/java/img/04fig18.jpg]

### Algunes primitives

A l'API de `Graphics` teniu la descripció de tots els mètodes d'aquesta classe pe dibuixar figures. Veiem breument les que més necessitareu, junt amb algunes expliciacions:


| Figura | Mètode per dibuixar-la|
|--------|-----------------------|
| rectangle | `fillRect (int x, int y, int width, int height)` | 
| quadrat | Es tracta d'un rectangle on `width` i `height` són iguals |
| el·lipse | `fillOval (int x, int y, int width, int height)` |
| cercle | Es tracta d'una el·lipse on `width` i `height` són iguals |
| linia | drawLine (int x1, int y1, int x2, int y2) |

Fixeu-vos que per dibuiar el·lipses (i cercles), hem d'indicar la posició (x,y) del cantó superior-esquerre i l'alt i ample del rectangle que la conté. En canvi, nosaltres, guardem la posició (x,y) central, tant de l'el·lipse com del cercle i els seus radis (radi x i y en el cas de l'el·lipse, i radi en el cas del cercle).

Serà necessari docns, fer una xicoteta transformació a l'hora de dibuixar aquestes figures. Suposem que tenim la següen el·lipse:

```
ellipse 100 150 50 70 negre
```

Que vol dibuixar una el·lipse amb centre en la posició (x=100, y=150), i de radis 50 i 70. Tinguem en compte que aquestes mesures de radi seran la meitat del `width`i `height` que necessitem. A més, caldrà realitzar un desplaçament cap amunt i l'esquerra exactament igual que el radi. El resultat serà doncs:

```
fillOval (100-50, 150-70, 50*2, 70*2);
```

Generalitzant aquestes mesures, caldira fer:

```
fillOval(x-radiX, y-radiY, 2*x, 2*y)
```




