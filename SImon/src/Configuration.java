public interface Configuration {
    public boolean jouer(String depart,String arriver);
    public String toDot(String label);
    public int[][] getTableau();
    public int getLongeur();
    public int getLargeur();
    public boolean estPossible(String s1,String s2);
    public String[] carrePossible();
    public boolean termine();
}
