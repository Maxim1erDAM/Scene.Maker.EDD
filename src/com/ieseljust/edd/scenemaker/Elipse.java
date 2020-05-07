package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

import com.ieseljust.edd.scenemaker.Renderizable;
public class Elipse implements Renderizable{
    /*
     * Aquesta classe representa un element gràfic de tipus rectangle
     */

    private Integer x;
    private Integer y;
    private Color color;
    private Integer radiX;
    private Integer radiY;

    // Constructors
    Elipse() {
        // Constructor per defecte sense paràmetres
        this.x = 0;
        this.y = 0;
        this.radiX = 100;
        this.radiY = 100;
        this.color = Color.BLACK;
    }

    Elipse(int x, int y) {
        // Constructor on s'especifica només pa posició
        this.x = x;
        this.y = y;
        this.radiX = 100;
        this.radiY = 100;
        this.color = Color.BLACK;
    };

    Elipse(int x, int y, Color color) {
        // Constructor on s'especifica la posició i el color
        this.x = x;
        this.y = y;
        this.radiX = 100;
        this.radiY = 100;
        this.color = color;
    }

    Elipse(int x, int y, int radiX, int radiY, Color color) {
        // Constructor on s'especifica la posició, el color i les dimensions
        this.x = x;
        this.y = y;
        this.radiX = radiX;
        this.radiY = radiY;
        this.color = color;
    }

    // Mètode Accessors

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    public Integer getradiX() {
        return radiX;
    }

    public Integer getadiY() {
        return radiY;
    }
    public void describeMe() {
        /*
         * Mètode que mostra en mode text una descripció de la figura per la consola.
         * S'utilitzarà per al mètode llista de la CLI.
         */
        System.out.println("elipse " + x + " " + y + " " + radiX + " " + radiY + " " + color);
    };

    public void render(Graphics g) {
        /*
         * Mètode que dibuixa sobre un context gràfic la figura elipse.
         * S'utilitza per al mètode render() de la cli.
         * 
         * Per dibuixar altres primitives de la classe Graphics, podeu consultar
         * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
         */

        g.setColor(this.color);             // Establim el color interior
        g.fillOval(x, y, radiX, radiY);    // Dibuixem una elipse en la posició i mida indicades
    };

}
