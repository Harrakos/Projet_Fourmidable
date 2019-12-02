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
    public ImageView pheromone;
    private String nomDuPossedeur = "";

    public Tuile() {
        this.rayon = 21;
        tuileRessource = true;
        Image surbrillanceI = new Image("Image_Tuile/SB.png");
        this.surbrillance = new ImageView(surbrillanceI);
        Image pheromoneI = new Image("Image_Tuile/Pheromone.png");
        this.pheromone = new ImageView(pheromoneI);
    }

    public Tuile(boolean tuileRessource){
        this.tuileRessource = false;
        Image surbrillanceI = new Image("Image_Tuile/SB.png");
        this.surbrillance = new ImageView(surbrillanceI);
        this.pheromone = new ImageView();
    }


    public Tuile(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.rayon = 21;
        tuileRessource = true;
        Image surbrillanceI = new Image("Image_Tuile/SB.png");
        this.surbrillance = new ImageView(surbrillanceI);
        Image pheromoneI = new Image("Image_Tuile/Pheromone.png");
        this.pheromone = new ImageView(pheromoneI);

    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
        surbrillance.setX(posX-32);
        pheromone.setX(posX);
    }
    public double getPosY() {
        return posY;
    }
    public void setPosY(double posY) {
        this.posY = posY;
        surbrillance.setY(posY-35);
        pheromone.setY(posY);

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

    public void setTuileRessource(boolean tuileRessource) {
        this.tuileRessource = tuileRessource;
    }

    public String getNomDuPossedeur() {
        return nomDuPossedeur;
    }

    public void setNomDuPossedeur(String nomDuPossedeur) {
        this.nomDuPossedeur = nomDuPossedeur;
    }
}

