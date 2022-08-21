package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class BonAppetit {

    /**
     * - https://www.hackerrank.com/challenges/bon-appetit
     */

//    public static void main(String[] args) {
//        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
//    }


    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int billAna = bill.stream()
                .filter(x -> x != bill.get(k))
                .mapToInt(x -> x).sum() / 2;

        System.out.println(b - billAna == 0 ? "Bon Appetit" : b - billAna);
    }

}
