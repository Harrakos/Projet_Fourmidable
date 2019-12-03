package jeu.ObjetJeu.Objectif;

public class ObjectifFermier extends Objectif {
    private int framboiseMax;
    private int myrtilleMax;
    private int champignonMax;
    private int framboiseActu = 0;
    private int myrtilleActu = 0;
    private int champignonActu = 0 ;
    private String message = "Objectif Fermiere : \n";
    public ObjectifFermier() {
        super();
        for (int i = 0; i<3; i++){
            framboiseMax = (int)(Math.random() * 3);
            myrtilleMax = (int)(Math.random() * 3);
            champignonMax = (int)(Math.random() * 3);
        }
        if (framboiseMax != 0)
            message = message+" Scarabe : "+framboiseActu+"/"+framboiseMax+"\n";
        if (myrtilleMax != 0)
            message = message+" Coccinelle :  "+myrtilleActu+"/"+myrtilleMax+"\n";
        if (champignonMax != 0)
            message = message+" Chenille : "+champignonActu+"/"+champignonMax+"\n";
    }

    @Override
    public String toString(){
        return message;
    }
}
