package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class SherlockAndArray {

    /**
     * - https://www.hackerrank.com/challenges/sherlock-and-array
     */
//    public static void main(String[] args) {
//        System.out.println(balancedSums(Arrays.asList(1,2,4,2,1)));
//    }

    public static String balancedSums(List<Integer> arr) {
        int sum = 0;
        for (int el : arr)
            sum += el;

        int leftSum = 0;
        for (int fu : arr)
            if (2 * leftSum == sum - fu)
                return "YES";
            else
                leftSum += fu;

        return "NO";
    }
}
