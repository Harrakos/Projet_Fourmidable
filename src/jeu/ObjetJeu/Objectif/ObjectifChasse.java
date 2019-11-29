package jeu.ObjetJeu.Objectif;

public class ObjectifChasse extends Objectif {
    private int scarabeMax;
    private int coccinelleMax;
    private int chenilleMax;
    private int scarabeActu = 0;
    private int coccinelleActu = 0;
    private int chenilleActu = 0 ;
    private String message = "Objectif Chasse : \n";
    public ObjectifChasse() {
        super();
        for (int i = 0; i<3; i++){
            scarabeMax = (int)(Math.random() * 3);
            coccinelleMax = (int)(Math.random() * 3);
            chenilleMax = (int)(Math.random() * 3);
        }
        if (scarabeMax != 0)
            message = message+"Scarabe : "+scarabeActu+"/"+scarabeMax+"\n";
        if (coccinelleMax != 0)
            message = message+"Coccinelle :  "+coccinelleActu+"/"+coccinelleMax+"\n";
        if (chenilleMax != 0)
            message = message+"Chenille : "+coccinelleActu+"/"+coccinelleMax+"\n";





    }



    @Override
    public String toString() {
        return message;
    }

    public int getScarabeMax() {
        return scarabeMax;
    }

    public void setScarabeMax(int scarabeMax) {
        this.scarabeMax = scarabeMax;
    }

    public int getCoccinelleMax() {
        return coccinelleMax;
    }

    public void setCoccinelleMax(int coccinelleMax) {
        this.coccinelleMax = coccinelleMax;
    }

    public int getChenilleMax() {
        return chenilleMax;
    }

    public void setChenilleMax(int chenilleMax) {
        this.chenilleMax = chenilleMax;
    }

    public int getScarabeActu() {
        return scarabeActu;
    }

    public void setScarabeActu(int scarabeActu) {
        this.scarabeActu = scarabeActu;
    }

    public int getCoccinelleActu() {
        return coccinelleActu;
    }

    public void setCoccinelleActu(int coccinelleActu) {
        this.coccinelleActu = coccinelleActu;
    }

    public int getChenilleActu() {
        return chenilleActu;
    }

    public void setChenilleActu(int chenilleActu) {
        this.chenilleActu = chenilleActu;
    }
}
