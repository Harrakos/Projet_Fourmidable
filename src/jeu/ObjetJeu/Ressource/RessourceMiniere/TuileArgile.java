package jeu.ObjetJeu.Ressource.RessourceMiniere;

public class TuileArgile extends TuileMiniere {
    public TuileArgile() {
        super();
        this.typeRessource = 6;
    }
    public TuileArgile(boolean accessible) {
        super(accessible);
        this.typeRessource = 6;
    }

    @Override
    public String toString() {
        return "RessourceArgile{"+super.toString();
    }
}
