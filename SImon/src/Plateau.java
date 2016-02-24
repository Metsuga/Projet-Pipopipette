
// faire toDot, symetrie
public class Plateau implements Configuration{
    private double barre; //sert a definir les --
    private int longeur; // taille |
    private int largeur; // taille --
    private static char[] coord ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public Plateau(){
        this.barre=0;
        this.longeur=0;
        this.largeur=0;
    }

    public Plateau(int longeur,int largeur){
        this(0,longeur,largeur);
    }

    public Plateau(double barre,int longeur,int largeur){
        this.barre=barre;
        if(longeur>0)
            this.longeur=longeur;
        if(largeur>0)
            this.largeur=largeur;
    }

    public String toString(){
        String s="   ";
        double tailleColone=Math.pow(10,largeur-1);
        double tailleLigne=Math.pow(10,largeur);
        double etat,etatb;
        double colone=(int)barre;
        double ligne=barre*Math.pow(tailleLigne,longeur-1)-colone*Math.pow(tailleLigne,longeur-1);
        for(int i=0;i<=largeur;i++)
            s+=coord[i]+"  ";
        s+="\n1  ";
        for(int i=0;i<largeur;i++)
            s+="*--";
        s+="*\n";
        for(int i=0;i<(2*longeur-1);i++){
            if(i%2==0) {
                s+="   |  ";
                etat=(int)(colone/(Math.pow(tailleColone,longeur-(i/2)-1)));
                colone-=etat*(Math.pow(tailleColone,longeur-(i/2)-1));
                for(int j=1;j<largeur;j++){
                    etatb=(int)(etat/Math.pow(10,largeur-j-1));
                    etat-=etatb*Math.pow(10,largeur-j-1);
                    if(etatb==0)
                        s+="   ";
                    else
                        s+="|  ";
                }
                s+="|\n";
            }else{
                s+=(i/2+2)+"  ";
                etat = (int) (ligne / (Math.pow(tailleLigne, longeur -1- ((i+1)/2))));
                ligne -= etat * (Math.pow(tailleLigne, longeur - 1 - ((i+1)/2)));
                for(int j=0;j<largeur;j++){
                    etatb=(int)(etat/Math.pow(10,largeur-j-1));
                    etat-=etatb*Math.pow(10,largeur-j-1);
                    if(etatb==0)
                        s+="*  ";
                    else
                        s+="*--";
                }
                s+="*\n";
            }
        }
        s+=longeur+1+"  ";
        for(int i=0;i<largeur;i++)
            s+="*--";
        s+="*\n";
        return s;
    }

    public double getBarre(){
        return barre;
    }

    public int getLongeur() {
        return longeur;
    }

    public int getLargeur() {
        return largeur;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()!=this.getClass())
            return false;
        Plateau p=(Plateau)obj;
        if(this.longeur!=p.longeur)
            return false;
        if(this.largeur!=p.largeur)
            return false;
        if(this.getBarre()!=p.getBarre())
            return false;
        return true;
    }

    public Plateau jouer(String depart,String arriver){
        char coordC1=depart.charAt(0),coordN1=depart.charAt(1),coordC2=arriver.charAt(0),coordN2=arriver.charAt(1);
        int coordN,coordC;
        if(coordC1==coordC2){
            //barre verticale
            coordN=Integer.min(Integer.parseInt(""+coordN1),Integer.parseInt(""+coordN2));
            coordC=Character.getNumericValue(coordC1)-Character.getNumericValue('A');
            return new Plateau(barre+Math.pow(10,Math.pow(largeur-1,largeur-coordN)+largeur-1-coordC),longeur,largeur);
        }else
            if(coordN1==coordN2){
                //barre horizontal
                coordN=Integer.parseInt(""+coordN1)-2;
                if(coordN==0)
                    coordC=Integer.min(Character.getNumericValue(coordC1)-Character.getNumericValue('A'),Character.getNumericValue(coordC2)-Character.getNumericValue('A'));
                else
                    coordC=Integer.min(Character.getNumericValue(coordC1)-Character.getNumericValue('A'),Character.getNumericValue(coordC2)-Character.getNumericValue('A'))+1;
                return new Plateau(barre+Math.pow(10,-(Math.pow(largeur,coordN)+coordC)),longeur,largeur);
            }else
                throw new IllegalArgumentException("coup imposssible");
    }

    public String toDot(String label){
        return "";
    }
}
