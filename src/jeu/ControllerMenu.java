package jeu;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jeu.ObjetJeu.*;
import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Fourmi.FourmiChasseuse;
import jeu.ObjetJeu.Fourmi.FourmiCreuseuse;
import jeu.ObjetJeu.Fourmi.FourmiFermiere;
import jeu.ObjetJeu.Objectif.ObjectifChasse;
import jeu.ObjetJeu.Objectif.ObjectifCreuseur;
import jeu.ObjetJeu.Objectif.ObjectifFermier;

import java.io.IOException;


public class ControllerMenu implements EventHandler {
    private static Model model;
    private static View view;
    private static int joueurEnSelection =0;
    private Fourmi fourmi;

    public Pane paneMenu;
    public Button btn_play;
    public Button btn_rules;
    public Button btn_option;
    public Button btn_quit;
    public Button btn_retour;
    public Button btn_deux_joueurs;
    public Button btn_trois_joueurs;
    public Button btn_quatre_joueurs;
    public Button btn_cinq_joueurs;
    public Button btn_six_joueurs;
    public Button btn_launch_game;

    public TextField label_joueur1;
    public TextField label_joueur2;
    public TextField label_joueur3;
    public TextField label_joueur4;
    public TextField label_joueur5;
    public TextField label_joueur6;

    public ColorPicker color_picker1;
    public ColorPicker color_picker2;
    public ColorPicker color_picker3;
    public ColorPicker color_picker4;
    public ColorPicker color_picker5;
    public ColorPicker color_picker6;
    public Label pseudo;

    public Button btn_objectif_chasse;
    public Button btn_objectif_creuser;
    public Button btn_objectif_fermier;
    public Button btn_fourmi_chasseuse;
    public Button btn_fourmi_creuseuse;
    public Button btn_fourmi_fermiere;
    public Button btn_suivant;

    public Label cpt_objectif_chasse;
    public Label cpt_objectif_creuseur;
    public Label cpt_objectif_fermier;
    public Label cpt_fourmi_chasseuse;
    public Label cpt_fourmi_creuseuse;
    public Label cpt_fourmi_fermiere;
    public Label cpt_fourmi_total;
    public Label cpt_objectif_total;

    private int nbr_objectif_total = 0;
    private int nbr_fourmi_total = 0;


    void initialize(){}


    private void initData(String c_pseudo){
        pseudo.setText(c_pseudo);
    }


    public ControllerMenu(){}

    public ControllerMenu(Model model, View view ) {
        ControllerMenu.view = view;
        ControllerMenu.model = model;
    }


    public void pressButtonMenu(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == btn_play) {
            changeScene("Menu/SetupGame.fxml", btn_play);
        }

        if (actionEvent.getSource() == btn_rules) {
            changeScene("Menu/Rules.fxml", btn_play);
        }

        if (actionEvent.getSource() == btn_option) {
            changeScene("Menu/Options.fxml", btn_option);
        }

        if (actionEvent.getSource() == btn_quit) {
            Stage stage = (Stage) btn_quit.getScene().getWindow();
            stage.close();
        }

        if (actionEvent.getSource() == btn_retour) {
            changeScene("Menu/Menu.fxml", btn_retour);
        }

