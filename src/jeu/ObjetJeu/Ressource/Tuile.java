package jeu.ObjetJeu.Ressource;

import javax.swing.*;

public class Tuile {
    private double posX;
    private double posY;
    private double rayon;
    private boolean tuileRessource;

    public Tuile() {
        this.rayon = 21;
        tuileRessource = true;

    }

    public Tuile(boolean tuileRessource){
        this.tuileRessource = false;
    }


    public Tuile(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.rayon = 21;
        tuileRessource = true;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }
    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getRayon() {
        return rayon;
    }

    @Override
    public String toString() {
        return  "posX=" + posX +
                ", posY=" + posY +
                '}';
    }

    public boolean isTuileRessource() {
        return tuileRessource;
    }
}
