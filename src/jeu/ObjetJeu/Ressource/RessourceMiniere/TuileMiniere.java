package jeu.ObjetJeu.Ressource.RessourceMiniere;

import jeu.ObjetJeu.Ressource.Tuile;

public abstract class TuileMiniere extends Tuile {
    private boolean accessible;
    TuileMiniere() {
        super();
        this.accessible = false;
    }
    TuileMiniere(boolean c_accessible) {
        super();
        this.accessible = c_accessible;
    }


    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
