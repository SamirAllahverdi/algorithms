package hackerRank.newImplemenations;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class BetweenTwoSets {


    /**
     * https://www.hackerrank.com/challenges/between-two-sets
     */
//    public static void main(String[] args) {
//        System.out.println(getTotalX(Arrays.asList(2, 6), Arrays.asList(24, 36)));
//    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        Collections.sort(a);
        Collections.sort(b);
        int min = a.get(0);
        int max = b.get(b.size() - 1);

        return (int) IntStream.rangeClosed(min, max).filter(i -> hasFactors(i, a) && isFactor(i, b)).count();
    }


    public static boolean hasFactors(int num, List<Integer> list) {
        return list.stream().allMatch(a -> num % a == 0);
    }

    public static boolean isFactor(int num, List<Integer> list) {
        return list.stream().allMatch(a -> a % num == 0);
    }
}
