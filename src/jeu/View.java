package jeu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class View {
    public ViewMenu viewMenu;
    public ViewParty viewParty;

    public View(){
        viewMenu = new ViewMenu();
        viewParty = new ViewParty();
    }

    public Scene getScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu/Menu.fxml"));
        return new Scene(root, 600, 600);
    }
}

