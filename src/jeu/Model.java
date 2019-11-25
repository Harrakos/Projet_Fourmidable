package jeu;

import jeu.ObjetJeu.Joueur;

import java.util.ArrayList;

public class Model {

    private int nbreJoueurs;
    public ArrayList<Joueur> listeJoueurs;
    private Joueur currentPlayer;


    public Model(){
        nbreJoueurs = 0;
        listeJoueurs = new ArrayList<>();
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
}
