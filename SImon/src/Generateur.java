import java.util.LinkedList;

public class Generateur {
    private static final char[] coord = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void generate(Integer i,Graphe g){
        Configuration c = g.getConf(i);
        Configuration next;
        if(c.termine()) {
            g.ajoutListe(i,new LinkedList<Integer>());
            return ;
        }
        int longe=c.getLongeur(),larg=c.getLargeur();
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int j=0;j<longe;j++){
            for(int h=0;h<larg;h++){
                if(c.estPossible(coord[j]+""+h,coord[j]+""+(h+1))) {
                    next = c.clone().jouer(coord[j] + "" + h, coord[j] + "" + (h + 1));
                    next=complete(next);
                    g.ajouteConf(next);
                    generate(next.hashCode(),g);
                    if(!list.contains(next.hashCode()))
                        list.add(next.hashCode());
                }
                if(c.estPossible(coord[j]+""+h,coord[j+1]+""+h)) {
                    next = c.clone().jouer(coord[j] + "" + h, coord[j+1] + "" + h);
                    next=complete(next);
                    g.ajouteConf(next);
                    generate(next.hashCode(),g);
                    if(!list.contains(next.hashCode()))
                         list.add(next.hashCode());
                }
            }
        }
        g.ajoutListe(i,list);
    }

    public static Configuration complete(Configuration c){
        String[] s = c.carrePossible();
        if (s.length == 2)
            return complete(c.jouer(s[0], s[1]));
        else
            return c;
    }
}
