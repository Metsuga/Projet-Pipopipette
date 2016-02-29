public class Simplet implements Joueur{
    int point;
    private static final char[] coord ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public Simplet(){
        point=0;
    }

    @Override
    public boolean jouer(Configuration config) {
        String[] s=config.carrePossible();
        String s1,s2;
        if(s.length==2)
            if(config.jouer(s[0],s[1])){
                point++;
                return true;
            }else
                return false;
        else{
            do {
                int dc = (int) (Math.random() * (config.getLongeur() - 1));
                int dn = (int) (Math.random() * (config.getLargeur() - 1));
                s1= coord[dc]+""+dn;
                if(Math.random()>0.5)
                    s2= coord[dc+1]+""+dn;
                else
                    s2= coord[dc]+""+(dn+1);
            }while(!config.estPossible(s1,s2));
            System.out.println(s1+"  "+s2);
            if(config.jouer(s1,s2)){
                point++;
                return true;
            }else
                return false;
        }
    }

    @Override
    public int getPoint() {
        return point;
    }
}
