package InterestingWarmUpAlgorithms.Trace;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Trace {

    /* STREAM WAY */
    public static String dataOrdered(int R, int C, int[][] m) {
        //    here we begin to iterate over all elements all 2-dimensinal array by R*C
        return IntStream.range(0, R * C)
//      then start to map all elements
                .map(idx -> {
//  here we assign row.Because of type int, it will give us integer value and as C is fixed,we get row
//   when it is more than C, it change to another row
                    int row = idx / C;
//      it is just shift.idx - row*C) we will give us shifting point like(shift++).
//      P.S: row *C never be same(except tam eded) because of it is int and ca return double ,then change to int
                    int shift = idx - row * C;
//       here we decide if it is even row then iterate ascending order,if not descending order
//                    it is bitwise operation and we just need last element (e.g ????1)
//                    (C-1-shift) means descending order
                    int col = (row & 1) == 0 ? shift : C - 1 - shift;
//           So at last return value .it is rule
                    return m[row][col];
                })
//                because of String type we must send all integer to String object
                .mapToObj(String::valueOf)
//                then collect all String object and delimiter " "
                .collect(Collectors.joining(" "));
    }

    /* ITERATIVE WAY */
    public static String dataOrderedIterative(int R, int C, int[][] m) {
        StringBuilder stringBuilder = new StringBuilder();
        int row = 0;
        int column = 0;
        while (row < R && column < C) {
///            here we decide if it is even row then iterate ascending order,if not descending order
            stringBuilder.append(((row % 2) == 0 ? m[row][column] : m[row][C - 1 - column])+" ");
            column++;
//            if column reach to C (one row length), increase row and reset zero
            if (column == C) {
                column = 0;
                row++;
            }
        }
        return stringBuilder.toString();
    }


    /* RECURSIVE WAY */

    public static String dataOrdered2(int R, int C, int[][] m) {
//        TAIL RECURSION
//        HERE we collect all the data in LinkedList.
//        After unwinding at last recursion list will fill with data and we stream it
        return dataOrdered2R(R, C, m, 0, new LinkedList<>()).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }


    public static List<Integer> dataOrdered2R(int R, int C, int[][] m, int idx, List<Integer> acc) {
        // BASE CASE
        if (idx == R * C) return acc;
        int row = idx / C;
        int shift = idx - row * C;
        int col = (row & 1) == 0 ? shift : C - 1 - shift;
//        Add to List
        acc.add(m[row][col]);
//        Go to another index by idx+1
        return dataOrdered2R(R, C, m, idx + 1, acc);
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
        System.out.println(dataOrdered(a.length, a[0].length, a));
        System.out.println(dataOrdered2(a.length, a[0].length, a));
        System.out.println(dataOrderedIterative(a.length, a[0].length, a));


    }
}