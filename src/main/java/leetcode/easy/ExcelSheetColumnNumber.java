package leetcode.easy;

public class ExcelSheetColumnNumber {

    /**
     * - https://leetcode.com/problems/excel-sheet-column-number
     */
//    public static void main(String[] args) {
//        System.out.println(titleToNumber("ACDE"));
//    }
    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (char ch : columnTitle.toCharArray()) {
            res = res * 26 + (ch - 'A') + 1;
        }
        return res;
    }
}
