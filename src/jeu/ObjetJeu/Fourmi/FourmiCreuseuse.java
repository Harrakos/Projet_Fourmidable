package jeu.ObjetJeu.Fourmi;

import javafx.scene.image.Image;
import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileChasse;
import jeu.ObjetJeu.Ressource.RessourceMiniere.TuileMiniere;
import jeu.ObjetJeu.Ressource.Tuile;

public class FourmiCreuseuse extends Fourmi {
    public FourmiCreuseuse(Image imageFourmiCreuseuse) {
        super(imageFourmiCreuseuse);
    }

    @Override
    public String toString() {
        return "FourmiCreuseuse{}";
    }

    public boolean recupere(Tuile r) {
        if (r instanceof TuileMiniere) {
            return true;
        } else {
            return false;
        }
    }
}
