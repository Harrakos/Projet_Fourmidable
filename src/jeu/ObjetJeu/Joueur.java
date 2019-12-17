package jeu.ObjetJeu;

import javafx.scene.paint.Color;
import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Objectif.Objectif;
import jeu.ObjetJeu.Ressource.RessourceMiniere.TuileArgile;
import jeu.ObjetJeu.Ressource.RessourceMiniere.TuileMiniere;
import jeu.ObjetJeu.Ressource.RessourceMiniere.TuileRoche;
import jeu.ObjetJeu.Ressource.RessourceMiniere.TuileTerre;
import jeu.ObjetJeu.Ressource.Tuile;

import java.util.ArrayList;
import java.util.Arrays;

public class Joueur {
    private String pseudo;
    private Color couleur;
    private ArrayList<Objectif> listeObjectif;
    private ArrayList<Fourmi> listeFourmi;
    private int[] tabNbrRessource;
    private TuileMiniere[][] tabMine;


    private ArrayList<Fourmi> listFourmiTerrier;
    private int[] positionTerrierJoueur;

    public Joueur(String nom) {
        pseudo = nom;
    }

    public Joueur(String pseudo, Color couleur) {

        this.pseudo = pseudo;
        this.couleur = couleur;
        listeObjectif = new ArrayList<>();
        listeFourmi = new ArrayList<>();
        //listeRessource = new ArrayList<>();
        tabNbrRessource = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        listFourmiTerrier = new ArrayList<>();
        positionTerrierJoueur = new int[2];
        tabMine = new TuileMiniere[][]{{null, new TuileTerre(), new TuileArgile(), new TuileRoche()},
                {null, new TuileRoche(), new TuileTerre(), new TuileArgile()},
                {new TuileArgile(), new TuileArgile(), new TuileRoche(), new TuileTerre()},
                {new TuileRoche(), new TuileArgile(), new TuileRoche(), new TuileTerre()},
                {new TuileTerre(true), new TuileTerre(true), new TuileArgile(true), new TuileRoche(true)}};
        int positionX = 27;
        int positionY = 43;

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 4; y++) {
                if (tabMine[x][y] != null) {
                    tabMine[x][y].setPosX(positionX);
                    tabMine[x][y].setPosY(positionY);
                }
                positionY += 45;

            }
            positionX += 51;
            positionY = 43;
        }
    }
        /// Getter and Setter //////////////

        public ArrayList<Objectif> getListeObjectif () {
            return listeObjectif;
        }

        public void setListeObjectif (ArrayList < Objectif > listeObjectif) {
            this.listeObjectif = listeObjectif;
        }

        public ArrayList<Fourmi> getListeFourmi () {
            return listeFourmi;
        }

        public void setListeFourmi (ArrayList < Fourmi > listeFourmi) {
            this.listeFourmi = listeFourmi;
        }


        public ArrayList<Fourmi> getListFourmiTerrier () {
            return listFourmiTerrier;
        }

        public void setListFourmiTerrier (ArrayList < Fourmi > listFourmiTerrier) {
            this.listFourmiTerrier = listFourmiTerrier;
        }

        public int[] getPositionTerrierJoueur () {
            return positionTerrierJoueur;
        }

        public void setPositionTerrierJoueur ( int[] positionTerrierJoueur){
            this.positionTerrierJoueur = positionTerrierJoueur;
        }

        public String getPseudo () {
            return pseudo;
        }

        public Color getCouleur () {
            return couleur;
        }

        public int[] getTabNbrRessource () {
            return tabNbrRessource;
        }

        public void setTabNbrRessource ( int[] tabNbrRessource){
            this.tabNbrRessource = tabNbrRessource;
        }

        public TuileMiniere[][] getTabMine () {
            return tabMine;
        }

        public void setTabMine (TuileMiniere[][]tabMine){
            this.tabMine = tabMine;
        }
    }

