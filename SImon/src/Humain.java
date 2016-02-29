import java.util.Scanner;
import java.util.StringTokenizer;

public class Humain implements Joueur{
    int point;

    public static Scanner in = new Scanner(System.in);

    public Humain(){
        point=0;
    }

    @Override
    public boolean jouer(Configuration config) {
        String reponse,s1="",s2="";
        StringTokenizer st;
        boolean erreur=false;
        do {
            System.out.println("A vous:");
            reponse = in.nextLine();
            st=new StringTokenizer(reponse,"-");
            if(st.hasMoreTokens()) {
                s1 = st.nextToken();
                if(st.hasMoreTokens()) {
                    s2 = st.nextToken();
                    if(st.hasMoreTokens())
                        erreur=false;
                }else {
                    System.out.println("erreur!!\nRappelle: entrer la répons sous la forme Xy-Xy");
                    erreur = true;
                }
            }else {
                System.out.println("erreur!!\nRappelle: entrer la répons sous la forme Xy-Xy");
                erreur = true;
            }
            if(!config.estPossible(s1,s2)){
                System.out.println("erreur!!\nCoup impossible");
                erreur=true;
            }
        }while(erreur);
        if(config.jouer(s1,s2)) {
            point++;
            return true;
        }else
            return false;
    }

    @Override
    public int getPoint() {
        return point;
    }
}
