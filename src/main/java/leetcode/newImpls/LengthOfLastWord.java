package leetcode.newImpls;

public class LengthOfLastWord {

    /**
     * https://leetcode.com/problems/length-of-last-word
     */

//    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord("Hello World"));
//    }
//

    public static int lengthOfLastWord(String s) {

        int lastWordLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && lastWordLength > 0) {
                return lastWordLength;
            } else if (s.charAt(i) != ' ') {
                lastWordLength++;
            }
        }
        return lastWordLength;
    }
}
