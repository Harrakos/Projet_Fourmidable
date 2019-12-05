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

    public int[] setMessage(int r1, int r2, int r3) {
        argileActu = r1;
        terreActu = r2;
        rocheActu = r3;

        message = "Objectif Minage : \n";
        if (argileMax != 0)
            message = message+" Argile : "+ argileActu+"/"+argileMax+"\n";
        if (terreMax != 0)
            message = message+" Terre : "+ terreActu+"/"+terreMax+"\n";
        if (rocheMax != 0)
            message = message+" Roche : "+ rocheActu+"/"+rocheMax+"\n";
        if(argileActu == argileMax && terreActu == terreMax && rocheActu == rocheMax) {
            message = "Objectif Réussi !";
            this.accompli = true;
        }
        return new int[]{argileMax,terreMax,rocheMax};


    }
}
