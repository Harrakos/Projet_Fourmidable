package jeu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class View {
    private ViewMenu viewMenu;
    ViewParty viewParty;
    private Model model;

    public View(Model model){
        viewMenu = new ViewMenu();
        viewParty = new ViewParty(model);
    }

    public Scene getScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu/Menu.fxml"));
        return new Scene(root, 600, 400);
    }
}

