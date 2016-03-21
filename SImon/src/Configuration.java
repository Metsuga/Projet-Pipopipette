public interface Configuration {
    public Configuration jouer(String depart,String arriver);
    public String toDot(int N,int V);
    public int[][] getTableau();
    public int getLongeur();
    public int getLargeur();
    public boolean estPossible(String s1,String s2);
    public String[] carrePossible();
    public boolean termine();
    public Configuration clone();
}
