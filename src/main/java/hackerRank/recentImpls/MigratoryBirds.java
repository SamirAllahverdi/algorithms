package hackerRank.recentImpls;

import java.util.List;

public class MigratoryBirds {

    /**
     * https://www.hackerrank.com/challenges/migratory-birds
     */

//    public static void main(String[] args) {
//        System.out.println(migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
//    }

    public static int migratoryBirds(List<Integer> arr) {
        int[] counter = new int[6];
        int max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;

        for (int a : arr) {
            counter[a]++;
            if (counter[a] > max) {
                max = counter[a];
                result = a;
            } else if (counter[a] == max) {
                result = Math.min(result, a);
            }
        }

        return result;
    }


}
