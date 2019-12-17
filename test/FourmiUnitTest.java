import javafx.scene.image.Image;
import jeu.ObjetJeu.Fourmi.Fourmi;
import jeu.ObjetJeu.Fourmi.FourmiChasseuse;
import jeu.ObjetJeu.Fourmi.FourmiCreuseuse;
import jeu.ObjetJeu.Ressource.RessourceChasse.TuileChenille;
import jeu.ObjetJeu.Ressource.RessourceMiniere.TuileArgile;
import jeu.ObjetJeu.Ressource.RessourceMiniere.TuileMiniere;
import org.junit.Assert;
import org.junit.Test;

public class FourmiUnitTest {

    private Object Image;

    @Test
    public void retouneBonTypeFourmi(){
        FourmiChasseuse fc = new FourmiChasseuse((javafx.scene.image.Image) Image);
        FourmiCreuseuse fm = new FourmiCreuseuse((javafx.scene.image.Image) Image);

        Assert.assertEquals(fc.getTypeFourmi(),0);
        Assert.assertNotEquals(fm.getTypeFourmi(),0);
    }



    //ne marche a cause de l'image pourtant ça devrait fonctionner
    @Test
    public void TestRecuperationRessourcePossible(){
        FourmiChasseuse fc = new FourmiChasseuse((javafx.scene.image.Image) Image);
        TuileChenille tc = new TuileChenille();
        TuileArgile tm = new TuileArgile();

        Assert.assertTrue(fc.recupere(tc));
        Assert.assertFalse(fc.recupere(tm));






    }



}
