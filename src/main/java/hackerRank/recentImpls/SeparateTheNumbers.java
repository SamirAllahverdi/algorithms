package hackerRank.recentImpls;

public class SeparateTheNumbers {

    /**
     * - https://www.hackerrank.com/challenges/separate-the-numbers
     */

//    public static void main(String[] args) {
//        separateNumbers("91011");
//    }


    public static void separateNumbers(String str) {
        int n = str.length();

        for (int i = 1; i <= n / 2; i++) {
            StringBuilder customSequence = new StringBuilder(str.substring(0, i));
            long v = Long.parseLong(customSequence.toString());

            while (customSequence.length() < n) {
                customSequence.append(++v);
            }

            if (customSequence.toString().equals(str)) {
                String first = str.substring(0, i);
                System.out.println("YES " + first);
                return;
            }
        }

        System.out.println("NO");
    }

}
