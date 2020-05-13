package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

import com.ieseljust.edd.scenemaker.Figura;

public class Linia extends Figura{
    /*
     * Aquesta classe representa un element gràfic de tipus rectangle
     */

    private Integer x1;
    private Integer y1;
    private Integer w;
    private Integer h;
    private Color color;

    // Constructors
    Linia() {
        // Constructor per defecte sense paràmetres
        this.x1 = 0;
        this.y1 = 0;
        this.w = 0;
        this.h = 0;
        this.color = Color.BLACK;
    }

    Linia(int x1, int x2,int w,int h) {
        // Constructor on s'especifica només pa posició
        this.x1 = x1;
        this.y1 = y1;
        this.w = w;
        this.h = h;
        this.color = Color.BLACK;
    };

    Linia(int x, int y, Color color) {
        // Constructor on s'especifica la posició i el color
        this.x1 = x1;
        this.y1 = y1;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    Linia(int x1, int y1, int x2,int y2, Color color) {
        // Constructor on s'especifica la posició, el color i les dimensions
        this.x1 = x1;
        this.y1 = y1;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    

    // Mètode Accessors

    public Integer getx1() {
        return x1;
    }
    public Integer getx2() {
        return h;
    }
    public Integer gety1() {
        return y1;
    }
    public Integer gety2() {
        return w;
    }
    

    public void describeMe() {
        /*
         * Mètode que mostra en mode text una descripció de la figura per la consola.
         * S'utilitzarà per al mètode llista de la CLI.
         */
        System.out.println("linia " + x1 + " " + y1 + " " + w + " " + h+ " " + color);
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
        g.drawLine (x1, y1, w, h);  
        // Dibuixem una linia en la posició i mida indicades
    };

}
