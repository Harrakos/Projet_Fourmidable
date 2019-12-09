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
            message = message+" Framboise : "+framboiseActu+"/"+framboiseMax+"\n";
        if (myrtilleMax != 0)
            message = message+" Myrtille :  "+myrtilleActu+"/"+myrtilleMax+"\n";
        if (champignonMax != 0)
            message = message+" Champignon : "+champignonActu+"/"+champignonMax+"\n";
        this.typeObjectif = 2;

    }

    @Override
    public String toString(){
        return message;
    }

    public int[] setMessage(int r1, int r2, int r3) {
        myrtilleActu = r1;
        framboiseActu = r2;
        champignonActu = r3;

        message = "Objectif Recolte : \n";
        if (framboiseMax != 0)
            message = message+" Framboise : "+framboiseActu+"/"+framboiseMax+"\n";
        if (myrtilleMax != 0)
            message = message+" Myrtille :  "+myrtilleActu+"/"+myrtilleMax+"\n";
        if (champignonMax != 0)
            message = message+" Champignon : "+champignonActu+"/"+champignonMax+"\n";
        if(framboiseActu >= framboiseMax && myrtilleActu >= myrtilleMax && champignonActu >= champignonMax) {
            message = "Objectif Réussi !";
            this.accompli = true;
        }
        return new int[]{myrtilleMax,framboiseMax,champignonMax};


    }
}
