package jeu.ObjetJeu.Fourmi;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fourmi {
    public ImageView imageFourmi;

    public Fourmi(Image imageFourmi ) {
        this.imageFourmi = new ImageView(imageFourmi);
    }


    @Override
    public String toString() {
        return "Fourmi{}";
    }
}
