package hackerRank.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SherlockAndArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 1, 4, 1, 1);
        List<Integer> list3 = Arrays.asList(2, 0, 0, 0);
        System.out.println(balancedSums(list2));
        System.out.println(balancedSums(list3));

    }

    static String balancedSums(List<Integer> arr) {

        int rightSum = arr.stream().reduce(Integer::sum).orElse(0);

        int leftSum = 0;
        for (int el : arr) {
            rightSum -= el;
            if (leftSum == rightSum) {
                return "YES";
            }
            leftSum += el;
        }
        return "NO";
    }

}
