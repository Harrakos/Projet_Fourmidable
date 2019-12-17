package jeu;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Fourmi.FourmiChasseuse;
import jeu.ObjetJeu.Joueur;
import jeu.ObjetJeu.Objectif.Objectif;
import jeu.ObjetJeu.Ressource.Tuile;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class ControllerParty {
    public Model model;
    private ViewParty viewParty;

    private boolean fourmiSelec = false;
    private Fourmi fourmiClique = null;
    private boolean surPlateau = true;

    private Image plateau = new Image("jeu/Images/plateau.jpeg");
    public BackgroundImage bk_image_plateau = new BackgroundImage(plateau, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    private Image terrier = new Image("jeu/Images/plateau_indi.jpg");
    public BackgroundImage bk_image_terrier = new BackgroundImage(terrier, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    ControllerParty(Model model, ViewParty viewParty) {
        this.model = model;
        this.viewParty = viewParty;
    }

    void lancer_parti() {
        model.remplissagelisteRessourcesDispo();

        viewParty.p.getChildren().clear();
        viewParty.p.getScene().getWindow().setWidth(1147);
        viewParty.p.getScene().getWindow().setHeight(836);
        viewParty.p.setBackground(new Background(bk_image_plateau));

        viewParty.ajoutAttribut();

        model.setCurrentPlayer(model.listeJoueurs.get(0));
        viewParty.nom_joueur = new Label(model.getCurrentPlayer().getPseudo());
        viewParty.positionnerXY(viewParty.nom_joueur, 30, 10);
        viewParty.p.getChildren().add(viewParty.nom_joueur);

        viewParty.liste_objectif = new Label("Objectif : \n");
        viewParty.positionnerXY(viewParty.liste_objectif, 40, 50);
        viewParty.p.getChildren().add(viewParty.liste_objectif);

        for (Objectif o : model.getCurrentPlayer().getListeObjectif()) {
            viewParty.liste_objectif.setText(viewParty.liste_objectif.getText() + o + "\n");
        }

        for (Fourmi f: model.getCurrentPlayer().getListeFourmi()) {
            f.imageFourmi.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectionFourmi(event,f);
                }
            });
        }
    }

    public void changerVueTerrierPlateau() {
        if (viewParty.p.getBackground().getImages().get(0).equals(bk_image_plateau)) {
            viewParty.p.setBackground(new Background(bk_image_terrier));
            viewParty.p.getChildren().remove(viewParty.rectangle_objectif);
            viewParty.p.getChildren().remove(viewParty.liste_objectif);
            for (Fourmi f : model.getListeFourmisPlateau()) {
                viewParty.p.getChildren().remove(f.imageFourmi);
            }

            for (Fourmi f : model.getCurrentPlayer().getListFourmiTerrier()) {
                viewParty.p.getChildren().add(f.imageFourmi);
            }

            for (Tuile r : model.getListeRessourcesDispo()){
                if (!r.isTuileRessource()){
                    viewParty.p.getChildren().remove(r.pheromone);
                }
                if (r.isTuileDetruite())
                    viewParty.p.getChildren().remove(r.detruit);
            }
            for (int x = 0; x<5; x++) {
                for (int y = 0; y < 4; y++) {
                    if (model.getCurrentPlayer().getTabMine()[x][y] !=null && !model.getCurrentPlayer().getTabMine()[x][y].isTuileRessource()){
                        viewParty.p.getChildren().add(model.getCurrentPlayer().getTabMine()[x][y].pheromone);
                    }
                }
            }

            surPlateau = false;
        } else {
            viewParty.p.setBackground(new Background(bk_image_plateau));
            viewParty.p.getChildren().add(viewParty.rectangle_objectif);
            viewParty.p.getChildren().add(viewParty.liste_objectif);
            for (Fourmi f : model.getCurrentPlayer().getListFourmiTerrier()) {
                viewParty.p.getChildren().remove(f.imageFourmi);
            }
            for (Fourmi f : model.getListeFourmisPlateau()) {
                viewParty.p.getChildren().add(f.imageFourmi);
            }
            for (Tuile r : model.getListeRessourcesDispo()){
                if (!r.isTuileRessource()){
                    viewParty.p.getChildren().add(r.pheromone);
                }
                if (r.isTuileDetruite()){
                    viewParty.p.getChildren().add(r.detruit);
                }
            }
            for (int x = 0; x<5; x++) {
                for (int y = 0; y < 4; y++) {
                    if (model.getCurrentPlayer().getTabMine()[x][y] !=null && !model.getCurrentPlayer().getTabMine()[x][y].isTuileRessource()){
                        viewParty.p.getChildren().remove(model.getCurrentPlayer().getTabMine()[x][y].pheromone);
                    }
                }
            }
            surPlateau = true;
        }
    }

    public void deplacer_fourmi(MouseEvent event) throws IOException {
        // condition qui veut dire que si aucune fourmi n'a été sélectionner ou si on en séléctionné une mais qu'on reclique dessus il ne se passe rien
        if ((fourmiClique != null) && !((event.getX() > fourmiClique.imageFourmi.getX() && event.getX() < fourmiClique.imageFourmi.getX() + 25) && (event.getY() > fourmiClique.imageFourmi.getY() && event.getY() < fourmiClique.imageFourmi.getY() + 25))) {
            if (surPlateau) {
                for (Tuile r : model.getListeRessourcesDispo()) {
                    if (Math.pow(event.getX() - r.getPosX(), 2) + (Math.pow(event.getY() - r.getPosY(), 2)) < Math.pow(r.getRayon(), 2)) {
                        if (fourmiClique.getTypeFourmi() == -1) {
                            System.out.println("coucou");
                            mouvement_fourmi(r);
                            passerTour();
                            return;
                        }
                    }
                    if (r.isTuileRessource() || r.getNomDuPossedeur().equals(model.getCurrentPlayer().getPseudo())) {
                        //on regarde si notre clique est sur l'une des tuiles disponible
                        if (Math.pow(event.getX() - r.getPosX(), 2) + (Math.pow(event.getY() - r.getPosY(), 2)) < Math.pow(r.getRayon(), 2)) {
                            if (r.isTuileRessource() || r.getNomDuPossedeur().equals(model.getCurrentPlayer().getPseudo())) {
                                if (Math.pow((r.getPosX()) - fourmiClique.getX() - 10, 2) + Math.pow((r.getPosY()) - fourmiClique.getY() - 12, 2) < Math.pow(144, 2)) {
                                    mouvement_fourmi(r);
                                    passerTour();
                                }
                            }
                        }
                    }
                }
            } else {
                if ((Math.pow(event.getX() - 288, 2) + (Math.pow(event.getY() - 42, 2)) < Math.pow(20, 2))&& fourmiClique.getTypeFourmi()!=2) {
                    fourmiClique.setX(model.getCurrentPlayer().getPositionTerrierJoueur()[0]);
                    fourmiClique.setY(model.getCurrentPlayer().getPositionTerrierJoueur()[1]);
                    viewParty.p.getChildren().remove(fourmiClique.imageFourmi);
                    model.sortieTerrier(fourmiClique);
                    changerVueTerrierPlateau();
                }else if ( fourmiClique.getTypeFourmi()==2){
                    for (int x = 0; x<5; x++) {
                        for (int y = 0; y < 4; y++) {
                            if (  model.getCurrentPlayer().getTabMine()[x][y] != null &&Math.pow(event.getX() - model.getCurrentPlayer().getTabMine()[x][y].getPosX(), 2) + (Math.pow(event.getY() - model.getCurrentPlayer().getTabMine()[x][y].getPosY(), 2)) < Math.pow(model.getCurrentPlayer().getTabMine()[x][y].getRayon(), 2)){
                                mouvement_fourmi(model.getCurrentPlayer().getTabMine()[x][y]);
                                passerTour();
                            }
                        }
                    }

                }
            }
        }
    }
    private void mouvement_fourmi(Tuile r) throws IOException {
        // Deplacement de la fourmi
        fourmiClique.setX(r.getPosX());
        fourmiClique.setY(r.getPosY());
        // ajout de la tuile dans la liste ressource du joueur si personne n'est déjà passé dessus
        if (fourmiClique.getTypeFourmi() == -1){
            r.setTuileRessource(false);
            r.setTuileDetruite(true);
            viewParty.p.getChildren().add(r.detruit);
            return;
        }
        if (r.isTuileRessource()) {
            r.setNomDuPossedeur(model.getCurrentPlayer().getPseudo());
            System.out.println(r);
            if (fourmiClique.recupere(r)) {
                switch (r.getTypeRessource()){
                    case 0:
                        model.getCurrentPlayer().getTabNbrRessource()[0]+=1;
                        break;
                    case 1:
                        model.getCurrentPlayer().getTabNbrRessource()[1]+=1;
                        break;
                    case 2:
                        model.getCurrentPlayer().getTabNbrRessource()[2]+=1;
                        break;
                    case 3:
                        model.getCurrentPlayer().getTabNbrRessource()[3]+=1;
                        break;
                    case 4:
                        model.getCurrentPlayer().getTabNbrRessource()[4]+=1;
                        break;
                    case 5:
                        model.getCurrentPlayer().getTabNbrRessource()[5]+=1;
                        break;
                    case 6:
                        model.getCurrentPlayer().getTabNbrRessource()[6]+=1;
                        break;
                    case 7:
                        model.getCurrentPlayer().getTabNbrRessource()[7]+=1;
                        break;
                    case 8:
                        model.getCurrentPlayer().getTabNbrRessource()[8]+=1;
                        break;
                }
                if(!surPlateau){
                    for (int x = 0; x<5; x++) {
                        for (int y = 0; y < 4; y++) {
                            if ( model.getCurrentPlayer().getTabMine()[x][y] != null && model.getCurrentPlayer().getTabMine()[x][y] == r){
                                if (x-1 >0)
                                    model.getCurrentPlayer().getTabMine()[x-1][y].setAccessible(true);
                                if (x+1<5)
                                    model.getCurrentPlayer().getTabMine()[x+1][y].setAccessible(true);
                                if (y-1 >0)
                                    model.getCurrentPlayer().getTabMine()[x][y-1].setAccessible(true);
                                if (y+1<4)
                                    model.getCurrentPlayer().getTabMine()[x][y+1].setAccessible(true);
                            }

                        }
                    }

                }
                if (model.miseAjourResscource()){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/Ecran_Victoire.fxml"));
                    viewParty.p.getScene().getWindow().setWidth(630);
                    viewParty.p.getScene().getWindow().setHeight(585);
                    viewParty.p.getScene().setRoot(loader.load());
                    ControllerMenu controllerMenu = loader.getController();
                    controllerMenu.initData(model.getCurrentPlayer().getPseudo());
                }
                r.setTuileRessource(false);
                viewParty.p.getChildren().add(r.pheromone);
            }
        }
    }

    private void selectionFourmi(MouseEvent event, Fourmi f){
        if (surPlateau) {
            for (Tuile r : model.getListeRessourcesDispo()) {
                viewParty.p.getChildren().remove(r.surbrillance);
            }
            fourmiClique = f;
            if (fourmiClique.getTypeFourmi() == -1){
                for (Tuile r : model.getListeRessourcesDispo()) {
                    viewParty.p.getChildren().add(r.surbrillance);
                }
            } else {
                for (Tuile r : model.getListeRessourcesDispo()) {
                    if (r.isTuileRessource() || r.getNomDuPossedeur().equals(model.getCurrentPlayer().getPseudo())) {
                        if ((Math.pow((r.getPosX()) - fourmiClique.getX() - 10, 2) + Math.pow((r.getPosY()) - fourmiClique.getY() - 12, 2)) < Math.pow(144, 2)) {
                            viewParty.p.getChildren().add(r.surbrillance);
                        }
                    }
                }
            }
        }else {
            /*for (int x = 0; x<5; x++) {
                for (int y = 0; y < 4; y++) {
                    viewParty.p.getChildren().remove(model.getCurrentPlayer().getTabMine()[x][y].surbrillance);
                }*/
            //}
            fourmiClique = f;
            if (fourmiClique.getTypeFourmi() == 2){

                for (int x = 0; x<5; x++){
                    for (int y = 0; y<4; y++){
                        if (model.getCurrentPlayer().getTabMine()[x][y] != null &&model.getCurrentPlayer().getTabMine()[x][y].isAccessible()){
                            viewParty.p.getChildren().add(model.getCurrentPlayer().getTabMine()[x][y].surbrillance);
                        }

                    }
                }
            }
        }
    }
    private void passerTour(){
        //enelèvement de la surbrillance
        for (Tuile t : model.getListeRessourcesDispo()) {
            viewParty.p.getChildren().remove(t.surbrillance);
        }
        // désactivation des fourmis du joueur
        for (Fourmi f : model.getCurrentPlayer().getListeFourmi()){
            f.imageFourmi.setOnMouseClicked(null);
        }
        if (!surPlateau) {
            changerVueTerrierPlateau();
            for (Fourmi f : model.getCurrentPlayer().getListFourmiTerrier()){
                viewParty.p.getChildren().remove(f.imageFourmi);
            }
            for (int x = 0; x<5; x++){
                for (int y = 0; y<4; y++) {
                    if (model.getCurrentPlayer().getTabMine()[x][y] != null && model.getCurrentPlayer().getTabMine()[x][y].isAccessible()){
                        viewParty.p.getChildren().remove(model.getCurrentPlayer().getTabMine()[x][y].surbrillance);
                    }
                }
            }

        }

        model.endormissementFourmi(fourmiClique);

        fourmiClique = null;

        // on selectionne le nouveau joueur si c'est le dernier joueur qui vient de jouer, on retourne au début de la liste joueur
        model.nouveauJoueur();

        // On change le pseudo et les objectifs
        viewParty.nom_joueur.setText(model.getCurrentPlayer().getPseudo());
        viewParty.liste_objectif.setText("Objectif : ");
        for (Objectif o : model.getCurrentPlayer().getListeObjectif()) {

            viewParty.liste_objectif.setText(viewParty.liste_objectif.getText() + o + "\n");

        }

        //on active les fourmis du nouveau joueur qui n'ont pas encore été joué
        for (Fourmi f1 : model.getListeInsectesPasEncoreJoue() ) {
            for (Fourmi f2: model.getCurrentPlayer().getListeFourmi()){
                if (f1 == f2) {
                    f2.imageFourmi.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            selectionFourmi(event, f2);
                        }
                    });
                }
            }
        }
    }

}
