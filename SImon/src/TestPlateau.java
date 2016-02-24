import java.math.BigDecimal;

public class TestPlateau {
    public static void main(String[] args){
        Plateau p1=new Plateau(2,2);
        p1=p1.jouer("A2","B2");
        System.out.println(p1);
    }
}
