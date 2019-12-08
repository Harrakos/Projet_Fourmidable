package jeu.ObjetJeu.Objectif;

public class Objectif {
    int typeObjectif;
    boolean accompli;

    public Objectif() {
        this.accompli = false;
    }

    public int getTypeObjectif() {
        return typeObjectif;
    }

    public void setTypeObjectif(int typeObjectif) {
        this.typeObjectif = typeObjectif;
    }

    public int[] setMessage(int r1, int r2, int r3){
        return null;
    }


    public boolean isAccompli() {
        return accompli;
    }

    public void setAccompli(boolean accompli) {
        this.accompli = accompli;
    }
}

