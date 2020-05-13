package com.ieseljust.edd.scenemaker;

// Imports per a entrada de dades
import java.util.Scanner;
import java.util.Locale;
// Imports per gestionar el color de les imatges
import java.awt.Color;

// Imports per a gestió de llistes
import java.util.ArrayList;
import java.util.Set;

public class Cli {


    /*
     * Classe principal de l'aplicació. S'encarrega de la interacció amb l'usuari i
     * de la generació de l'escena amb les imatges.
     */
    // Escena serà una classe que mantindrà la llista
    // de figures a representar.
    private static Escena AppEscena;
    private int x;
    private int w;
    private int h;
    private int y;
    private String color;
    private int name;

    public void run(String[] args) {
      /*
         * Mètode llançador de la classe. S'encarrega de mantindre la CLI activa,
         * preguntant a l'usuari i executant les ordres que aquest introdueix.
         */

        Scanner keyboard = new Scanner(System.in);

        // Dimensions de la finestra
        int width, height;

        try {
            // Si s'especifiquen les dimensions, les inicialitzem
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        } catch (Exception e) {
            // Si no s'especifiquen, la imatge serà de 800x600
            width = 800;
            height = 600;
        }

        // Inicialitzem l'escena, amb una finestra de width x height
        AppEscena = new Escena(width, height);

        // Iniciem el bucle infinit fins que escriga "quit".
        String figura;


        do {
            // Preguntem la següent figura a emmagatzemar
            System.out.print("# Figura: ");
            String ordre = keyboard.nextLine();

            // Separem l'ordre introduida pel teclat en la forma: "Figura Posicio Mida
            // Color"
            String[] components = ordre.split(" ");

            figura = components[0];

            switch (figura) {
                case "dimensions":
                    try {
                        AppEscena.setX(Integer.parseInt(components[1]));
                        AppEscena.setY(Integer.parseInt(components[2]));
                    } catch (Exception e) {
                        // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                        System.out.println(
                                "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n dimensions x y\u001B[0m");
                    }
                    break;
                case "rectangle":
                case "elipse":
                case "cercle":
                case "linia":
                case "quadrat":
                    // Creació d'una figura de la classe Figura
                    try {
                        // Extraiem les dimensions

                        int x = Integer.parseInt((components[1]));
                        int y = Integer.parseInt((components[2]));
                        int w = Integer.parseInt((components[3]));
                        int h = Integer.parseInt((components[4]));
                        String color = components[5];
                        // Si tot és correcte creem la figura cercle
                        Figura nouFig = new Figura(x, y, w, h, color);
                        // I l'afegim a la llista
                        AppEscena.add(nouFig);

                    } catch (Exception e) {
                        // Si s'ha produït algun error als paràmetres, s'indica un error de sintaxi
                        if (figura.equals("cercle")) {
                            System.out.println(
                                    "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n cercle x y radi color\u001B[0m");
                            break;
                           
                        }
                        
                        if (figura.equals("elipse")) {
                            System.out.println(
                                    "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n elipse x1 y1 radiX radiY color\u001B[0m");
                                    break;

                        }

                        if (figura.equals("quadrat")) {
                            System.out.println(
                                    "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n quadrat x1 y1 size color\u001B[0m");
                            break;
                        }
                        if (figura.equals("rectangle")) {
                            System.out.println(
                                    "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n rectangle x1 y1 x2 y2 color\u001B[0m");
                                                                break;

                        }
                        if (figura.equals("linia")) {
                            System.out.println(
                                    "\u001B[31m Error de sintaxi. La sintaxi correcta és:\n linia x1 y1 x2 y2 color\u001B[0m");
                                                                break;

                        }
                    }

                case "get":
                    // Descarreguem una figura en el format que estem treballant des d'Internet
                    // D'això s'encarrega la classe RemoteManager ja implementada
                    try {
                        // Descarrega una llista de figures
                        String fitxer = components[1];
                        RemoteManager rm = new RemoteManager();

                        ArrayList<String> novesFigures = rm.download(fitxer);
                        AppEscena = new Escena();
                        for (String linia : novesFigures) {
                            // Aci hem de tornar a fer el switch per "desmembrar" la línia
                            String[] items = linia.split(" ");
                            switch (items[0]) {
                                case "dimensions":
                                    AppEscena.setX(Integer.parseInt(items[1]));
                                    AppEscena.setY(Integer.parseInt(items[2]));
                                    break;
                                case "rectangle":
                                    break;
                                case "elipse":
                                    x = Integer.parseInt((items[1]));
                                    y = Integer.parseInt((items[2]));
                                    w = Integer.parseInt((items[3]));
                                    h = Integer.parseInt((items[4]));
                                    String color = items[5];

                                    Figura nouFig = new Figura(x, y, w, h, color);

                                    // I l'afegim a la llista
                                    AppEscena.add(nouFig);
                                    break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Excepció en la càrrega del fitxer: ");
                        System.err.println(e);
                    }
                    break;

                case "remotelist":
                    try {
                        // Descarrega l'index de figures del servidor remot
                        RemoteManager rm = new RemoteManager();

                        ArrayList<String> liniaFitxers = rm.download("index.php");
                        String[] fitxers = liniaFitxers.get(0).split("<br/>");

                        for (String fitxer : fitxers) {
                            System.out.println(fitxer);
                        }

                    } catch (Exception e) {
                        System.out.println("Excepció en la càrrega del fitxer: ");
                        System.err.println(e);
                    }

                    break;

                case "list":
                    // Si l'ordre indicada és llista, imprimirem la llista de figures
                    AppEscena.renderText();

                    break;

                case "render":
                    AppEscena.renderScene();
                    break;

                case "quit":
                    System.out.println("Adéu!");
                    System.exit(0);

                default:
                    // Si hem arribat aci, l'ordre no es coneix
                    System.out.println("\u001B[31m Figura no reconeguda. Pasar com a parámetre: (linia/rectangle/elipse/quadrat/cercle) \u001B[0m");
            }

        } while (true);
    }

    /*
         * Mètode auxiliar per tal de "traduir" els colors en mode text a la seua
         * representació com a constants en awt.Color
     */
    Color getColor(String color) {
        /*
         * Mètode auxiliar per tal de "traduir" els colors en mode text a la seua
         * representació com a constants en awt.Color
         */

        switch (color) {
            case "roig":
                return Color.RED;
            case "verd":
                return Color.GREEN;
            case "blau":
                return Color.BLUE;
            case "groc":
                return Color.YELLOW;
            case "magenta":
                return Color.MAGENTA;
            case "cyan":
                return Color.CYAN;
            case "blanc":
                return Color.WHITE;
            case "negre":
                return Color.BLACK;
            case "gris":
                return Color.GRAY;
            case "grisClar":
                return Color.LIGHT_GRAY;
            case "grisFosc":
                return Color.DARK_GRAY;
            case "rosa":
                return Color.PINK;
            case "taronja":
                return Color.ORANGE;
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        /*
         * Mètode d'inici de l'aplicació. Creem un nou objecte de tipus Cli, i
         * l'executem amb el mètode run.
         * 
         * Els arguments que li passem seran les dimensions per defecte d'una imatge.
         */

        Cli myCli = new Cli();
        myCli.run(args);
    }

}