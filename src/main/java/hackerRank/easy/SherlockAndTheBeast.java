package hackerRank.easy;

public class SherlockAndTheBeast {

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
     */

    public static void main(String[] args) {
        int number = 11;
        decentNumber(number);
    }

    static void decentNumber(int n) {
        if (n < 3) System.out.println(-1);
        else if (n % 5 == 0) System.out.println(getDecent(n, 3));
        else if (n % 3 == 0) System.out.println(getDecent(n, 5));
        else System.out.println(decent(n));
    }

    private static String getDecent(int n, int c) {
        StringBuilder st = new StringBuilder();
        for (int a = 0; a < n; a++) {
            st.append(c);
        }
        return st.toString();
    }

    private static String decent(int n) {
        StringBuilder st = new StringBuilder();

        for (int a = 0; a < n; a++) {
            st.append(5);
        }

        return st.toString();
    }


}
