package com.ieseljust.edd.scenemaker;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.net.*;
import java.util.ArrayList;

public class RemoteManager {
    /*
     * Aquest mètode s'encarrega de comunicar-se amb un servidor extern
     * (joamuran.net/EDD), que ens proporciona figures ja dibuixades, per tal de no
     * haver d'estar dibuixant-les cada vegada.
     */

    public ArrayList<String> download(String filename) {
        /*
        Retorna una llista de cadenes de text amb el contingut del fitxer `filename`,
        descarregat del servidor.
        */

        ArrayList<String> linies = new ArrayList<String>();

        try {
            URL myURL = new URL("http://joamuran.net/EDD/" + filename);

            // Determinem el tipus de fitxer
            URLConnection uc = myURL.openConnection();

            // Obrim el flux
            InputStream is = myURL.openStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(reader);

            String line;
            while ((line = bReader.readLine()) != null) {
                linies.add(line);
            }

            // Tanquem buffers i streams
            bReader.close();
            reader.close();
            is.close();

            return linies;

        } catch (

        MalformedURLException e) {
            System.out.println("Excepció: URL mal formatada!");
            return null;
        } catch (IOException e) {
            System.out.println("Excepció no controlada: " + e.toString());
            return null;
        }
    }

}