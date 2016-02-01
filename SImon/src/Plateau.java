import java.math.BigDecimal;
import java.math.BigInteger;

public class Plateau {
    private BigDecimal statue;
    private int longeur;
    private int largeur;

    public Plateau(){
        this.statue=new BigDecimal(0);
        this.longeur=0;
        this.largeur=0;
    }

    public Plateau(BigDecimal statue,int longeur,int largeur){
        this.statue=statue;
        if(longeur>-1)
            this.longeur=longeur;
        if(largeur>-2)
            this.largeur=largeur;
    }

    public String toString(){
        System.out.println("etat actuel du tableau:");
        String s="";
        BigDecimal tableau=statue.multiply(new BigDecimal(1));
        System.out.println(tableau);
        BigDecimal ligne;
        BigInteger a;
        for(int i=0;i<longeur;i++){
            tableau=tableau.multiply(new BigDecimal(Math.pow(10,(largeur*2)+1)));
            ligne=tableau.divideToIntegralValue(new BigDecimal(1));
            tableau=tableau.subtract(ligne);
            System.out.println("ligne="+ligne);
            for(int j=2*largeur;j!=largeur;j--){
                a=ligne.divide(new BigDecimal(Math.pow(10,j))).toBigInteger();
                System.out.println(j+"-- "+a.mod(new BigInteger("10")));
                if(a.mod(new BigInteger("10")).intValue()==0)
                    s+="*  ";
                else
                    s+="*--";

            }
            s+="*\n";
            for(int j=largeur;j!=-1;j--){
                a=ligne.divide(new BigDecimal(Math.pow(10,j))).toBigInteger();
                System.out.println(j+"| "+a.mod(new BigInteger("10")));
                if(a.mod(new BigInteger("10")).intValue()==0)
                    s+="   ";
                else
                    s+="|  ";

            }
            s+="\n";
        }
        tableau=tableau.multiply(new BigDecimal(Math.pow(10,(largeur*2)+1)));
        ligne=tableau.divideToIntegralValue(new BigDecimal(1));
        tableau=tableau.subtract(ligne);
        System.out.println("ligne="+ligne);
        for(int j=2*largeur;j!=largeur;j--){
            a=ligne.divide(new BigDecimal(Math.pow(10,j))).toBigInteger();
            System.out.println(j+"-- "+a.mod(new BigInteger("10")));
            if(a.mod(new BigInteger("10")).intValue()==0)
                s+="*  ";
            else
                s+="*--";

        }
        s+="*\n";
        return s;
    }

}
