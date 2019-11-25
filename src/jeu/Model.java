package jeu;

import jeu.ObjetJeu.Joueur;
import jeu.ObjetJeu.Ressource;

import java.util.ArrayList;

public class Model {

    private int nbreJoueurs;
    public ArrayList<Joueur> listeJoueurs;
    private Joueur currentPlayer;
    private ArrayList<Ressource> listeRessourcesDispo;

    public Model(){
        nbreJoueurs = 0;
        listeJoueurs = new ArrayList<>();
        remplissagelisteRessourcesDispo();
    }




    public int getNbreJoueurs() {
        return nbreJoueurs;
    }

    public void setNbreJoueurs(int nbreJoueurs) {
        this.nbreJoueurs = nbreJoueurs;
    }

    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Joueur currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<Ressource> getListeRessourcesDispo() {
        return listeRessourcesDispo;
    }

    public void setListeRessourcesDispo(ArrayList<Ressource> listeRessourcesDispo) {
        this.listeRessourcesDispo = listeRessourcesDispo;
    }

    private void remplissagelisteRessourcesDispo(){
        listeRessourcesDispo = new ArrayList<>();
        listeRessourcesDispo.add(new Ressource(807,160));
        listeRessourcesDispo.add(new Ressource(855.5,806));

    }

    private void remplissageLigne(int nbrRepetition, double posXDepart, double posYDepart){

    }
}

