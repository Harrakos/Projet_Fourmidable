package jeu;

import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Joueur;
import jeu.ObjetJeu.Objectif.Objectif;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileChenille;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileCoccinelle;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileScarabe;
import jeu.ObjetJeu.Ressource.RessourceFermiere.TuileChampigon;
import jeu.ObjetJeu.Ressource.RessourceFermiere.TuileFramboise;
import jeu.ObjetJeu.Ressource.Tuile;
import jeu.ObjetJeu.Ressource.RessourceFermiere.TuileMyrtille;
import java.util.ArrayList;
import java.util.Iterator;

class Model {

    private int nbreJoueurs;
    ArrayList<Joueur> listeJoueurs;
    private Joueur currentPlayer;
    private ArrayList<Tuile> listeRessourcesDispo;
    private ArrayList<Fourmi> listeFourmisPlateau;
    private ArrayList<Fourmi> listeInsectesDejaJoue;
    private ArrayList<Fourmi> listeInsectesPasEncoreJoue;

    Model(){
        nbreJoueurs = 0;
        listeJoueurs = new ArrayList<>();
        listeFourmisPlateau = new ArrayList<>();
        remplissagelisteRessourcesDispo();
        listeInsectesDejaJoue = new ArrayList<>();
        listeInsectesPasEncoreJoue = new ArrayList<>();
    }

    int getNbreJoueurs() {
        return nbreJoueurs;
    }

    void setNbreJoueurs(int nbreJoueurs) {
        this.nbreJoueurs = nbreJoueurs;
    }

    Joueur getCurrentPlayer() {
        return currentPlayer;
    }

    void setCurrentPlayer(Joueur currentPlayer) {
        if (currentPlayer == null) {
            this.currentPlayer = listeJoueurs.get(0);
        } else {
            this.currentPlayer = currentPlayer;
        }
    }

    ArrayList<Tuile> getListeRessourcesDispo() {
        return listeRessourcesDispo;
    }

    ArrayList<Fourmi> getListeFourmisPlateau() { return listeFourmisPlateau; }

    ArrayList<Fourmi> getListeInsectesPasEncoreJoue() {
        return listeInsectesPasEncoreJoue;
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
       remplissageLigne(3, 413, 624, tabTuile,i);


    }

    private int remplissageLigne(int nbrRepetition, double posXDepart, double posYDepart, Tuile[] tabTuile, int cpttab){
        double posXmod = posXDepart;
        double posYmod = posYDepart;
        for (int y = 0; y <nbrRepetition; y++){
                tabTuile[cpttab].setPosX(posXmod);
                tabTuile[cpttab].setPosY(posYmod);
                posXmod = posXmod +38.5;
                posYmod = posYmod +22;
                listeRessourcesDispo.add(tabTuile[cpttab]);
                cpttab++;
        }
        return cpttab;
    }

    void nouveauJoueur() {
        if (listeJoueurs.indexOf(currentPlayer) < nbreJoueurs-1) {
            currentPlayer = listeJoueurs.get(listeJoueurs.indexOf(currentPlayer) + 1);
        }else {
            currentPlayer = listeJoueurs.get(0);
        }
    }

    void sortieTerrier(Fourmi fourmiClique) {
        currentPlayer.getListFourmiTerrier().remove(fourmiClique);
        listeFourmisPlateau.add(fourmiClique);
    }

    void endormissementFourmi(Fourmi fourmiClique) {
        listeInsectesPasEncoreJoue.remove(fourmiClique);
        listeInsectesDejaJoue.add(fourmiClique);

        if (listeInsectesPasEncoreJoue.isEmpty()){
           listeInsectesPasEncoreJoue.addAll(listeInsectesDejaJoue);
           listeInsectesDejaJoue.clear();
        }
    }

    boolean miseAjourResscource() {
        int[] tabREssourceUtilise = new int[3];
        int[] tab = currentPlayer.getTabNbrRessource();
        //Iterator<Objectif> io = currentPlayer.getListeObjectif().listIterator();
        Objectif o;
        for (int i = 0; i< currentPlayer.getListeObjectif().size(); i++){
            o = currentPlayer.getListeObjectif().get(i);
            switch (o.getTypeObjectif()) {
                case 0:
                    tabREssourceUtilise = o.setMessage(currentPlayer.getTabNbrRessource()[0], currentPlayer.getTabNbrRessource()[1], currentPlayer.getTabNbrRessource()[2]);
                    if (o.isAccompli()) {
                        currentPlayer.getListeObjectif().remove(o);
                        currentPlayer.getTabNbrRessource()[0] -= tabREssourceUtilise[0];
                        currentPlayer.getTabNbrRessource()[1] -= tabREssourceUtilise[1];
                        currentPlayer.getTabNbrRessource()[2] -= tabREssourceUtilise[2];
                    }
                    break;
                case 1:
                    o.setMessage(currentPlayer.getTabNbrRessource()[6], currentPlayer.getTabNbrRessource()[7], currentPlayer.getTabNbrRessource()[8]);
                    if (o.isAccompli()) {
                        currentPlayer.getListeObjectif().remove(o);
                        currentPlayer.getTabNbrRessource()[3] -= tabREssourceUtilise[0];
                        currentPlayer.getTabNbrRessource()[4] -= tabREssourceUtilise[1];
                        currentPlayer.getTabNbrRessource()[5] -= tabREssourceUtilise[2];
                    }
                    break;
                case 2:
                    o.setMessage(currentPlayer.getTabNbrRessource()[3], currentPlayer.getTabNbrRessource()[4], currentPlayer.getTabNbrRessource()[5]);
                    if (o.isAccompli()) {
                        currentPlayer.getListeObjectif().remove(o);
                        currentPlayer.getTabNbrRessource()[6] -= tabREssourceUtilise[0];
                        currentPlayer.getTabNbrRessource()[7] -= tabREssourceUtilise[1];
                        currentPlayer.getTabNbrRessource()[8] -= tabREssourceUtilise[2];
                    }
                    break;
            }
        }
        return currentPlayer.getListeObjectif().size() == 0;
    }
}

