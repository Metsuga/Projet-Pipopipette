
// faire toDot, symetrie
public class Plateau implements Configuration{
    private int[][] tableau; //sert a definir les -- et |
    private int longeur; // taille |
    private int largeur; // taille --
    private static final char[] coord ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public Plateau(){
        this.tableau=new int[3][3];
        this.longeur=3;
        this.largeur=3;
    }

    public Plateau(int longeur,int largeur){
        this.tableau=new int [longeur][largeur];
        this.longeur=longeur;
        this.largeur=largeur;
        remplire();
    }

    private void remplire(){
        for(int i=0;i<longeur;i++)
            for(int j=0;j<largeur;j++){
                        tableau[i][j]=0;
                }
        tableau[0][0]=1100;
        tableau[0][largeur-1]=1010;
        tableau[longeur-1][0]=101;
        tableau[longeur-1][largeur-1]=11;
        for(int i=1;i<largeur-1;i++){
            tableau[0][i]=1000;
            tableau[longeur-1][i]=1;
        }
        for(int i=1;i<longeur-1;i++){
            tableau[i][0]=100;
            tableau[i][largeur-1]=10;
        }
    }

    public int[][] getTableau(){
        return tableau;
    }

    public int getLongeur() {
        return longeur;
    }

    public int getLargeur() {
        return largeur;
    }

    public String toString(){
        String s="   ";
        for(int i=0;i<=largeur;i++)
            s+=coord[i]+"  ";
        s+="\n";
        for(int i=0;i<longeur;i++){
            s+=i+"  ";
            for(int j=0;j<largeur;j++){
                if((tableau[i][j]/1000)%10==1)
                    s+="*--";
                else
                    s+="*  ";
            }
            s+="*\n   ";
            for(int j=0;j<largeur;j++){
                if((tableau[i][j]/100)%10==1)
                    s+="|  ";
                else
                    s+="   ";
            }
            s+="|\n";
        }
        s+=longeur+"  ";
        for(int i=0;i<largeur;i++)
            s+="*--";
        s+="*";
        return s;
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
        if(!this.getTableau().equals(p.getTableau()))
            return false;
        return true;
    }

    public boolean jouer(String depart,String arriver){
       char coordC1=depart.charAt(0),coordN1=depart.charAt(1),coordC2=arriver.charAt(0),coordN2=arriver.charAt(1);
        int coordN,coordC;
        if(coordC1==coordC2){
            //barre verticale
            coordN=Integer.min(Integer.parseInt(""+coordN1),Integer.parseInt(""+coordN2));
            coordC=Character.getNumericValue(coordC1)-Character.getNumericValue('A');
            tableau[coordN][coordC-1]+=10;
            tableau[coordN][coordC]+=100;
            return tableau[coordN][coordC-1]==1111 || tableau[coordN][coordC]==1111;
        }else
            if(coordN1==coordN2){
                //barre horizontal
                coordN=Integer.parseInt(""+coordN1);
                coordC=Integer.min(Character.getNumericValue(coordC1)-Character.getNumericValue('A'),Character.getNumericValue(coordC2)-Character.getNumericValue('A'));
                tableau[coordN-1][coordC]+=1;
                tableau[coordN][coordC]+=1000;
                return tableau[coordN-1][coordC]==1111 || tableau[coordN][coordC]==1111;
            }else
                throw new IllegalArgumentException("coup imposssible");
    }

    public boolean estPossible(String s1,String s2){
        char coordC1=s1.charAt(0),coordN1=s1.charAt(1),coordC2=s2.charAt(0),coordN2=s2.charAt(1);
        int coordN,coordC;
        if(coordC1==coordC2){
            //barre verticale
            coordN=Integer.min(Integer.parseInt(""+coordN1),Integer.parseInt(""+coordN2));
            coordC=Character.getNumericValue(coordC1)-Character.getNumericValue('A');
            if(coordC<1)
                return (tableau[coordN][coordC]/100)%10==0;
            else
                return (tableau[coordN][coordC-1]/10)%10==0 && (tableau[coordN][coordC]/100)%10==0;
        }else
        if(coordN1==coordN2){
            //barre horizontal
            coordN=Integer.parseInt(""+coordN1);
            coordC=Integer.min(Character.getNumericValue(coordC1)-Character.getNumericValue('A'),Character.getNumericValue(coordC2)-Character.getNumericValue('A'));
            if(coordN<1)
                return (tableau[coordN][coordC]/1000)%10==0;
            else
                return (tableau[coordN-1][coordC]%10==0) && (tableau[coordN][coordC]/1000)%10==0;
        }else
            return false;
    }

    public String[] carrePossible(){
        for(int i=0;i<longeur;i++){
            for(int j=0;j<largeur;j++){
                if((tableau[i][j]/1000)%10+(tableau[i][j]/100)%10+(tableau[i][j]/10)%10+tableau[i][j]%10==3)
                    return conversion(i,j);
            }
        }
        return new String[0];
    }

    private String[] conversion(int i,int j){
        if((tableau[i][j]/1000)%10==0){
            String[] s={coord[j]+""+i,coord[j+1]+""+i};
            return s;
        }
        if((tableau[i][j]/100)%10==0){
            String[] s={coord[j]+""+i,coord[j]+""+(i+1)};
            return s;
        }
        if((tableau[i][j]/10)%10==0){
            String[] s={coord[j+1]+""+i,coord[j+1]+""+(i+1)};
            return s;
        }
        if(tableau[i][j]%10==0){
            String[] s={coord[j]+""+(i+1),coord[j+1]+""+(i+1)};
            return s;
        }
        return new String[0];
    }

    public boolean termine(){
        for(int i=0;i<longeur;i++) {
            for (int j = 0; j < largeur; j++) {
                if ((tableau[i][j] / 1000) % 10 + (tableau[i][j] / 100) % 10 + (tableau[i][j] / 10) % 10 + tableau[i][j] % 10 != 4)
                    return false;
            }
        }
        return true;
    }

    public String toDot(String label){// a fair
        return "";
    }
}
