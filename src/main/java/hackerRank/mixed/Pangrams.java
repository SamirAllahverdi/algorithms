package hackerRank.mixed;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Pangrams {
    public static void main(String[] args) {
//        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
        System.out.println(pangrams2("We promptly judged antique ivory buckles for the next prize"));

    }

    static String pangrams2(String s) {
        return IntStream.range(0, 26).allMatch(a -> s.toLowerCase().contains(String.valueOf((char) (a + 97)))) ?
                "pangram" : "not pangram";
    }

    static String pangrams(String s) {
        int[] alphabet = new int[26];


        s.codePoints().forEach(a -> {
            if (Character.isUpperCase(a)) {
                alphabet[a - 65]++;
            } else if (Character.isLowerCase(a)) {
                alphabet[a - 97]++;
            }
        });

        return Arrays.stream(alphabet).anyMatch(a -> a == 0) ? "not pangram" : "pangram";
    }


}
