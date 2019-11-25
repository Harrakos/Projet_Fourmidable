package jeu;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jeu.ObjetJeu.Objectif;

import javax.swing.*;
import java.io.IOException;

public class ControllerParty {
    public Model model;
    private ViewParty viewParty;

    private Image plateau = new Image("jeu/Images/plateau.jpeg");
    private BackgroundImage bk_image_plateau = new BackgroundImage(plateau,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    private Image terrier = new Image("jeu/Images/plateau_indi.jpg");
    private BackgroundImage bk_image_terrier = new BackgroundImage(terrier,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    ControllerParty(Model model, ViewParty viewParty) {
        this.model = model;
        this.viewParty = viewParty;
    }


    void lancer_parti(){
        viewParty.p.getChildren().clear();
        viewParty.p.getScene().getWindow().setHeight(680);
        viewParty.p.getScene().getWindow().setWidth(950);
        viewParty.p.setBackground(new Background(bk_image_plateau));


        viewParty.ajoutAttribut();

        model.setCurrentPlayer(model.listeJoueurs.get(0));
        viewParty.nom_joueur = new Label(model.getCurrentPlayer().getPseudo());
        viewParty.positionnerXY(viewParty.nom_joueur,30,10);
        viewParty.p.getChildren().add(viewParty.nom_joueur);


        viewParty.liste_objectif = new Label("Objectif : \n");
        for (Objectif o : model.getCurrentPlayer().getListeObjectif()) {
            viewParty.liste_objectif.setText(viewParty.liste_objectif.getText()+o+"\n \n");
        }

        viewParty.positionnerXY( viewParty.liste_objectif,40,50);
        viewParty.p.getChildren().add(viewParty.liste_objectif);


    }

    public void changerVueTerrierPlateau(){
        if (viewParty.p.getBackground().getImages().get(0).equals(bk_image_plateau)){
            viewParty.p.setBackground(new Background(bk_image_terrier));
            viewParty.p.getChildren().remove(viewParty.rectangle_objectif);
            viewParty.p.getChildren().remove(viewParty.liste_objectif);

        }
        else{
            viewParty.p.setBackground(new Background(bk_image_plateau));
            viewParty.p.getChildren().add(viewParty.rectangle_objectif);
            viewParty.p.getChildren().add(viewParty.liste_objectif);

        }

    }





}