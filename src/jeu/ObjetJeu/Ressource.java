package jeu.ObjetJeu;

public class Ressource {
    private double posX;
    private double posY;
    private double rayon;

    public Ressource(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.rayon = 17;
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
}
