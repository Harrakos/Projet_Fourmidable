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
        viewParty.p.getScene().getWindow().setWidth(1143);
        viewParty.p.getScene().getWindow().setHeight(800);
        viewParty.p.setBackground(new Background(bk_image_plateau));

        viewParty.ajoutAttribut();

        model.setCurrentPlayer(model.listeJoueurs.get(0));
        viewParty.nom_joueur = new Label(model.getCurrentPlayer().getPseudo());
        viewParty.positionnerXY(viewParty.nom_joueur, 30, 10);
        viewParty.p.getChildren().add(viewParty.nom_joueur);

        viewParty.liste_objectif = new Label("Objectif : \n");
        for (Objectif o : model.getCurrentPlayer().getListeObjectif()) {
            viewParty.liste_objectif.setText(viewParty.liste_objectif.getText() + o + "\n \n");
        }
        viewParty.positionnerXY(viewParty.liste_objectif, 40, 50);
        viewParty.p.getChildren().add(viewParty.liste_objectif);


        //test
        model.getCurrentPlayer().getListeFourmi().get(0).setX(600);
        model.getCurrentPlayer().getListeFourmi().get(0).setY(600);

        model.listeJoueurs.get(4).getListeFourmi().get(1).setX(800);
        model.listeJoueurs.get(4).getListeFourmi().get(1).setY(600);

        for (Fourmi f: model.getCurrentPlayer().getListeFourmi()) {
            f.imageFourmi.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    selectionFourmi(event,f);
                }
            });
        }
        viewParty.p.getChildren().add(model.getCurrentPlayer().getListeFourmi().get(0).imageFourmi);
        System.out.println(model.listeJoueurs);
        viewParty.p.getChildren().add(model.listeJoueurs.get(4).getListeFourmi().get(1).imageFourmi);

    }

    public void changerVueTerrierPlateau() {
        if (viewParty.p.getBackground().getImages().get(0).equals(bk_image_plateau)) {
            viewParty.p.setBackground(new Background(bk_image_terrier));
            viewParty.p.getChildren().remove(viewParty.rectangle_objectif);
            viewParty.p.getChildren().remove(viewParty.liste_objectif);
        } else {
            viewParty.p.setBackground(new Background(bk_image_plateau));
            viewParty.p.getChildren().add(viewParty.rectangle_objectif);
            viewParty.p.getChildren().add(viewParty.liste_objectif);
        }
    }

    public void deplacer_fourmi(MouseEvent event) {
        if (fourmiSelec) {
            for (Tuile r : model.getListeRessourcesDispo()) {
                if (Math.pow(event.getX() - r.getPosX(), 2) + (Math.pow(event.getY() - r.getPosY(), 2)) < Math.pow(r.getRayon(), 2)) {
                    if (r.getPosX() > fourmiClique.getX() && r.getPosY() > fourmiClique.getY()) { // vers le haut a droite
                        if (Math.pow((r.getPosX()) - fourmiClique.getX(), 2) + Math.pow((r.getPosY()) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            mouvement_fourmi(r);
                        }
                    }
                    if (r.getPosX() > fourmiClique.getX() && r.getPosY() < fourmiClique.getY()) { // vers le haut a gauche
                        if (Math.pow((r.getPosX() + 15.5) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() - 11.5) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            mouvement_fourmi(r);
                        }
                    }
                    if (r.getPosX() < fourmiClique.getX() && r.getPosY() < fourmiClique.getY()) {
                        if (Math.pow((r.getPosX() - 15.5) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() - 11.5) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            mouvement_fourmi(r);
                        }
                    }
                    if (r.getPosX() < fourmiClique.getX() && r.getPosY() > fourmiClique.getY()) {
                        if (Math.pow((r.getPosX() - 15.5) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() + 11.5) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                            mouvement_fourmi(r);
                        }
                    }

                }
            }

            //fourmiSelec = false;
        }
    }

    private void mouvement_fourmi(Tuile r) {
        fourmiClique.setX(r.getPosX());
        fourmiClique.setY(r.getPosY());
        System.out.println(r);
        //for (Tuile t : model.getListeRessourcesDispo()) {
       //     viewParty.p.getChildren().remove(t.surbrillance);
      //  }
    }

    private void selectionFourmi(MouseEvent event, Fourmi f){
        {
            for (Tuile r : model.getListeRessourcesDispo()) {
                viewParty.p.getChildren().remove(r.surbrillance);
            }
            fourmiClique = f;
            fourmiSelec = true;
            for (Tuile r : model.getListeRessourcesDispo()) {
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
                    if (Math.pow((r.getPosX() - 15.5) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() - 11.5) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                        viewParty.p.getChildren().add(r.surbrillance);
                    }
                }
                if (r.getPosX() < fourmiClique.getX() && r.getPosY() > fourmiClique.getY()) {
                    if (Math.pow((r.getPosX() - 15.5) - fourmiClique.getX(), 2) + Math.pow((r.getPosY() + 11.5) - fourmiClique.getY(), 2) < Math.pow(162, 2)) {
                        viewParty.p.getChildren().add(r.surbrillance);
                    }
                }

            }
        }

    }

}





