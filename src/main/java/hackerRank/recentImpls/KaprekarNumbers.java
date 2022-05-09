package hackerRank.recentImpls;

public class KaprekarNumbers {

    /**
     * https://www.hackerrank.com/challenges/kaprekar-numbers
     */
//
//    public static void main(String[] args) {
//        kaprekarNumbers(1, 100);
//    }


    public static void kaprekarNumbers(int p, int q) {

        boolean found = false;
        for (int a = p; a <= q; a++) {
            if (isKaprekarNumber(a)) {
                System.out.print(a + " ");
                found = true;
            }
        }

        if (!found)
            System.out.println("INVALID RANGE");


    }

    public static boolean isKaprekarNumber(int num) {
        long square = (long) num * num;

        String squareStr = String.valueOf(square);
        String leftStr = squareStr.substring(0, squareStr.length() / 2);
        String rightStr = squareStr.substring(squareStr.length() / 2);

        int left = leftStr.isEmpty() ? 0 : Integer.parseInt(leftStr);
        int right = rightStr.isEmpty() ? 0 : Integer.parseInt(rightStr);

        return left + right == num;
    }

}
