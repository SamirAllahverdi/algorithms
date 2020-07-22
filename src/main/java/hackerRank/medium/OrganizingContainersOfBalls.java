package hackerRank.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrganizingContainersOfBalls {

    /**
     * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
     */
    public static void main(String[] args) {

        int[][] twoDimArr = {{1, 3, 1},
                             {2, 1, 2},
                             {3, 3, 3}};

        int[][] twoDimArr2 = {{0, 2, 1},
                              {1, 1, 1},
                              {2, 0, 0}};


        System.out.println(organizingContainers(twoDimArr, twoDimArr.length));
        System.out.println(organizingContainers(twoDimArr2, twoDimArr2.length));

    }




    static String organizingContainers(int[][] container, int n) {

        List<Integer> ballsPerCon = Arrays.stream(container).map(a -> Arrays.stream(a).sum()).collect(Collectors.toList());
        Map<Integer, Integer> sameTypeBalls = arrayToMap(container);

        return ballsPerCon.stream().allMatch(sameTypeBalls::containsValue) ? "Possible" : "Impossible";
    }

    private static Map<Integer, Integer> arrayToMap(int[][] container) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : container) {
            for (int j = 0; j < container.length; j++) {
                map.put(j, map.getOrDefault(j, 0) + ints[j]);
            }
        }
        return map;
    }
}
