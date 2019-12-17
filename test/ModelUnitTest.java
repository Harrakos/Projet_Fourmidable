import javafx.scene.paint.Color;
import jeu.Model;
import jeu.ObjetJeu.Joueur;
import org.junit.Assert;
import org.junit.Test;

public class ModelUnitTest {

    @Test
    public void TestPasserTourNormal(){
        Model model = new Model();
        Joueur a = new Joueur("toto");
        Joueur b = new Joueur("tata");
        Joueur c = new Joueur("titi");

        model.listeJoueurs.add(a);
        model.listeJoueurs.add(b);
        model.listeJoueurs.add(c);
        model.setNbreJoueurs(3);

        model.setCurrentPlayer(a);
        model.nouveauJoueur();
        Assert.assertEquals(model.listeJoueurs.get(1),model.getCurrentPlayer());
    }

    @Test
    public void TestPasserTourJoueurEnFinDeListe(){
        Model model = new Model();
        Joueur a = new Joueur("toto");
        Joueur b = new Joueur("tata");
        Joueur c = new Joueur("titi");


        model.listeJoueurs.add(a);
        model.listeJoueurs.add(b);
        model.listeJoueurs.add(c);
        model.setNbreJoueurs(3);

        model.setCurrentPlayer(c);
        model.nouveauJoueur();
        Assert.assertEquals(model.listeJoueurs.get(0),model.getCurrentPlayer());
    }

    @Test
    public void TestCurrentPlayer(){
        Model model = new Model();
        Joueur a = new Joueur("toto");
        Joueur b = new Joueur("tata");
        Joueur c = new Joueur("titi");


        model.listeJoueurs.add(a);
        model.listeJoueurs.add(b);
        model.listeJoueurs.add(c);
        model.setNbreJoueurs(3);

        model.setCurrentPlayer(a);
        Assert.assertEquals(model.getCurrentPlayer(),a);
    }
}
