package leetcode.recentImpls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII {


    /**
     * https://leetcode.com/problems/pascals-triangle-ii
     */

//    public static void main(String[] args) {
//        System.out.println(generate(5));
//    }


    public static List<Integer> generate(int rowIndex) {
        List<List<Integer>> allRows = new ArrayList<>();
        List<Integer> firstRow = Collections.singletonList(1);
        allRows.add(firstRow);
        for (int a = 1; a < rowIndex; a++) {
            List<Integer> rowList = new ArrayList<>();
            List<Integer> preRow = allRows.get(a - 1);
            for (int b = 0; b < a + 1; b++) {
                if (b == 0 || b == a) {
                    rowList.add(1);
                } else {
                    rowList.add(preRow.get(b - 1) + preRow.get(b));
                }
            }
            allRows.add(rowList);
        }

        return allRows.get(rowIndex);
    }
}
