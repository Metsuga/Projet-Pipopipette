public class IA implements Joueur{
    int point;

    public IA(){
        point=0;
    }

    @Override
    public boolean jouer(Configuration config) {
        return false;
    }

    @Override
    public int getPoint() {
        return point;
    }
}
