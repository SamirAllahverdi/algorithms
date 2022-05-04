package hackerRank.recentImpls;

import java.util.List;
import java.util.stream.Collectors;

public class MarkAndToys {

    /***
     * https://www.hackerrank.com/challenges/mark-and-toys
     */

//    public static void main(String[] args) {
//
//        System.out.println(maximumToys(Arrays.asList(1, 12, 5, 111, 200, 1000, 10), 50));
//    }

    public static int maximumToys(List<Integer> prices, int k) {
        List<Integer> sortedPrices = prices.stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < sortedPrices.size(); i++) {
            k -= sortedPrices.get(i);
            if (k < 0) return i;
        }

        return prices.size();
    }
}
