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


        System.out.println(organizingContainers(twoDimArr));
        System.out.println(organizingContainers(twoDimArr2));
        System.out.println(organizingContainers2(twoDimArr2));


    }


    static String organizingContainers(int[][] container) {

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

    static String organizingContainers2(int[][] container) {

        int[] row = new int[container.length];
        int[] col = new int[container.length];

        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                row[i] += container[i][j];
                col[j] += container[j][i];
            }
        }

        Arrays.sort(row);
        Arrays.sort(col);

        return IntStream.range(0, container.length).allMatch(a -> row[a] == col[a]) ? "Possible" : "Impossible";
    }

}
