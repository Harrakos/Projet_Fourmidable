package jeu.ObjetJeu;

import java.awt.image.BufferedImage;

public enum Ressource {
    CHENILLE ("Chenille", "Insecte", new ImageIcon("Images/Chenille.jpg")),
    COCCINELLE ("Coccinelle", "Insecte", new ImageIcon("Images/Chenille.jpg")),
    SCARABEE ("Scarabée", "Insecte", new ImageIcon("Images/Chenille.jpg")),
    ARGILE("Argile", "Plante", new ImageIcon("Images/Chenille.jpg")),
    ROCHE("Roche", "Plante", new ImageIcon("Images/Chenille.jpg")),
    TERRE("Terre", "Plante", new ImageIcon("Images/Chenille.jpg")),
    CHAMPIGNON ("Champignon", "Fruit", new ImageIcon("Images/Chenille.jpg")),
    MIRTILE ("Mirtile", "Fruit", new ImageIcon("Images/Chenille.jpg")),
    FRAMBOISE ("Framboise", "Fruit", new ImageIcon("Images/Chenille.jpg"));

    private String name="";
    private String type = "";
    private ImageIcon image = null;

    Ressources(String name, String type, ImageIcon image){
        this.name = name;
        this.type = type;
        this.image = image;
    }

}
