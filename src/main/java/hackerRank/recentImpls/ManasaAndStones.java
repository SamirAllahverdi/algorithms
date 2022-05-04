package hackerRank.recentImpls;

import java.util.*;

public class ManasaAndStones {

//    public static void main(String[] args) {
//
//    }



    public static List<Integer> stones(int n, int a, int b) {

        Set<Integer> possibleop  = new HashSet<>();

        for(int i = 0 ; i < n ; i++) {
            int e = (b * i) + (a * (n - i - 1));
            possibleop.add(e);
        }

        List<Integer> result = new ArrayList<>(possibleop);
        Collections.sort(result);

        return result;
    }

}
