package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;
import java.awt.Color;

import com.ieseljust.edd.scenemaker.Figura;

public class Quadrat extends Figura {
    /*
     * Aquesta classe representa un element gràfic de tipus rectangle
     */

    private Integer x;
    private Integer y;
    private Integer lados;

    private Color color;

     // Constructors
    Quadrat() {
        // Constructor per defecte sense paràmetres
        this.x = 0;
        this.y = 0;
        this.lados = 0;
        this.color = color;
    }

    Quadrat(int x, int y) {
        // Constructor on s'especifica només pa posició
        this.x = x;
        this.y = y;
        this.lados = 100;
        this.color = color;
    };

    Quadrat(int x, int y, Color color) {
        // Constructor on s'especifica la posició i el color
        this.x = x;
        this.y = y;
        this.lados = 100;
        this.color = color;
    }

    Quadrat(int x, int y, int lados, Color color) {
        // Constructor on s'especifica la posició, el color i les dimensions
        this.x = x;
        this.y = y;
        this.lados = lados;
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
        System.out.println("quadrat " + x + " " + y + " " + lados + " " + lados + " "+ color);
    };

    public void render(Graphics g) {
        /*
         * Mètode que dibuixa sobre un context gràfic la figura rectangle.
         * S'utilitza per al mètode render() de la cli.
         * 
         * Per dibuixar altres primitives de la classe Graphics, podeu consultar
         * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
         */

        g.setColor(color);             // Establim el color interior
        g.fillRect(x,y,lados,lados);    // Dibuixem un rectangle en la posició i mida indicades
    };

    public Integer getLados() {
        return lados;
    }

    public void setLados(Integer lados) {
        this.lados = lados;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
