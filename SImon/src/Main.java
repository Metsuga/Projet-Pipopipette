public class Main {

    public static void main(String [] args){
        Jeu j=new Jeu(3,3);
        while(!j.termine()){
            j.nextTurn();
        }
       System.out.println(j.gagnant());
    }
}
