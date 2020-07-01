package hackerRank;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameOfThrones1 {
    public static void main(String[] args) {
        String test="cdcdcdcdeeeef";
        System.out.println(gameOfThrones(test));
    }

    static String gameOfThrones(String s) {

        int[] array=new int[26];
        IntStream.range(0,s.length()).forEach(a->{
            array[(int) s.charAt(a) -'a']++;
        });

       return Arrays.stream(array).filter(a-> a == 1 || a%2 ==1).count() >= 2? "NO" : "YES";
    }


}
