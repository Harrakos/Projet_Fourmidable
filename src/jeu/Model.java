package jeu;

import javafx.scene.image.Image;
import jeu.ObjetJeu.Fourmi.FourmiChasseuse;
import jeu.ObjetJeu.Joueur;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileChenille;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileCoccinelle;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileScarabe;
import jeu.ObjetJeu.Ressource.RessourceFermiere.TuileChampigon;
import jeu.ObjetJeu.Ressource.RessourceFermiere.TuileFramboise;
import jeu.ObjetJeu.Ressource.Tuile;
import jeu.ObjetJeu.Ressource.RessourceFermiere.TuileMyrtille;

import java.util.ArrayList;

public class Model {

    private int pm;
    private int nbreJoueurs;
    public ArrayList<Joueur> listeJoueurs;
    private Joueur currentPlayer;
    private ArrayList<Tuile> listeRessourcesDispo;


    public Model(){
        nbreJoueurs = 0;
        listeJoueurs = new ArrayList<>();
        remplissagelisteRessourcesDispo();
        pm = 3;

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

    public ArrayList<Tuile> getListeRessourcesDispo() {
        return listeRessourcesDispo;
    }

    public void setListeRessourcesDispo(ArrayList<Tuile> listeRessourcesDispo) {
        this.listeRessourcesDispo = listeRessourcesDispo;
    }
    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    private void remplissagelisteRessourcesDispo(){
        listeRessourcesDispo = new ArrayList<>();
        Tuile[] tabTuile = {new TuileMyrtille(), new Tuile(false), new TuileCoccinelle(),
                new TuileChenille(), new TuileFramboise(), new TuileCoccinelle(), new TuileFramboise(),
                new TuileScarabe(), new TuileChampigon(), new TuileChenille(), new TuileScarabe(), new TuileChampigon(), new TuileMyrtille(), new TuileChenille(), new TuileCoccinelle(),
                new TuileScarabe(), new TuileFramboise(), new TuileCoccinelle(), new TuileMyrtille(), new TuileMyrtille(), new TuileCoccinelle(), new TuileFramboise(), new TuileMyrtille(), new TuileChampigon(), new TuileFramboise(), new Tuile(false),
                new Tuile(false), new TuileCoccinelle(), new TuileChampigon(), new TuileChenille(), new TuileScarabe(), new TuileChenille(), new TuileChampigon(), new TuileCoccinelle(), new TuileFramboise(), new TuileCoccinelle(), new TuileScarabe(), new TuileChenille(),
                new TuileMyrtille(), new TuileFramboise(), new TuileChenille(), new TuileMyrtille(), new TuileFramboise(), new TuileChampigon(), new TuileChenille(), new TuileScarabe(), new TuileScarabe(), new TuileChenille(), new TuileFramboise(), new TuileScarabe(),
                new TuileChampigon(), new TuileChampigon(), new TuileCoccinelle(), new TuileChenille(), new TuileFramboise(), new TuileCoccinelle(), new TuileMyrtille(), new TuileMyrtille(), new TuileChampigon(), new TuileMyrtille(), new TuileChampigon(),
                new TuileScarabe(), new TuileMyrtille(), new TuileScarabe(), new TuileChampigon(), new TuileScarabe(), new Tuile(false), new TuileChampigon(), new TuileChenille(), new TuileChenille(), new TuileMyrtille(), new TuileCoccinelle(),
                new TuileCoccinelle(), new TuileChenille(), new TuileFramboise(), new TuileFramboise(), new TuileCoccinelle(), new TuileFramboise(), new TuileChenille(), new TuileScarabe(), new TuileChampigon(), new TuileScarabe(), new TuileChampigon(),
                new TuileFramboise(), new TuileChampigon(), new TuileMyrtille(), new TuileScarabe(), new TuileCoccinelle(), new TuileScarabe(), new TuileMyrtille(), new TuileFramboise(), new TuileMyrtille(), new TuileChenille(), new TuileFramboise(), new TuileCoccinelle(),
                new TuileScarabe(), new TuileMyrtille(), new TuileChenille(), new TuileChampigon(), new TuileChenille(), new TuileChampigon(), new TuileScarabe(), new TuileCoccinelle(), new TuileChenille(), new TuileChampigon(), new TuileMyrtille(), new Tuile(false),
                new Tuile(false), new TuileFramboise(), new TuileScarabe(), new TuileMyrtille(), new TuileMyrtille(), new TuileChenille(), new TuileFramboise(), new TuileMyrtille(), new TuileCoccinelle(), new TuileFramboise(), new TuileScarabe(),
                new TuileCoccinelle(), new TuileChampigon(), new TuileCoccinelle(), new TuileChampigon(), new TuileFramboise(), new TuileCoccinelle(), new TuileChampigon(), new TuileMyrtille(),
                new TuileScarabe(), new TuileScarabe(), new TuileFramboise(), new TuileChenille(),
                new TuileChenille(), new Tuile(false), new TuileCoccinelle()};
        int i=0;

        i = remplissageLigne(3,647,130,tabTuile,i);
        System.out.println(i);
        i = remplissageLigne(4,610,152,tabTuile,i);
        i = remplissageLigne(8, 572,174,tabTuile,i);
        i = remplissageLigne(11, 452,153,tabTuile,i);
        i = remplissageLigne(12,413,175,tabTuile,i);
        i = remplissageLigne(12,375,197,tabTuile,i);
        i = remplissageLigne(11,375,242,tabTuile,i);
        i = remplissageLigne(11,374,286,tabTuile,i);
        i = remplissageLigne(11,373,333,tabTuile,i);
        i = remplissageLigne(12,334,356,tabTuile,i);
        i = remplissageLigne(11,296,377,tabTuile,i);

        i = remplissageLigne(12,257.5,400,tabTuile,i);

        i = remplissageLigne(8,296,466,tabTuile,i);
        i = remplissageLigne(4,413,580,tabTuile,i);
        i = remplissageLigne(3, 413, 624, tabTuile,i);

        //Tuile a  = new TuileMyrtille();
        //a.setPosX(490);
        //a.setPosY(669);
        //listeRessourcesDispo.add(a);
        //listeRessourcesDispo.add(new Tuile(649,130));

    }

    private int remplissageLigne(int nbrRepetition, double posXDepart, double posYDepart, Tuile[] tabTuile, int cpttab){
        double posXmod = posXDepart;
        double posYmod = posYDepart;
        for (int y = 0; y <nbrRepetition; y++){
           // if (tabTuile[cpttab].isTuileRessource()) {
                tabTuile[cpttab].setPosX(posXmod);
                tabTuile[cpttab].setPosY(posYmod);
                posXmod = posXmod +38.5;
                posYmod = posYmod +22;
                listeRessourcesDispo.add(tabTuile[cpttab]);
                cpttab++;
         //  }

        }
        return cpttab;
    }
}

