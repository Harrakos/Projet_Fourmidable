package jeu.ObjetJeu.Ressource.RessourceMiniere;

public class TuileRoche extends TuileMiniere {
    public TuileRoche() {
        super();
        this.typeRessource = 8;
    }
    public TuileRoche(boolean accessible) {
        super(accessible);
        this.typeRessource = 8;
    }


    @Override
    public String toString() {
        return "RessourceRoche{"+super.toString();
    }
}

