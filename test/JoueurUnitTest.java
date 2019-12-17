import jeu.ObjetJeu.Joueur;
import org.junit.Assert;
import org.junit.Test;

public class JoueurUnitTest {

    @Test
    public void retourneLeBonPseudo(){
        Joueur a = new Joueur("toto");
        Assert.assertEquals("toto",a.getPseudo());
    }
}
