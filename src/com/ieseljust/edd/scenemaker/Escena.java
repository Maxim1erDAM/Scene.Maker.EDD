package com.ieseljust.edd.scenemaker;

import java.util.ArrayList;

class Escena {
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
    private ArrayList<Rectangle> LlistaFiguraRectangle;
    private ArrayList<Elipse> LlistaFiguraElipse;
    private ArrayList<Cercle> LlistaFiguraCercle;
    private ArrayList<Linia> LlistaFiguraLinia;
    private ArrayList<Quadrat> LlistaFiguraQuadrat;

    Escena() {
        // Constructor. Pr defecte creem un tamany de 800x600;
        this.tamX = 800;
        this.tamY = 600;

        // Inicialitzem la llista de figures
        LlistaFiguraRectangle = new ArrayList<Rectangle>();
        LlistaFiguraElipse = new ArrayList<Elipse>();
        LlistaFiguraCercle = new ArrayList<Cercle>();
        LlistaFiguraLinia = new ArrayList<Linia>();
        LlistaFiguraQuadrat = new ArrayList<Quadrat>();

    }

    Escena(int x, int y) {
        // Constructor (sobrecarregat), quan se'ns indica
        // un tamany per al marc.
        this.tamX = x;
        this.tamY = y;

        // Inicialitzem la llista de figures
        LlistaFiguraRectangle = new ArrayList<Rectangle>();
        LlistaFiguraElipse = new ArrayList<Elipse>();
        LlistaFiguraCercle = new ArrayList<Cercle>();
        LlistaFiguraLinia = new ArrayList<Linia>();
        LlistaFiguraQuadrat = new ArrayList<Quadrat>();

    }

    // Mètodes accessors
    int getX() {
        return this.tamX;
    }

    int getY() {
        return this.tamY;
    }

    void setX(int x) {
        this.tamX = x;
    }

    void setY(int y) {
        this.tamY = y;
    }

    public void add(Rectangle figura) {
        /*
         * Aquest mètode afig un objecte de tipus Rectangle a l'escena.
         */

        // Comprovem que la figura cau dins la imatge
        if (figura.getX() < this.tamX && figura.getY() < this.tamY) {
            this.LlistaFiguraRectangle.add(figura);
            System.out.println("\u001B[32m OK \u001B[0m");
        } else {
            // En cas contrari, mostrem l'error
            System.out.println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m");
        }
    }
    void add(Elipse figura) {
         /*
         * Aquest mètode afig un objecte de tipus Rectangle a l'escena.
         */

        // Comprovem que la figura cau dins la imatge
        if (figura.getX() < this.tamX && figura.getY() < this.tamY) {
            this.LlistaFiguraElipse.add(figura);
            System.out.println("\u001B[32m OK \u001B[0m");
        } else {
            // En cas contrari, mostrem l'error
            System.out.println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m");
        } }
    
    void add(Cercle figura) {
         /*
         * Aquest mètode afig un objecte de tipus Rectangle a l'escena.
         */

        // Comprovem que la figura cau dins la imatge
        if (figura.getX() < this.tamX && figura.getY() < this.tamY) {
            this.LlistaFiguraCercle.add(figura);
            System.out.println("\u001B[32m OK \u001B[0m");
        } else {
            // En cas contrari, mostrem l'error
            System.out.println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m");
        } }
    
    void add(Linia figura) {
         /*
         * Aquest mètode afig un objecte de tipus Rectangle a l'escena.
         */

        // Comprovem que la figura cau dins la imatge
        if (figura.getx1() < this.tamX && figura.gety1() < this.tamY) {
            this.LlistaFiguraLinia.add(figura);
            System.out.println("\u001B[32m OK \u001B[0m");
        } else {
            // En cas contrari, mostrem l'error
            System.out.println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m");
        } }
    void add(Quadrat figura) {
         /*
         * Aquest mètode afig un objecte de tipus Rectangle a l'escena.
         */

        // Comprovem que la figura cau dins la imatge
        if (figura.getX() < this.tamX && figura.getY() < this.tamY) {
            this.LlistaFiguraQuadrat.add(figura);
            System.out.println("\u001B[32m OK \u001B[0m");
        } else {
            // En cas contrari, mostrem l'error
            System.out.println("\u001B[31m La imatge cau fora de l'escena. \u001B[0m");
        } }
    public void renderText() {
        /* Mostra la llista de figures i les seues propietats */

        // Recorrem la llista de figures i invoquem
        // el mètode describeMe de cadascuna d'elles.
        for (Rectangle f : this.LlistaFiguraRectangle) {
            f.describeMe();
        }
    }

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
        dr.Render(LlistaFiguraRectangle);

    };

    

    

}
