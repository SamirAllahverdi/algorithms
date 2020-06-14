package InterestingWarmUpAlgorithms.Trace;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TraceCompicatedOne {
    static class KeePTrace {
        static String direction = "0";
        //        direction asagi = 1 , yuxari 2
        static int column = 0;
     static int row = 0;

    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4,},
                {5, 6, 7, 8,},
                {9, 10, 11, 12,},
                {13, 14, 15, 16,},
                {17, 18, 19, 20,},
                {21, 22, 23, 24,},
                {25, 26, 27, 28,},
        };
//        System.out.println("MySoluthion " + MySoluthion(a.length, a[0].length, a));
        System.out.println("Recursion " + MySoluthion2(a.length, a[0].length, a));

    }

    private static String MySoluthion2(int length, int length1, int[][] a) {

        return recursive(length, length1, a);
    }

    private static String recursive(int R, int C, int[][] a) {
        if (KeePTrace.column == C-1  && KeePTrace.row == R-1 ) {
            return "" + a[KeePTrace.row][KeePTrace.column];
        }
        switch (KeePTrace.direction) {
            case "0":
                KeePTrace.column++;
                KeePTrace.direction = "1";
                break;
            case "1":
                if (KeePTrace.column == 0) {
                    KeePTrace.row++;
                    KeePTrace.direction = "2";
                } else if (KeePTrace.row == R - 1) {
                    KeePTrace.column++;
                    KeePTrace.direction = "2";
                } else {
                    KeePTrace.column--;
                    KeePTrace.row++;
                }
                break;
            case "2":
                if (KeePTrace.row == 0) {
                    KeePTrace.column++;
                    KeePTrace.direction = "1";
                } else if (KeePTrace.column == C - 1) {
                    KeePTrace.row--;
                    KeePTrace.direction = "1";
                } else {
                    KeePTrace.column++;
                    KeePTrace.row--;
                }
        }
        return a[KeePTrace.row][KeePTrace.column] + " "+recursive(KeePTrace.row, KeePTrace.column, a) ;
    }

    private static String MySoluthion(int R, int C, int[][] a) {
        KeePTrace trace = new KeePTrace();
        return IntStream.range(0, R * C).map(x -> {
//            here it is essential to define value top of the switch.
//            because of printing first element of array(0)
//            So it a[0][0] assign to val , then go to inside switch
//            and here column and row increased,but value does not change
//            after return statement value increase , either.
            int val = a[trace.row][trace.column];
            switch (trace.direction) {
//                for printing first element , it will use only once.
                case "0":
                    trace.column++;
                    trace.direction = "1";
                    break;
                case "1":
                    if (trace.column == 0) {
                        trace.row++;
                        trace.direction = "2";
                    } else if (trace.row == R - 1) {
                        trace.column++;
                        trace.direction = "2";
                    } else {
                        trace.row++;
                        trace.column--;
                    }
                    break;
                case "2":
                    if (trace.column == C - 1) {
                        trace.row--;
                        trace.direction = "1";
                    } else if (trace.row == 0) {
                        trace.column++;
                        trace.direction = "1";
                    } else {
                        trace.row--;
                        trace.column++;
                    }
            }
            return val;
        }).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
