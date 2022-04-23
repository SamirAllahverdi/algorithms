import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {


        System.out.println(BigDecimal.valueOf(3*0.1).setScale(1));
        double sqrt = Math.sqrt(17);

        String s = String.valueOf(sqrt);
        System.out.println("s = " + s.endsWith(".0"));
    }
}
