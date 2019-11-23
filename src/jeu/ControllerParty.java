package jeu;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;

public class ControllerParty {
    public Model model;
    private ViewParty viewParty;

    ControllerParty(Model model, ViewParty viewParty) {
        this.model = model;
        this.viewParty = viewParty;
    }


    void lancer_parti(){
        Image plateau = new Image("jeu/Images/plateau.jpeg");
        BackgroundImage bk_image = new BackgroundImage(plateau,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bk = new Background(bk_image);




        Label test = new Label("je ne suis qu'un test pour tester, le nombre de joueur est de : "+model.getNbreJoueurs());
        viewParty.p.getChildren().clear();
        viewParty.p.setBackground(bk);
        viewParty.p.getChildren().add(test);
        viewParty.p.getScene().getWindow().setHeight(680);
        viewParty.p.getScene().getWindow().setWidth(950);
    }
}