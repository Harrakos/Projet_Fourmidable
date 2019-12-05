package jeu;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private static int[][] posTerrier = {{451,646},{687,153},{725,625},{413,175},{842,377},{296,421}};
    public Pane paneMenu;

    public Button btn_retour;

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
    public ImageView btnImageRules;
    public ImageView btnImageJouer;
    public ImageView btnImageOption;
    public ImageView btnImagesQuitter;
    public ImageView btnImageRetour;
    public ImageView btnImageDeuxJoueurs;
    public ImageView btnImageTroisJoueurs;
    public ImageView btnImagequatreJoueurs;
    public ImageView btnImageCinqJoueurs;
    public ImageView btnImageSixJoueurs;
    private Fourmi fourmi;
    private int nbr_objectif_total = 0;
    private int nbr_fourmi_total = 0;


    public ControllerMenu(){}


    public ControllerMenu(Model model, View view ) {
        ControllerMenu.view = view;
        ControllerMenu.model = model;
    }

    private void initData(String c_pseudo){
        pseudo.setText(c_pseudo);
    }

    public void pressButtonMenu(MouseEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == btnImageJouer) {
            changeScene("Menu/SetupGame.fxml", btnImageJouer);
        }

        if (actionEvent.getSource() == btnImageRules) {
            changeScene("Menu/Rules.fxml", btnImageRules);
        }

        if (actionEvent.getSource() == btnImageOption) {
            changeScene("Menu/Options.fxml", btnImageOption);
        }

        if (actionEvent.getSource() == btnImagesQuitter) {
            Stage stage = (Stage) btnImagesQuitter.getScene().getWindow();
            stage.close();
        }
        if (actionEvent.getSource() == btnImageRetour){
            changeScene("Menu/Menu.fxml",btnImageRetour);
        }
    }

    public void onMouseOver(MouseEvent mouseEvent){
        if (mouseEvent.getSource() == btnImageJouer){
            btnImageJouer.setImage(new Image("Image_Boutons/Bouton_Jouer_Mouse.png"));
            btnImageJouer.setY(btnImageJouer.getY()+2);
        }
        if (mouseEvent.getSource() == btnImageRules){
            btnImageRules.setImage(new Image("Image_Boutons/Bouton_Regles_Mouse.png"));
            btnImageRules.setY(btnImageRules.getY()+2);
        }
        if (mouseEvent.getSource() == btnImageOption){
            btnImageOption.setImage(new Image("Image_Boutons/Bouton_Param_Mouse.png"));
            btnImageOption.setY(btnImageOption.getY()+2);
        }
        if (mouseEvent.getSource() == btnImagesQuitter){
            btnImagesQuitter.setImage(new Image("Image_Boutons/Bouton_Quitter_Mouse.png"));
            btnImagesQuitter.setY(btnImagesQuitter.getY()+2);
        }

        if (mouseEvent.getSource() == btnImageDeuxJoueurs){
            btnImageDeuxJoueurs.setY(btnImageDeuxJoueurs.getY()+2);
        }
        if (mouseEvent.getSource() == btnImageTroisJoueurs){
            btnImageTroisJoueurs.setY(btnImageTroisJoueurs.getY()+2);
        }
        if (mouseEvent.getSource() == btnImagequatreJoueurs){
            btnImagequatreJoueurs.setY(btnImagequatreJoueurs.getY()+2);
        }
        if (mouseEvent.getSource() == btnImageCinqJoueurs){
            btnImageCinqJoueurs.setY(btnImageCinqJoueurs.getY()+2);
        }
        if (mouseEvent.getSource() == btnImageSixJoueurs){
            btnImageSixJoueurs.setY(btnImageSixJoueurs.getY()+2);
        }
    }
    public  void onMouseExit(MouseEvent mouseEvent){
        if (mouseEvent.getSource() == btnImageJouer){
            btnImageJouer.setImage(new Image("Image_Boutons/Bouton_Jouer.png"));
            btnImageJouer.setY(btnImageJouer.getY()-2);
        }
        if (mouseEvent.getSource() == btnImageRules){
            btnImageRules.setImage(new Image("Image_Boutons/Bouton_Regles.png"));
            btnImageRules.setY(btnImageRules.getY()-2);
        }
        if (mouseEvent.getSource() == btnImageOption){
            btnImageOption.setImage(new Image("Image_Boutons/Bouton_Param.png"));
            btnImageOption.setY(btnImageOption.getY()-2);
        }
        if (mouseEvent.getSource() == btnImagesQuitter){
            btnImagesQuitter.setImage(new Image("Image_Boutons/Bouton_Quitter.png"));
            btnImagesQuitter.setY(btnImagesQuitter.getY()-2);
        }

        if (mouseEvent.getSource() == btnImageDeuxJoueurs){
            btnImageDeuxJoueurs.setY(btnImageDeuxJoueurs.getY()-2);
        }
        if (mouseEvent.getSource() == btnImageTroisJoueurs){
            btnImageTroisJoueurs.setY(btnImageTroisJoueurs.getY()-2);
        }
        if (mouseEvent.getSource() == btnImagequatreJoueurs){
            btnImagequatreJoueurs.setY(btnImagequatreJoueurs.getY()-2);
        }
        if (mouseEvent.getSource() == btnImageCinqJoueurs){
            btnImageCinqJoueurs.setY(btnImageCinqJoueurs.getY()-2);
        }
        if (mouseEvent.getSource() == btnImageSixJoueurs){
            btnImageSixJoueurs.setY(btnImageSixJoueurs.getY()-2);
        }
    }

        //////////////////////// Selection nombres de joueurs ////////////////////////////////////////////////////

    public void pressButtonSelectbJoueurs(MouseEvent mouseEvent) throws IOException {

        if (mouseEvent.getSource() == btnImageDeuxJoueurs){
            model.setNbreJoueurs(2);
            changeScene("Menu/SelectionFourmi/Deux_joueurs.fxml",btnImageDeuxJoueurs);
        }

        if (mouseEvent.getSource() == btnImageTroisJoueurs){
            model.setNbreJoueurs(3);
            changeScene("Menu/SelectionFourmi/Trois_joueurs.fxml",btnImageTroisJoueurs);
        }

        if (mouseEvent.getSource() == btnImagequatreJoueurs){
            model.setNbreJoueurs(4);
            changeScene("Menu/SelectionFourmi/Quatres_joueurs.fxml",btnImagequatreJoueurs);
        }

        if (mouseEvent.getSource() == btnImageCinqJoueurs){
            model.setNbreJoueurs(5);
            changeScene("Menu/SelectionFourmi/Cinq_joueurs.fxml",btnImageCinqJoueurs);
        }

        if (mouseEvent.getSource() == btnImageSixJoueurs){
            model.setNbreJoueurs(6);
            changeScene("Menu/SelectionFourmi/Six_joueurs.fxml",btnImageSixJoueurs);
        }

        if (mouseEvent.getSource() == btnImageRetour){
            changeScene("Menu/Menu.fxml",btnImageRetour);
        }
    }
    public void pressButtonSelectbJoueursTempo(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btn_launch_game ){
            TextField[] tabPseudo = {label_joueur1,label_joueur2,label_joueur3,label_joueur4,label_joueur5,label_joueur6};
            ColorPicker[] tabColor = {color_picker1,color_picker2,color_picker3,color_picker4,color_picker5,color_picker6};
            for (int i = 0; i< model.getNbreJoueurs(); i++){
                model.listeJoueurs.add(new Joueur(tabPseudo[i].getText(),tabColor[i].getValue()));
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
        Joueur joueur;
        if (mouseEvent.getSource() == btn_suivant){
                joueur = model.listeJoueurs.get(joueurEnSelection);
                for (int i = 0; i < Integer.parseInt(cpt_objectif_chasse.getText()); i++)
                    joueur.getListeObjectif().add(new ObjectifChasse());
                for (int i = 0; i < Integer.parseInt(cpt_objectif_creuseur.getText()); i++)
                    joueur.getListeObjectif().add(new ObjectifCreuseur());
                for (int i = 0; i < Integer.parseInt(cpt_objectif_fermier.getText()); i++)
                    joueur.getListeObjectif().add(new ObjectifFermier());

                for (int i = 0; i < Integer.parseInt(cpt_fourmi_chasseuse.getText()); i++){
                    fourmi = new FourmiChasseuse(new Image("Images_fourmi/"+joueurEnSelection+"_Chasseuse.png"));
                    joueur.getListeFourmi().add(fourmi);
                    joueur.getListFourmiTerrier().add(fourmi);
                    model.getListeInsectesPasEncoreJoue().add(fourmi);
                }
                for (int i = 0; i < Integer.parseInt(cpt_fourmi_creuseuse.getText()); i++){
                    fourmi = new FourmiCreuseuse(new Image("Images_fourmi/"+joueurEnSelection+"_Creuseuse.png"));
                    joueur.getListeFourmi().add(fourmi);
                    joueur.getListFourmiTerrier().add(fourmi);
                    model.getListeInsectesPasEncoreJoue().add(fourmi);
                }
                for (int i = 0; i < Integer.parseInt(cpt_fourmi_fermiere.getText()); i++){
                    fourmi = new FourmiFermiere(new Image("Images_fourmi/"+joueurEnSelection+"_Fermiere.png"));
                    joueur.getListeFourmi().add(fourmi);
                    joueur.getListFourmiTerrier().add(fourmi);
                    model.getListeInsectesPasEncoreJoue().add(fourmi);
                }
                for (int i =0; i<3; i++){
                    model.listeJoueurs.get(joueurEnSelection).getListeFourmi().get(i).setX(287);
                    model.listeJoueurs.get(joueurEnSelection).getListeFourmi().get(i).setY(84+40*i);
                }
                joueur.setPositionTerrierJoueur(posTerrier[joueurEnSelection]);
            joueurEnSelection++;
            if (joueurEnSelection-1<model.getNbreJoueurs()-1){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu/SelectionFourmi/ChoixFourmiObjectif.fxml"));
                btn_suivant.getScene().setRoot(loader.load());
                ControllerMenu controllerMenu = loader.getController();
                controllerMenu.initData(model.listeJoueurs.get(joueurEnSelection).getPseudo());
            }else{
                btn_suivant.getScene().setRoot(view.viewParty.p);
            }


        }
    }


        private void changeScene(String url, Node node) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        node.getScene().setRoot(root);
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
