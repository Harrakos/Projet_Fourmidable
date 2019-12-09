package jeu.ObjetJeu.Fourmi;

import javafx.scene.image.Image;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileChasse;
import jeu.ObjetJeu.Ressource.Tuile;

public class FourmiChasseuse extends Fourmi {


    public FourmiChasseuse(Image imageFourmiChasseuse) {
        super(imageFourmiChasseuse);
        this.typeFourmi = 0;
    }

    @Override
    public String toString() {
        return "FourmiChasseuse{}";
    }

    public boolean recupere(Tuile r){
        return r instanceof TuileChasse;
    }
}