        //////////////////////// Selection nombres de joueurs ////////////////////////////////////////////////////
    }
    public void pressButtonSelectbJoueurs(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == btn_deux_joueurs){
            model.setNbreJoueurs(2);
            changeScene("Menu/SelectionFourmi/Deux_joueurs.fxml",btn_deux_joueurs);
        }

        if (actionEvent.getSource() == btn_trois_joueurs){
            model.setNbreJoueurs(3);
            changeScene("Menu/SelectionFourmi/Trois_joueurs.fxml",btn_trois_joueurs);
        }

        if (actionEvent.getSource() == btn_quatre_joueurs){
            model.setNbreJoueurs(4);
            changeScene("Menu/SelectionFourmi/Quatres_joueurs.fxml",btn_quatre_joueurs);
        }

        if (actionEvent.getSource() == btn_cinq_joueurs){
            model.setNbreJoueurs(5);
            changeScene("Menu/SelectionFourmi/Cinq_joueurs.fxml",btn_cinq_joueurs);
        }

        if (actionEvent.getSource() == btn_six_joueurs){
            model.setNbreJoueurs(6);
            changeScene("Menu/SelectionFourmi/Six_joueurs.fxml",btn_six_joueurs);
        }
        if (actionEvent.getSource() == btn_launch_game ){
            TextField[] tabPseudo = {label_joueur1,label_joueur2,label_joueur3,label_joueur4,label_joueur5,label_joueur6};
            ColorPicker[] tabColor = {color_picker1,color_picker2,color_picker3,color_picker4,color_picker5,color_picker6};
            for (int i = 0; i< model.getNbreJoueurs(); i++){
                model.listeJoueurs.add(new Joueur(tabPseudo[i].getText(),tabColor[i].getValue()));
                System.out.println(model.listeJoueurs.get(i).getPseudo() + model.listeJoueurs.get(i).getCouleur());
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/SelectionFourmi/ChoixFourmiObjectif.fxml"));
            btn_launch_game.getScene().setRoot(loader.load());
            ControllerMenu controllerMenu = loader.getController();
            controllerMenu.initData(model.listeJoueurs.get(joueurEnSelection).getPseudo());
        }
    }

    @SuppressWarnings("Duplicates")
    public void pressButtonChoixFourmiObjectif(MouseEvent mouseEvent) throws IOException {
        // à faire quand on appuie sur suivant  model.listeJoueurs.get(joueurEnSelection).getListeObjectif().add(new ObjectifFermier());
        if (mouseEvent.getSource() == btn_objectif_chasse){
            if (mouseEvent.getButton() == MouseButton.PRIMARY){
                if (nbr_objectif_total<6) {
                    nbr_objectif_total++;
                    incrementercompteur(cpt_objectif_chasse);
                    cpt_objectif_total.setText(nbr_objectif_total + "/6");
                }
            }else if (mouseEvent.getButton() == MouseButton.SECONDARY){
                if (nbr_objectif_total>0 && !cpt_objectif_chasse.getText().equals("0")){
                    nbr_objectif_total--;
                    decrementer(cpt_objectif_chasse);
                    cpt_objectif_total.setText(nbr_objectif_total + "/6");
                }
            }
        }
        if (mouseEvent.getSource() == btn_objectif_creuser){
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                if (nbr_objectif_total < 6) {
                    nbr_objectif_total++;
                    incrementercompteur(cpt_objectif_creuseur);
                    cpt_objectif_total.setText(nbr_objectif_total + "/6");
                }
            }else if (mouseEvent.getButton() == MouseButton.SECONDARY){
                if (nbr_objectif_total>0 && !cpt_objectif_creuseur.getText().equals("0")){
                    nbr_objectif_total--;
                    decrementer(cpt_objectif_creuseur);
                    cpt_objectif_total.setText(nbr_objectif_total + "/6");
                }
            }
        }
        if (mouseEvent.getSource() == btn_objectif_fermier){
            if (mouseEvent.getButton() == MouseButton.PRIMARY){
                if (nbr_objectif_total<6) {
                    nbr_objectif_total++;
                    incrementercompteur(cpt_objectif_fermier);
                    cpt_objectif_total.setText(nbr_objectif_total + "/6");
                }
            }else if (mouseEvent.getButton() == MouseButton.SECONDARY){
                if (nbr_objectif_total>0 && !cpt_objectif_fermier.getText().equals("0")){
                    nbr_objectif_total--;
                    decrementer(cpt_objectif_fermier);
                    cpt_objectif_total.setText(nbr_objectif_total + "/6");
                }
            }
        }

        if (mouseEvent.getSource() == btn_fourmi_chasseuse){
            if (mouseEvent.getButton() == MouseButton.PRIMARY){
                if (nbr_fourmi_total<3) {
                    nbr_fourmi_total++;
                    incrementercompteur(cpt_fourmi_chasseuse);
                    cpt_fourmi_total.setText(nbr_fourmi_total + "/3");
                }
            }else if (mouseEvent.getButton() == MouseButton.SECONDARY){
                if (nbr_fourmi_total>0 && !cpt_fourmi_chasseuse.getText().equals("0")){
                    nbr_fourmi_total--;
                    decrementer(cpt_fourmi_chasseuse);
                    cpt_fourmi_total.setText(nbr_fourmi_total + "/3");
                }
            }

        }
        if (mouseEvent.getSource() == btn_fourmi_creuseuse){
            if (mouseEvent.getButton() == MouseButton.PRIMARY){
                if (nbr_fourmi_total<3) {
                    nbr_fourmi_total++;
                    incrementercompteur(cpt_fourmi_creuseuse);
                    cpt_fourmi_total.setText(nbr_fourmi_total + "/3");
                }
            }else if (mouseEvent.getButton() == MouseButton.SECONDARY){
                if (nbr_fourmi_total>0 && !cpt_fourmi_creuseuse.getText().equals("0")){
                    nbr_fourmi_total--;
                    decrementer(cpt_fourmi_creuseuse);
                    cpt_fourmi_total.setText(nbr_fourmi_total + "/3");
                }
            }
        }
        if (mouseEvent.getSource() == btn_fourmi_fermiere){
            if (mouseEvent.getButton() == MouseButton.PRIMARY){
                if (nbr_fourmi_total<3) {
                    nbr_fourmi_total++;
                    incrementercompteur(cpt_fourmi_fermiere);
                    cpt_fourmi_total.setText(nbr_fourmi_total + "/3");
                }
            }else if (mouseEvent.getButton() == MouseButton.SECONDARY){
                if (nbr_fourmi_total>0 && !cpt_fourmi_fermiere.getText().equals("0")){
                    nbr_fourmi_total--;
                    decrementer(cpt_fourmi_fermiere);
                    cpt_fourmi_total.setText(nbr_fourmi_total + "/3");
                }
            }
        }

        if (mouseEvent.getSource() == btn_suivant){
            if (joueurEnSelection<model.getNbreJoueurs()-1){
                Joueur joueur;
                joueur = model.listeJoueurs.get(joueurEnSelection);
                for (int i = 0; i < Integer.parseInt(cpt_objectif_chasse.getText()); i++)
                    joueur.getListeObjectif().add(new ObjectifChasse());
                for (int i = 0; i < Integer.parseInt(cpt_objectif_creuseur.getText()); i++)
                    joueur.getListeObjectif().add(new ObjectifCreuseur());
                for (int i = 0; i < Integer.parseInt(cpt_objectif_fermier.getText()); i++)
                    joueur.getListeObjectif().add(new ObjectifFermier());

                for (int i = 0; i < Integer.parseInt(cpt_fourmi_chasseuse.getText()); i++){
                    fourmi = new FourmiChasseuse(new Image("jeu/Images/fourmi.png"));
                    joueur.getListeFourmi().add(fourmi);
                    joueur.getListFourmiTerrier().add(fourmi);
                }
                for (int i = 0; i < Integer.parseInt(cpt_fourmi_creuseuse.getText()); i++){
                    fourmi = new FourmiCreuseuse(new Image("jeu/Images/fourmi.png"));
                    joueur.getListeFourmi().add(fourmi);
                    joueur.getListFourmiTerrier().add(fourmi);
                }
                for (int i = 0; i < Integer.parseInt(cpt_fourmi_fermiere.getText()); i++){
                    fourmi = new FourmiFermiere(new Image("jeu/Images/fourmi.png"));
                    joueur.getListeFourmi().add(fourmi);
                    joueur.getListFourmiTerrier().add(fourmi);
                }
                for (int i =0; i<3; i++){
                    model.listeJoueurs.get(joueurEnSelection).getListeFourmi().get(i).setX(287);
                    model.listeJoueurs.get(joueurEnSelection).getListeFourmi().get(i).setY(84+40*i);
                }
                joueurEnSelection++;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/SelectionFourmi/ChoixFourmiObjectif.fxml"));
                btn_suivant.getScene().setRoot(loader.load());
                ControllerMenu controllerMenu = loader.getController();
                controllerMenu.initData(model.listeJoueurs.get(joueurEnSelection).getPseudo());
            }else{
                btn_suivant.getScene().setRoot(view.viewParty.p);
            }


        }





    }


        private void changeScene(String url, Button bouton) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        bouton.getScene().setRoot(root);
    }
        private void incrementercompteur(Label cpt){
            int nbr_actu = 0;
            nbr_actu = Integer.parseInt(cpt.getText()) + 1;
            cpt.setText(String.valueOf(nbr_actu));

        }
        private void decrementer(Label cpt){
            int nbr_actu=0;
            nbr_actu = Integer.parseInt(cpt.getText()) - 1;
            cpt.setText(String.valueOf(nbr_actu));

        }

    @Override
    public void handle(Event event) {

    }
}
