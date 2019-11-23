package jeu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ViewParty{


    private ControllerParty controllerParty;
    private Model model;
    AnchorPane p = new AnchorPane();

    public Button lancerbtn;

    public ViewParty(Model model) {
        this.model = model;
        lancerbtn = new Button("cooucou les bgs");

        p.getChildren().add(lancerbtn);




        controllerParty = new ControllerParty(model,this);
        lancerbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { controllerParty.lancer_parti();}
        });


    }
}
