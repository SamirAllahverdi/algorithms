package leetcode.newImpls;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {


//    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(123421));
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(123));
//    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
