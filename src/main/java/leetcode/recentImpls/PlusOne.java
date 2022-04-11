package leetcode.recentImpls;

public class PlusOne {


    /**
     * https://leetcode.com/problems/plus-one/
     */
//    public static void main(String[] args) {
//        int[] digits = {4, 3, 2, 1};
//        System.out.println(Arrays.toString(plusOne(digits)));
//    }


    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
