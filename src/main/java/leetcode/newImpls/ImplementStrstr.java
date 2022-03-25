package leetcode.newImpls;

public class ImplementStrstr {

    /**
     * https://leetcode.com/problems/implement-strstr/
     */
//    public static void main(String[] args) {
//        System.out.println(strStr("hello", "ll"));
//    }


    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        for (int a = 0; a < haystack.length(); a++) {
            if (a + needle.length() > haystack.length()) return -1;

            boolean isEqual = true;
            for (int b = 0; b < needle.length(); b++) {
                if (needle.charAt(b) != haystack.charAt(a + b)) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                return a;
            }
        }


        return -1;
    }

}
