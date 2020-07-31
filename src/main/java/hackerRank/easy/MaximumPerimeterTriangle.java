package hackerRank.easy;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumPerimeterTriangle {

    /**
     * https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
     */

    public static void main(String[] args) {

        int[] sticks = {1, 2, 3, 4, 5, 10};
        int[] sticks2 = {1, 1, 1, 3, 3};
        int[] sticks3 = {1, 2, 3};
        int[] sticks4 = {1, 1, 1, 2, 3, 5};

// FIRST SOLUTION PRINT
        System.out.println(Arrays.toString(maximumPerimeterTriangle(sticks)));

// SECOND SOLUTION PRINT
        System.out.println(Arrays.toString(maximumPerimeterTriangleMath(sticks)));

    }

    /**
     * - FIRST SOLUTION -
     */

    static long[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        List<long[]> list = possibleTriangles(sticks);

        if (list.isEmpty()) return new long[]{-1};
        else if (list.size() == 1) return list.get(0);
        else return validTriangleWithPerimeter(list);
    }

    private static List<long[]> possibleTriangles(int[] sticks) {
        List<long[]> list = new ArrayList<>();

        for (int a = 0; a < sticks.length; a++) {
            for (int b = a + 1; b <= sticks.length - 2; b++) {
                if (isNonDegenerateTriangle(sticks[a], sticks[a + 1], sticks[b + 1])) {
                    long[] triangle = {sticks[a], sticks[a + 1], sticks[b + 1]};
                    list.add(triangle);
                } else {
                    break;
                }
            }
        }

        return list;
    }

    static long[] validTriangleWithPerimeter(List<long[]> list) {

        Map<long[], Long> hashMap = new HashMap<>();
        long max = 0;

        for (long[] curr : list) {
            long perimeter = Arrays.stream(curr).sum();
            if (perimeter >= max) {
                max = perimeter;
                hashMap.put(curr, perimeter);
            }
        }

        long finalMax = max;
        List<long[]> collect = hashMap.entrySet().stream().filter(a -> a.getValue() == finalMax).map(Map.Entry::getKey).collect(Collectors.toList());

        if (collect.size() == 1)
            return collect.get(0);
        else {
            return validTriangleWithMinimumLongestSide(collect);
        }
    }

    private static long[] validTriangleWithMinimumLongestSide(List<long[]> list) {
        Map<long[], Long> hashMap = new HashMap<>();
        long validMin = 0;

        for (long[] curr : list) {
            long min = Arrays.stream(curr).min().orElseThrow(RuntimeException::new);
            hashMap.put(curr, min);
            if (min > validMin) {
                validMin = min;
            }
        }


        long finalValidMin = validMin;
        return hashMap.entrySet().stream().filter(a -> a.getValue() == finalValidMin).findFirst().orElseThrow(RuntimeException::new).getKey();
    }

    static boolean isNonDegenerateTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }

    /**
     * - SECOND SOLUTION -
     */
    static int[] maximumPerimeterTriangleMath(int[] sticks) {
        int n = sticks.length;
        Arrays.sort(sticks);

        int x, y, z;
        for (x = n - 3, y = n - 2, z = n - 1; sticks[x] + sticks[y] <= sticks[z]; x--, y--, z--) {
            System.out.println(x + ", " + y + ", " + z);
            if (x == 0) {
                return new int[]{-1};
            }
        }

        return new int[]{sticks[x], sticks[y], sticks[z]};
    }
}

