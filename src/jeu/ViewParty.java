package jeu;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;

public class ViewParty{


    ControllerParty controllerParty;
    private Model model;
    AnchorPane p = new AnchorPane();

    public Button lancerbtn;

    public ViewParty(Model model) {
        this.model = model;
        lancerbtn = new Button("cooucou les bgs");




        controllerParty = new ControllerParty(model,this);
        //lancerbtn.addEventHandler();



    }
}
