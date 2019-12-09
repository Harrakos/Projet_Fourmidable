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
    public ImageView detruit;
    private String nomDuPossedeur = "";
    private boolean tuileDetruite = false;
    /*
    -1 = tuile non cliquable

    0 = Scarabe
    1 = Coccinelle
    2 = Chenille

    3 = Myrtille
    4 = Framboise
    5 = Champignon

    6 = Argile
    7 = Terre
    8 = Roche

     */
    protected int typeRessource;

    public Tuile() {
        this.rayon = 21;
        tuileRessource = true;
        Image surbrillanceI = new Image("Image_Tuile/SB.png");
        this.surbrillance = new ImageView(surbrillanceI);
        Image pheromoneI = new Image("Image_Tuile/Pheromone.png");
        this.pheromone = new ImageView(pheromoneI);
        Image detruitI = new Image("Image_Tuile/detruit.png");
        this.detruit = new ImageView(detruitI);

    }

    public Tuile(boolean tuileRessource){
        this.tuileRessource = false;
        Image surbrillanceI = new Image("Image_Tuile/SB.png");
        this.surbrillance = new ImageView(surbrillanceI);
        this.pheromone = new ImageView();
        this.detruit = new ImageView();


        this.typeRessource = 0;
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
        Image detruitI = new Image("Image_Tuile/detruit.png");
        this.detruit = new ImageView(detruitI);

    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
        surbrillance.setX(posX-32);
        pheromone.setX(posX);
        detruit.setX(posX-32);
    }
    public double getPosY() {
        return posY;
    }
    public void setPosY(double posY) {
        this.posY = posY;
        surbrillance.setY(posY-35);
        pheromone.setY(posY);
        detruit.setY(posY-35);


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

    public int getTypeRessource() {
        return typeRessource;
    }

    public void setTypeRessource(int typeRessource) {
        this.typeRessource = typeRessource;
    }

    public boolean isTuileDetruite() {
        return tuileDetruite;
    }

    public void setTuileDetruite(boolean tuileDetruite) {
        this.tuileDetruite = tuileDetruite;
    }
}

