package com.ieseljust.edd.scenemaker;

import java.awt.Graphics;

/*
Intefície que s'assegura que els mètode que la implementen
ofereixen un mètide anomenat "render", per dibuixar a 
un objecte de tipus Graphics.
*/

public interface Renderizable {
    public void render(Graphics g);
}