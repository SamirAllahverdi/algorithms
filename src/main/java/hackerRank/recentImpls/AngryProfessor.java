package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class AngryProfessor {

//    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(-2, -1, 0, 1, 2);
//        System.out.println(angryProfessor(3, integers));
//    }

    public static String angryProfessor(int k, List<Integer> a) {

        for (int b : a)
            if (b <= 0)
                k--;

        return k > 0 ? "YES" : "NO";
    }
}