import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Plateau {
    private double barreH;
    private double barreV;
    private int longeur;
    private int largeur;

    public Plateau(){
        this.barreH=0;
        this.barreV=0;
        this.longeur=0;
        this.largeur=0;
    }

    public Plateau(int longeur,int largeur){
        this(0,0,longeur,largeur);
    }

    public Plateau(double barreH, double barreV ,int longeur,int largeur){
        this.barreH=barreH;
        this.barreV=barreV;
        if(longeur>0)
            this.longeur=longeur;
        if(largeur>0)
            this.largeur=largeur;
    }

    public String toString(){
        String s="";
        int l;
        double h=barreH;
        double v=barreV;
        System.out.println(h);
        System.out.println(v);
        double pow=0;
        for(int i=0;i<2*longeur+1;i++) {
            if(i%2==0) {
                //ligne de --
                pow=Math.pow(10,3+3*(2-(i/2)));
                l=(int)(h/pow);
                h=h-l*pow;
                for(int j=largeur-1;j>-1;j--)
                    if((int)(l/Math.pow(10,j)%10)==0) {
                        s += "*  ";
                    }else {
                        s += "*--";
                    }
                s+="*\n";
            }else {
                // ligne de |
                switch(i) {
                    case 1:
                        pow=Math.pow(10,8);
                        break;
                    case 3:
                        pow=Math.pow(10,4);
                        break;
                    case 5:
                        pow=Math.pow(10,0);
                        break;
                }
                l=(int)(v/pow);
                v=v-l*pow;
                for(int j=largeur;j>-1;j--)
                    if((int)(l/Math.pow(10,j)%10)==0) {
                        s += "   ";
                    }else {
                        s += "|  ";
                    }
                s+="\n";
            }
        }
        return s;
    }

/*
    public int getLongeur() {
        return longeur;
    }

    public int getLargeur() {
        return largeur;
    }

    public boolean symetrique(Plateau p){
        if(this.getStatue().equals(p.getStatue()))
            return true;
        if(this.getLargeur()!=p.getLargeur())
            return false;
        if(this.getLongeur()!=p.getLongeur())
            return false;
        return this.symetrieV(p) || this.symetrieH(p) || this.symetrieD(p);
    }

    private boolean symetrieV(Plateau p) {
        String s1 = this.getStatue().toString();
        StringTokenizer temp =new StringTokenizer(s1,".");
        temp.nextToken();
        s1=temp.nextToken();
        String s2 = p.getStatue().toString();
        temp =new StringTokenizer(s2,".");
        temp.nextToken();
        s2=temp.nextToken();
        for (int i = 0; i < this.getLongeur();i = i + this.getLargeur() + this.getLongeur()) {
            for (int j = i; j < this.getLargeur()+this.getLongeur(); j++) {
                if(j<this.getLargeur()-1) {
                    if (s1.charAt(j) != s2.charAt(this.getLargeur() + j - 1))
                        return false;
                }else {
                    if (s1.charAt(j) != s2.charAt(this.getLongeur() + j - 1))
                        return false;
                }
            }
        }
        return true;
    }
    private boolean symetrieH(Plateau p){
        return false;
    }
    private boolean symetrieD(Plateau p){
        String s1 = this.getStatue().toString();
        StringTokenizer temp =new StringTokenizer(s1,".");
        temp.nextToken();
        s1=temp.nextToken();
        String s2 = p.getStatue().toString();
        temp =new StringTokenizer(s2,".");
        temp.nextToken();
        s2=temp.nextToken();
        System.out.println(s1);
        System.out.println(s2.charAt(11));
        for (int i = 0; i < s1.length()/2;i ++) {
            System.out.println(s1.charAt(i) + "("+i+") = " + s2.charAt(s2.length() - 1 - i)+"("+(s2.length() - 1 - i)+")");
            if (s1.charAt(i) != s2.charAt(s2.length() - 1 - i))
                return false;
        }
        return true;
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
        if(!this.symetrique(p))
            return false;
        return true;
    }
    */
}
