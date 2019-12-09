package jeu.ObjetJeu.Ressource.RessourceMiniere;

public class TuileTerre extends TuileMiniere {
    public TuileTerre() {
        super();
        this.typeRessource = 7;
    }
    public TuileTerre(boolean accessible) {
        super(accessible);
        this.typeRessource = 7;
    }

    @Override
    public String toString() {
        return "RessourceTerre{"+super.toString();
    }
}
