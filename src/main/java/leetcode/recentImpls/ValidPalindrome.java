package leetcode.recentImpls;

public class ValidPalindrome {

    /**
     * https://leetcode.com/problems/valid-palindrome/
     */
//    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//    }

    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char leftChar = s.charAt(l);
            char rightChar = s.charAt(r);

            if (!isAlphanumericCharacter(leftChar)) {
                l++;
                continue;
            }

            if (!isAlphanumericCharacter(rightChar)) {
                r--;
                continue;
            }

            leftChar = ToLowerCase(leftChar);
            rightChar = ToLowerCase(rightChar);

            if (leftChar != rightChar) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }


    public static char ToLowerCase(char a) {
        return isLowerCase(a) || isNumber(a) ? a : (char) ((int) a + 32);
    }


    public static boolean isAlphanumericCharacter(char a) {
        return isUpperCase(a) || isLowerCase(a) || isNumber(a);
    }


    public static boolean isUpperCase(char a) {
        return (a >= 65 && a <= 90);
    }


    public static boolean isLowerCase(char a) {
        return (a >= 97 && a <= 122);
    }

    public static boolean isNumber(char a) {
        return (a >= 48 && a <= 57);
    }


}
