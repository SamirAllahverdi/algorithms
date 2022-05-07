package pashabank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RollTheString {

    public static void main(String[] args) {
        String a = "abz";
        List<Integer> arrayList = Arrays.asList(3, 2, 1);
        System.out.println(rollTheString(a,arrayList));
    }

    public static String rollTheString(String s, List<Integer> roll) {


//        for (Integer el : roll) {

            StringBuilder builder = new StringBuilder();

            for (int a = 0; a < 3; a++) {
                char i = (char) (97 + ((s.charAt(a) + 1) % 122));
                builder.append(i);
            }
            System.out.println(builder);
            s = builder.toString();

//        }

        return s;
    }


}
