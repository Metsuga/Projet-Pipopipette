public class Main {

    public static void main(String[] args) {
        Jeu j=new Jeu(3,3);
        try {
            j.toDot("test");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        while(!j.termine()){
            j.nextTurn();
        }
       System.out.println(j.gagnant());
    }
}
