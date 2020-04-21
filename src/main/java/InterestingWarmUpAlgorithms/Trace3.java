package InterestingWarmUpAlgorithms;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Trace3 {
    public static void main(String[] args) {
        int[][] a =
                {
                        {1, 2, 3},
                        {5, 6, 7},
                        {9, 10, 11},
                        {13, 14, 15},
                        {17, 18, 19},
                        {21, 22, 23},
                };
        System.out.println("MySoluthion " + MySoluthion(a.length, a[0].length, a));
    }

    private static String MySoluthion(int R, int C, int[][] a) {
        return IntStream.range(0, R * C).map(x -> {
            int column = x / R;
            int shift = x - column * R;
            int row = column % 2 == 0 ? shift : R - shift-1;
            int column_reverse = C - 1 - column;
            return a[row][column_reverse];
        }).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
