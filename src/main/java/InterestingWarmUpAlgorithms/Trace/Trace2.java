package InterestingWarmUpAlgorithms.Trace;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// nested class for my soluthin
public class Trace2 {
    static class KeePTrace2 {
        static String direction = "3";
        static int column;
        static int row = 0;

    }

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
        System.out.println("AlexSoluthion "+AlexSoluthion(a.length, a[0].length, a));

    }
    /* AlEX SOLUTHION */
    private static String AlexSoluthion(int R, int C, int[][] a) {
        // again same stuff like trace
        return IntStream.range(0, R * C).map(idx -> {
//            find column in row, column to change other column
            int col_r = idx / R;
// it assign shift , it increse 1 by 1, because range increase 1 by 1.That is why it is easy.
            int shift = idx % R;
// everytime our row must be increase or dicrease, if column is even it decrease , if is odd , it increase
            int row = (col_r&1)==0 ? shift : R-1-shift;
// it is for reverse column. start from end
            int col = C-1-col_r;
            return a[row][col];
        }).mapToObj(i -> String.valueOf(i))
                .collect(Collectors.joining(" "));
    }



    /* My soluthion */
//    nested class
    private static String MySoluthion(int R, int C, int[][] a) {
        KeePTrace2.column = C - 1;
        return IntStream.range(0, R * C-1).map(x -> {
            switch (KeePTrace2.direction) {
//                for printing first element , it will use only once. 3 is ele bele.
//                You can choose any number you want.
                case "3":
                KeePTrace2.direction = "0";
                break;
                case "0":
                    if (KeePTrace2.row != R-1) {
                        KeePTrace2.row++;
                    } else {
                        KeePTrace2.column--;
                        KeePTrace2.direction = "1";
                    }
                    break;
                case "1":
                    if (KeePTrace2.row != 0) {
                        KeePTrace2.row--;
                    } else {
                        KeePTrace2.column--;
                        KeePTrace2.direction = "0";
                    }
            }
            return a[KeePTrace2.row][KeePTrace2.column];
        }).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
