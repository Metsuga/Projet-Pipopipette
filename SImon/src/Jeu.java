import java.io.IOException;

public class Jeu {
    private Configuration config;
    private Joueur j1;
    private Joueur j2;
    private int tours;
    private Joueur prochain;
    private Graphe g;

    public Jeu(int x,int y) {
        tours = 1;
        j1 = new Humain();
        j2 = new Simplet();
        config = new Plateau(x,y);
        prochain=j1;
        g=new Graphe(x,y);
    }

    public boolean termine(){
        return config.termine();
    }

    public void nextTurn(){
        System.out.println("tour "+tours);
        tours++;
        config = prochain.jouer(config, g);
        if(prochain.equals(j1))
            prochain=j2;
        else
            prochain=j1;
    }

    public String gagnant(){
        if(j1.getPoint()<j2.getPoint())
            return "Le gagnant est l'ordinateur avec "+j2.getPoint()+" points";
        else
            return "vous etes le gagnant avec "+j1.getPoint()+" points";
    }

    public void toDot(String file) throws IOException{
        g.toDot(file);
    }
}
