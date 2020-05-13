package com.ieseljust.edd.scenemaker;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Figura implements Renderizable{
    /*
     * Aquesta classe representa una escena, entesa com un conjunt d'objectes que
     * formen una imatge.
     * 
     * L'escena tindrà unes dimensions, que determinaran el marc per dibuixar
     * posteriorment.
     */

    private int tamX;
    private int tamY;

    // Les figures de l'escena s'emmagatzemen en una llista
    private ArrayList<Figura> LlistaFigures;
    private Color color;
    private int w;
    private int h;


    Figura() {
        // Constructor. Pr defecte creem un tamany de 800x600;
        this.tamX = 800;
        this.tamY = 600;
        this.color = getColor();

    }



    Figura(int x, int y, int w, int h, String color) {
        this.tamX = x;
        this.tamY = y;
        this.w = w;
        this.h = h;

        this.color = this.color;
        // Inicialitzem la llista de figures
        LlistaFigures = new ArrayList<Figura>();
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    public Color getColor() {
        return this.color;
    }
  

    // Mètodes accessors
    Integer getX() {
        return this.tamX;
    }

    Integer getY() {
        return this.tamY;
    }

    void setX(int x) {
        this.tamX = x;
    }

    void setY(int y) {
        this.tamY = y;
    }
    


    public void add(Figura figura) {
        /*
         * Aquest mètode afig un objecte de tipus Rectangle a l'escena.
         */

        // Comprovem que la figura cau dins la imatge
        if (figura.getX() < this.tamX && figura.getY() < this.tamY) {
            this.LlistaFigures.add(figura);
            System.out.println("\u001B[32m OK \u001B[0m");
        } else {
            // En cas contrari, mostrem l'error
            System.out.println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m");
        }
    }

    public void renderText() {
        /* Mostra la llista de figures i les seues propietats */

        // Recorrem la llista de figures i invoquem
        // el mètode describeMe de cadascuna d'elles.
        for (Figura f : this.LlistaFigures) {
            f.describeMe();
        }
    }
    public void describeMe() {
        /*
         * Mètode que mostra en mode text una descripció de la figura per la consola.
         * S'utilitzarà per al mètode llista de la CLI.
         */
        System.out.println("Retorna la figura en unes coordenades:" + tamX + "," + tamY+ "," + color);
    };
    public void renderScene() {
        /*
         * Aquest mètode s'encarrega de dibuixar l'escena. Per a això, crearà un objecte
         * de la classe renderer, que s'inicialitza amb les dimensions de la imatge, i
         * seguidament, li proporciona la llista de figures que es volen dibuixar.
         * Aquest mètode Render de la classe Renderer ja s'encarregarà de crear la
         * imatge, i invocar al mètode `render` de cada rectangle per tal que es dibuixe
         * en l'àrea de dibuix.
         */

        Renderer dr = new Renderer(this.tamX, this.tamY);
        dr.Render(LlistaFigures);

    };

    @Override
    public void render(Graphics g) {
        Renderer dr = new Renderer(this.tamX, this.tamY);
        dr.Render(LlistaFigures);
    }

    

    

}