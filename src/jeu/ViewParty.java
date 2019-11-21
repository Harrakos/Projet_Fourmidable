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


    private Model modelParty;
    AnchorPane p = new AnchorPane();

    public Button lancerbtn;

    public ViewParty() {
        lancerbtn = new Button( "co");


        lancerbtn.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        System.out.println("coucou");
                    }
                });

       p.getChildren().add(lancerbtn);
    }
}
