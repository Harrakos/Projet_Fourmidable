package jeu.ObjetJeu;

class TypeRessource {

    public TypeRessource(){
    }


    public TypeRessource(){
    }


    public Ressources getRessource(String name) {
        switch (name) {
            case "Chenille":
                return Ressources.CHENILLE;
            case "Coccinelle":
                return Ressources.COCCINELLE;
            case "Scarabée":
                return Ressources.SCARABEE;
            case "Argile":
                return Ressources.ARGILE;
            case "Roche":
                return Ressources.ROCHE;
            case "Terre":
                return Ressources.TERRE;
            case "Champignon":
                return Ressources.CHAMPIGNON;
            case "Mirtile":
                return Ressources.MIRTILE;
            case "Framboise":
                return Ressources.FRAMBOISE;
            default:
                return null;
        }
    }
}