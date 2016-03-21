import java.util.LinkedList;

public class Simplet implements Joueur {
    int point;
    private static final char[] coord = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Simplet() {
        point = 0;
    }

    public Configuration jouer(Configuration config,Graphe g) {
        config=Generateur.complete(config);
        System.out.println(config);
        LinkedList<Integer> list=g.jeuPossible(config);
        int i=(int)(Math.random() * (list.size()));
        return g.getConf(list.get(i));
    }

    @Override
    public int getPoint() {
        return point;
    }
}
