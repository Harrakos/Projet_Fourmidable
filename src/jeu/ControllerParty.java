package jeu;

import javafx.event.EventHandler;
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

public class ControllerParty {
    public Model model;
    private ViewParty viewParty;

    private boolean fourmiSelec = false;
    private Fourmi fourmiClique = null;
    private boolean surPlateau = true;

    private Image plateau = new Image("jeu/Images/plateau.jpeg");
    private BackgroundImage bk_image_plateau = new BackgroundImage(plateau, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    private Image terrier = new Image("jeu/Images/plateau_indi.jpg");
    private BackgroundImage bk_image_terrier = new BackgroundImage(terrier, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    ControllerParty(Model model, ViewParty viewParty) {
        this.model = model;
        this.viewParty = viewParty;
    }


    void lancer_parti() {
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
            }
            surPlateau = true;
        }
    }

    public void deplacer_fourmi(MouseEvent event) {
        // condition qui veut dire que si aucune fourmi n'a été sélectionner ou si on en séléctionné une mais qu'on reclique dessus il ne se passe rien
        if ((fourmiClique != null) && !((event.getX() > fourmiClique.imageFourmi.getX() && event.getX() < fourmiClique.imageFourmi.getX() + 25) && (event.getY() > fourmiClique.imageFourmi.getY() && event.getY() < fourmiClique.imageFourmi.getY() + 25))) {
            if (surPlateau) {
                for (Tuile r : model.getListeRessourcesDispo()) {
                    if (r.isTuileRessource() || r.getNomDuPossedeur().equals(model.getCurrentPlayer().getPseudo())) {
                        //on regarde si notre clique est sur l'une des tuiles disponible
                        if (Math.pow(event.getX() - r.getPosX(), 2) + (Math.pow(event.getY() - r.getPosY(), 2)) < Math.pow(r.getRayon(), 2)) {
                            if (r.getPosX() > fourmiClique.getX() && r.getPosY() > fourmiClique.getY()) {
                                //on regarde si le clique est à trois tuiles max de la fourmi
                                if (Math.pow((r.getPosX()) - fourmiClique.getX(), 2) + Math.pow((r.getPosY()) - fourmiClique.getY(), 2) < Math.pow(160, 2)) {
                                    mouvement_fourmi(r);
                                    passerTour();
                                }
                            } else if (r.getPosX() > fourmiClique.getX() && r.getPosY() < fourmiClique.getY()) { // vers le haut a gauche
                                //on regarde si le clique est à trois tuiles max de la fourmi
                                if (Math.pow((r.getPosX() + 15.5) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() - 11.5) - fourmiClique.getY(), 2) < Math.pow(160, 2)) {
                                    mouvement_fourmi(r);
                                    passerTour();
                                }
                            } else if (r.getPosX() < fourmiClique.getX() && r.getPosY() < fourmiClique.getY()) {
                                //on regarde si le clique est à trois tuiles max de la fourmi
                                if (Math.pow((r.getPosX() - 20) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() - 15) - fourmiClique.getY(), 2) < Math.pow(160, 2)) {
                                    mouvement_fourmi(r);
                                    passerTour();
                                }
                            } else if (r.getPosX() < fourmiClique.getX() && r.getPosY() > fourmiClique.getY()) {
                                //on regarde si le clique est à trois tuiles max de la fourmi
                                if (Math.pow((r.getPosX() - 20) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() + 11.5) - fourmiClique.getY(), 2) < Math.pow(160, 2)) {
                                    mouvement_fourmi(r);
                                    passerTour();
                                }
                            }
                        }
                    }
                }
            } else {
                if (Math.pow(event.getX() - 288, 2) + (Math.pow(event.getY() - 42, 2)) < Math.pow(20, 2)) {
                    fourmiClique.setX(model.getCurrentPlayer().getPositionTerrierJoueur()[0]);
                    fourmiClique.setY(model.getCurrentPlayer().getPositionTerrierJoueur()[1]);
                    viewParty.p.getChildren().remove(fourmiClique.imageFourmi);
                    model.sortieTerrier(fourmiClique);
                    changerVueTerrierPlateau();
                }
            }
        }
    }
    private void mouvement_fourmi(Tuile r) {
        // Deplacement de la fourmi
        fourmiClique.setX(r.getPosX());
        fourmiClique.setY(r.getPosY());
        // ajout de la tuile dans la liste ressource du joueur si personne n'est déjà passé dessus
        if (r.isTuileRessource()) {
            r.setNomDuPossedeur(model.getCurrentPlayer().getPseudo());
            if (fourmiClique.recupere(r)) {
                model.getCurrentPlayer().getListeRessource().add(r);
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
            for (Tuile r : model.getListeRessourcesDispo() ) {
                if (r.isTuileRessource() || r.getNomDuPossedeur().equals(model.getCurrentPlayer().getPseudo())) {

                    if (r.getPosX() > fourmiClique.getX() && r.getPosY() > fourmiClique.getY()) { // vers le haut a droite
                        if (Math.pow((r.getPosX()) - fourmiClique.getX(), 2) + Math.pow((r.getPosY()) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            viewParty.p.getChildren().add(r.surbrillance);
                        }
                    }
                    if (r.getPosX() > fourmiClique.getX() && r.getPosY() < fourmiClique.getY()) { // vers le haut a gauche
                        if (Math.pow((r.getPosX() + 15.5) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() - 11.5) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            viewParty.p.getChildren().add(r.surbrillance);
                        }
                    }
                    if (r.getPosX() < fourmiClique.getX() && r.getPosY() < fourmiClique.getY()) {
                        if (Math.pow((r.getPosX() - 20) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() - 15) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            viewParty.p.getChildren().add(r.surbrillance);
                        }
                    }
                    if (r.getPosX() < fourmiClique.getX() && r.getPosY() > fourmiClique.getY()) {
                        if (Math.pow((r.getPosX() - 20) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() + 11.5) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            viewParty.p.getChildren().add(r.surbrillance);
                        }
                    }
                }
            }
        }else {
            fourmiClique = f;
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


        model.getListeInsectesPasEncoreJoue().remove(fourmiClique);

        model.getListeInsectesDejaJoue().add(fourmiClique);


        if (model.getListeInsectesPasEncoreJoue().isEmpty()){
            model.getListeInsectesPasEncoreJoue().addAll(model.getListeInsectesDejaJoue());
            model.getListeInsectesDejaJoue().clear();
        }
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





