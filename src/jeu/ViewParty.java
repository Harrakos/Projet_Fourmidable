package jeu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jeu.ObjetJeu.Fourmi.FourmiChasseuse;
import org.w3c.dom.ls.LSOutput;

import java.awt.event.MouseListener;

public class ViewParty {


    AnchorPane p;
    Button changerVue;
    Label nom_joueur;
    Rectangle rectangle_joueur;
    Background bk;
    Rectangle rectangle_objectif;
    Label liste_objectif;
    private ControllerParty controllerParty;
    private Model model;
    private TextField xField;
    private Button lancerbtn;

    //test
    ViewParty(Model model) {
        this.model = model;
        p = new AnchorPane();

        initAttribut();
        p.getChildren().add(lancerbtn);


        //controller

        controllerParty = new ControllerParty(model,this);
        changerVue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controllerParty.changerVueTerrierPlateau();
            }
        });

        lancerbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controllerParty.lancer_parti();
            }
        });
        p.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { controllerParty.deplacer_fourmi(event);
            }
        });
    }

    private void initAttribut(){
        lancerbtn = new Button("Lancer la game");
        changerVue = new Button("aller au terrier");
        rectangle_joueur = new Rectangle(80,20, Color.WHITE);
        rectangle_objectif = new Rectangle(170,300, Color.WHITE);
    }

     void ajoutAttribut(){

        positionnerXY(rectangle_joueur,25,10);
        p.getChildren().add(rectangle_joueur);

        positionnerXY(rectangle_objectif,40,50);
        p.getChildren().add(rectangle_objectif);

        positionnerXY(changerVue,900,700);
        p.getChildren().add(changerVue);

    }

    void positionnerXY(Node node, double x, double y){
        node.setTranslateX(x);
        node.setTranslateY(y);

    }
}
