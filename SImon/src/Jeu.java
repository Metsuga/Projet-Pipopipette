public class Jeu {
    private Configuration config;
    private Joueur j1;
    private Joueur j2;
    private int tours;

    public Jeu(int x,int y) {
        tours = 1;
        j1 = new Humain();
        j2 = new IA();
        config = new Plateau(x,y);
    }

    public boolean termine(){
        return tours==(config.getLargeur()-1)*config.getLongeur()+(config.getLongeur()-1)*config.getLargeur();
    }
}
