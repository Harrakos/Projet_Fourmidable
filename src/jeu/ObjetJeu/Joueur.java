package jeu.ObjetJeu;

import javafx.scene.paint.Color;
import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Objectif.Objectif;
import jeu.ObjetJeu.Ressource.Tuile;

import java.util.ArrayList;

public class Joueur {
    private String pseudo;
    private Color couleur;
    private ArrayList<Objectif> listeObjectif;
    private ArrayList<Fourmi> listeFourmi;
    private ArrayList<Tuile> listeRessource;

    public Joueur(String pseudo, Color couleur) {
        this.pseudo = pseudo;
        this.couleur = couleur;
        listeObjectif = new ArrayList<>();
        listeFourmi = new ArrayList<>();
        listeRessource = new ArrayList<>();
   }



   /// Getter and Setter //////////////


    public ArrayList<Objectif> getListeObjectif() {
        return listeObjectif;
    }

    public void setListeObjectif(ArrayList<Objectif> listeObjectif) {
        this.listeObjectif = listeObjectif;
    }

    public ArrayList<Fourmi> getListeFourmi() {
        return listeFourmi;
    }

    public void setListeFourmi(ArrayList<Fourmi> listeFourmi) {
        this.listeFourmi = listeFourmi;
    }

    public ArrayList<Tuile> getListeRessource() {
        return listeRessource;
    }

    public void setListeRessource(ArrayList<Tuile> listeTuile) {
        this.listeRessource = listeTuile;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Color getCouleur() {
        return couleur;
    }
}

