package leetcode.medium;

public class CountAndSay {

    /**
     * https://leetcode.com/problems/count-and-say
     */
//    public static void main(String[] args) {
//        System.out.println(recursion(5));
//    }


    public static String recursion(int n) {
        if (n == 1)
            return "1";

        String result = recursion(n - 1);

        StringBuilder builder = new StringBuilder();
        int count = 1;

        for (int a = 0; a < result.length(); a++) {
            if (a == result.length() - 1) {
                builder.append(count).append(result.charAt(a));
            } else {
                if (result.charAt(a) == result.charAt(a + 1)) {
                    count++;
                } else {
                    builder.append(count).append(result.charAt(a));
                    count = 1;
                }
            }
        }

        return builder.toString();
    }
}
