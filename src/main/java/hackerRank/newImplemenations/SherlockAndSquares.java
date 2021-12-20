package hackerRank.newImplemenations;

public class SherlockAndSquares {

    public static final int NO_WHOLE_SQUARE_ROOT_FOUND = 0;

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-squares
     */
//    public static void main(String[] args) {
//        System.out.println(squares(17, 24)); /*expected 0 */
//        System.out.println(squares(24,49));  /* expected 3 */
//    }


    public static int squares(int a, int b) {
        int squareRoot = findFirstSquareNumber(a, b);
        if (squareRoot == NO_WHOLE_SQUARE_ROOT_FOUND) return 0;

        int count = 0;
        do {
            squareRoot++;
            count++;
        } while (squareRoot * squareRoot <= b);

        return count;
    }

    private static int findFirstSquareNumber(int start, int end) {

        for (int a = start; a <= end; a++) {
            double squareRoot = Math.sqrt(a);
            if (isSquareRootWholeNumber(squareRoot)) {
                return (int) squareRoot;
            }
        }
        return NO_WHOLE_SQUARE_ROOT_FOUND;
    }

    private static boolean isSquareRootWholeNumber(double squareRoot) {
        return squareRoot % 1 == 0;
    }
}
