package jeu.ObjetJeu.Fourmi;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jeu.ObjetJeu.Ressource.Tuile;

public class Fourmi {
    public ImageView imageFourmi;

    /*
    chasse = 0
    recolte = 1
    minage = 2

     */
    protected int typeFourmi;

    public Fourmi(Image imageFourmi ) {
        this.imageFourmi = new ImageView(imageFourmi);
    }



    public void setX(double x){
        this.imageFourmi.setX(x-10.5);
    }
    public void setY(double y){
        this.imageFourmi.setY(y-10.5);
    }

    public double getX(){
        return  this.imageFourmi.getX();
    }

    public double getY(){
        return  this.imageFourmi.getY();
    }


    @Override
    public String toString() {
        return "Fourmi{}";
    }

    public boolean recupere(Tuile r) {
        return false;
    }

    public int getTypeFourmi() {
        return typeFourmi;
    }

    public void setTypeFourmi(int typeFourmi) {
        this.typeFourmi = typeFourmi;
    }
}
