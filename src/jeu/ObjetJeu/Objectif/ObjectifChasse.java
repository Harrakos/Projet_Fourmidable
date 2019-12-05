package jeu.ObjetJeu.Objectif;

public class ObjectifChasse extends Objectif {
    private int scarabeMax;
    private int coccinelleMax;
    private int chenilleMax;
    private int scarabeActu = 0;
    private int coccinelleActu = 0;
    private int chenilleActu = 0;
    private String message = "Objectif Chasse : \n";

    public ObjectifChasse() {
        super();
        for (int i = 0; i < 3; i++) {
            scarabeMax = (int) (Math.random() * 3);
            coccinelleMax = (int) (Math.random() * 3);
            chenilleMax = (int) (Math.random() * 3);
        }
        if (scarabeMax != 0)
            message = message + " Scarabe : " + scarabeActu + "/" + scarabeMax + "\n";
        if (coccinelleMax != 0)
            message = message + " Coccinelle :  " + coccinelleActu + "/" + coccinelleMax + "\n";
        if (chenilleMax != 0)
            message = message + " Chenille : " + chenilleActu + "/" + chenilleMax + "\n";

        this.typeObjectif = 0;
    }


    @Override
    public String toString() {
        return message;
    }

    public int[] setMessage(int r1, int r2, int r3) {
        scarabeActu = r1;
        coccinelleActu = r2;
        chenilleActu = r3;

        message = "Objectif Chasse : \n";
        if (scarabeMax != 0)
            message = message + " Scarabe : " + scarabeActu + "/" + scarabeMax + "\n";
        if (coccinelleMax != 0)
            message = message + " Coccinelle :  " + coccinelleActu + "/" + coccinelleMax + "\n";
        if (chenilleMax != 0)
            message = message + " Chenille : " + chenilleActu + "/" + chenilleMax + "\n";
        if(chenilleActu == chenilleMax && coccinelleActu == coccinelleMax && scarabeActu == scarabeMax){
            message = "Objectif Réussi !";
            this.accompli = true;
        }
        return new int[]{scarabeMax,coccinelleMax,chenilleMax};
    }
}
