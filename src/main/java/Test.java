import java.math.BigDecimal;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {


        double sqrt = Math.sqrt(17);

        String s = String.valueOf(sqrt);
        System.out.println("s = " + s.endsWith(".0"));
    }
}
