package newImplemenations.hackerRank;

import java.util.List;

public class TwoDArray {
    /**
     * https://www.hackerrank.com/challenges/2d-array/
     */
//    public static void main(String[] args) {
//
//        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList(1, 1, 1, 0, 0, 0));
//        list.add(Arrays.asList(0, 1, 0, 0, 0, 0));
//        list.add(Arrays.asList(1, 1, 1, 0, 0, 0));
//        list.add(Arrays.asList(0, 0, 2, 4, 4, 0));
//        list.add(Arrays.asList(0, 0, 0, 2, 0, 0));
//        list.add(Arrays.asList(0, 0, 1, 2, 4, 0));
//
//        System.out.println(hourglassSum(list)); // expected 19
//    }


    public static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;

        for (int a = 0; a <= arr.size() - 3; a++) {
            for (int b = 0; b <= arr.get(a).size() - 3; b++) {

                int sum = arr.get(a).get(b) + arr.get(a).get(b + 1) + arr.get(a).get(b + 2)
                        /*                   */ + arr.get(a + 1).get(b + 1)
                        + arr.get(a + 2).get(b) + arr.get(a + 2).get(b + 1) + arr.get(a + 2).get(b + 2);

                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
