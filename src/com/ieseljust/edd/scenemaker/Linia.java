package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

import com.ieseljust.edd.scenemaker.Figura;

public class Linia extends Figura{
    /*
     * Aquesta classe representa un element gràfic de tipus rectangle
     */

    private Integer x;
    private Integer y;
    private Integer w;
    private Integer h;
    private Color color;

    // Constructors
    Linia() {
        // Constructor per defecte sense paràmetres
        this.x = 0;
        this.y = 0;
        this.w = 0;
        this.h = 0;
        this.color = color;
    }

    Linia(int x, int y) {
        // Constructor on s'especifica només pa posició
        this.x = x;
        this.y = y;
        this.w = 100;
        this.h = 100;
        this.color = color;
    };

    Linia(int x, int y, Color color) {
        // Constructor on s'especifica la posició i el color
        this.x = x;
        this.y = y;
        this.w = 100;
        this.h = 100;
        this.color = color;
    }

    Linia(int x, int y, int w, int h, Color color) {
        // Constructor on s'especifica la posició, el color i les dimensions
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    // Mètode Accessors

    @Override
    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void describeMe() {
        /*
         * Mètode que mostra en mode text una descripció de la figura per la consola.
         * S'utilitzarà per al mètode llista de la CLI.
         */
        System.out.println("linia " + x + " " + y + " " + w + " " + h+ " " + color);
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
        g.drawLine (x, y, w, h);  
        // Dibuixem una linia en la posició i mida indicades
    };

}
