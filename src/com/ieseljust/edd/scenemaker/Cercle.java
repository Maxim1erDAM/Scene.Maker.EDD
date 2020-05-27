package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

import com.ieseljust.edd.scenemaker.Figura;

public class Cercle extends Figura {
    /*
     * Aquesta classe representa un element gràfic de tipus rectangle
     */

    private Integer x;
    private Integer y;
    private Integer radi;

    private Color color;

   // Constructors
    Cercle() {
        // Constructor per defecte sense paràmetres
        this.x = 0;
        this.y = 0;
        this.radi = 0;
        this.color = Color.BLUE;
    }

    Cercle(int x, int y) {
        // Constructor on s'especifica només pa posició
        this.x = x;
        this.y = y;
        this.radi = 100;
        this.color = color;
    };

    public Integer getRadi() {
        return radi;
    }

    Cercle(int x, int y, Color color) {
        // Constructor on s'especifica la posició i el color
        this.x = x;
        this.y = y;
        this.color = color;
    }

    Cercle(int x, int y, int radi,Color color) {
        // Constructor on s'especifica la posició, el color i les dimensions
        this.x = x;
        this.y = y;
        this.radi = radi;

        this.color = color;
    }



  

    // Mètode Accessors

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }


    public void setRadi(Integer radi) {
        this.radi = radi;
    }


 

  
    public void describeMe() {
        /*
         * Mètode que mostra en mode text una descripció de la figura per la consola.
         * S'utilitzarà per al mètode llista de la CLI.
         */
        System.out.println("cercle " + x + " " + y + " " + radi + " "+ color);
    };


    public void setH(Integer radi) {
        this.radi = radi;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void render(Graphics g) {
        /*
         * Mètode que dibuixa sobre un context gràfic la figura elipse.
         * S'utilitza per al mètode render() de la cli.
         * 
         * Per dibuixar altres primitives de la classe Graphics, podeu consultar
         * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
         */

        g.setColor(color);   
        // Establim el color interior
        g.fillOval(x-radi, y-radi,radi * 2,radi * 2);
    // Dibuixem una elipse en la posició i mida indicades
    };

}
