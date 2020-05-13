package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

import com.ieseljust.edd.scenemaker.Renderizable;
import com.ieseljust.edd.scenemaker.Figura;

public class Quadrat extends Figura {
    /*
     * Aquesta classe representa un element gràfic de tipus rectangle
     */

    private Integer x;
    private Integer y;
    private Color color;
    private Integer size;

    // Constructors
    Quadrat() {
        // Constructor per defecte sense paràmetres
        this.x = 0;
        this.y = 0;
        this.size = 0;
        this.color = Color.GREEN;
    }

    Quadrat(int x, int y, int size) {
        // Constructor on s'especifica només pa posició
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = Color.GREEN;
    };

    Quadrat(int x, int y,int size, Color color) {
        // Constructor on s'especifica la posició i el color
        this.x = x;
        this.y = y;
        this.size= size;
        this.color = color;
    }


    // Mètode Accessors

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    public Integer getSize() {
        return size;
    }
 

    public void describeMe() {
        /*
         * Mètode que mostra en mode text una descripció de la figura per la consola.
         * S'utilitzarà per al mètode llista de la CLI.
         */
        System.out.println("quadrat " + x + " " + y + " " + size + " " + color);
    };

    public void render(Graphics g) {
        /*
         * Mètode que dibuixa sobre un context gràfic la figura rectangle.
         * S'utilitza per al mètode render() de la cli.
         * 
         * Per dibuixar altres primitives de la classe Graphics, podeu consultar
         * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
         */

        g.setColor(this.color);             // Establim el color interior
        g.fillRect(x, y,size,size);    // Dibuixem un rectangle en la posició i mida indicades
    };

}
