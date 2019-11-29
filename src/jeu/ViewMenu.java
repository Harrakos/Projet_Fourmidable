package jeu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewMenu {

    public Scene getScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu/Menu.fxml"));
        return new Scene(root, 400, 600);
    }

}
