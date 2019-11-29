package jeu.ObjetJeu.Ressource;

import javafx.scene.image.Image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tuile {
    private double posX;
    private double posY;
    private double rayon;
    private boolean tuileRessource;
    public ImageView surbrillance;

    public Tuile() {
        this.rayon = 21;
        tuileRessource = true;
        Image surbrillanceI = new Image("Image_Tuile/SB.png");
        this.surbrillance = new ImageView(surbrillanceI);
    }

    public Tuile(boolean tuileRessource){
        this.tuileRessource = false;
        Image surbrillanceI = new Image("Image_Tuile/SB.png");
        this.surbrillance = new ImageView(surbrillanceI);    }


    public Tuile(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.rayon = 21;
        tuileRessource = true;
        Image surbrillanceI = new Image("Image_Tuile/Surbrillance.png");
        this.surbrillance = new ImageView(surbrillanceI);
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
        surbrillance.setX(posX-32);
    }
    public double getPosY() {
        return posY;
    }
    public void setPosY(double posY) {
        this.posY = posY;
        surbrillance.setY(posY-35);

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
