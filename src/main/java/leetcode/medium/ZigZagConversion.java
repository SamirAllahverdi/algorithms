package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    /**
     * https://leetcode.com/problems/zigzag-conversion/
     */

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(convert(s, numRows));

    }


    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = initList(Math.min(numRows, s.length()));

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        return conToString(rows);
    }

    private static String conToString(List<StringBuilder> rows) {
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    private static List<StringBuilder> initList(int minLength) {
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < minLength; i++) {
            rows.add(new StringBuilder());
        }
        return rows;
    }


}

