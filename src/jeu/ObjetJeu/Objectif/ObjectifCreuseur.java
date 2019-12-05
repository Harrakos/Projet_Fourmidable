package jeu.ObjetJeu.Objectif;

public class ObjectifCreuseur extends Objectif {
    private int argileMax;
    private int terreMax;
    private int rocheMax;
    private int argileActu = 0;
    private int terreActu = 0;
    private int rocheActu = 0;
    private String message = "Objectif Miniere : \n";
    public ObjectifCreuseur() {
        super();
        for (int i = 0 ; i<3 ; i++){
            argileMax = (int)(Math.random()*3);
            terreMax = (int)(Math.random()*3);
            rocheMax = (int)(Math.random()*3);
        }
        if (argileMax != 0)
            message = message+" Argile : "+ argileActu+"/"+argileMax+"\n";
        if (terreMax != 0)
            message = message+" Terre : "+ terreActu+"/"+terreMax+"\n";
        if (rocheMax != 0)
            message = message+" Roche : "+ rocheActu+"/"+rocheMax+"\n";
        this.typeObjectif = 1;


    }

    @Override
    public String toString() {
        return message;
    }

    public void setMessage(int r1, int r2, int r3) {
        argileActu = r1;
        terreActu = r2;
        rocheActu = r3;

        message = "Objectif Minage : \n";
        message = message+" Argile : "+ argileActu+"/"+argileMax+"\n";
        message = message+" Terre : "+ terreActu+"/"+terreMax+"\n";
        message = message+" Roche : "+ rocheMax+"/"+rocheMax+"\n";

    }

    public int getArgileActu() {
        return argileActu;
    }

    public void setArgileActu(int argileActu) {
        this.argileActu = argileActu;
    }

    public int getTerreActu() {
        return terreActu;
    }

    public void setTerreActu(int terreActu) {
        this.terreActu = terreActu;
    }

    public int getRocheActu() {
        return rocheActu;
    }

    public void setRocheActu(int rocheActu) {
        this.rocheActu = rocheActu;
    }
}
