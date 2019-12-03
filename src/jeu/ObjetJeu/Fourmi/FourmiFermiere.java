package jeu.ObjetJeu.Fourmi;

import javafx.scene.image.Image;
import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileChasse;
import jeu.ObjetJeu.Ressource.RessourceFermiere.TuileFermiere;
import jeu.ObjetJeu.Ressource.Tuile;

public class FourmiFermiere extends Fourmi {
    public FourmiFermiere(Image imageFourmiFermiere) {
        super(imageFourmiFermiere);
    }

    @Override
    public String toString() {
        return "FourmiFermiere{}";
    }
    public boolean recupere(Tuile r) {
        if (r instanceof TuileFermiere) {
            return true;
        } else {
            return false;
        }
    }
}
