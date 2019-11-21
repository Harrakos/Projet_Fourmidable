package jeu;

import jeu.ObjetJeu.Joueur;

import java.util.ArrayList;

public class Model {

    private int nbreJoueurs;
    public ArrayList<Joueur> listeJoueurs;

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
}
