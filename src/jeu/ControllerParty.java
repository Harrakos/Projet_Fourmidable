package jeu;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ControllerParty {
    public Model model;
    private ViewParty viewParty;

    public ControllerParty(Model model, ViewParty viewParty) {
        model = model;
        viewParty = viewParty;
    }

    public void pressButtonJeu(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == viewParty.lancerbtn){
            System.out.println("cocuo la game est lancer");
        }
    }
}