import java.math.BigDecimal;

public class TestPlateau {
    public static void main(String[] args){
        Plateau p=new Plateau(new BigDecimal("0.10001000001011001000010010010000100001100001001000010000000"),3,8);
        System.out.println(p);
    }
}
