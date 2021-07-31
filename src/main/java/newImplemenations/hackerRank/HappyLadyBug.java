package newImplemenations.hackerRank;

import java.util.Arrays;

public class HappyLadyBug {

    /**
     * https://www.hackerrank.com/challenges/happy-ladybugs
     */

//    public static void main(String[] args) {
//        System.out.println(happyLadybugs("RBY_YBR")); /* expected YES */
//        System.out.println(happyLadybugs("X_Y__X"));  /* expected NO */
//    }

    public static String happyLadybugs(String b) {
        if (isHappy(b.toCharArray())) return "YES";
        if (!b.contains("_")) return "NO";

        char[] arr = b.toCharArray();
        Arrays.sort(arr);

        return isHappy(arr) ? "YES" : "NO";
    }


    static boolean isHappy(char[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '_') continue;
            boolean isLeftTheSame =
                    i - 1 >= 0 && arr[i - 1] == arr[i];
            boolean isRightTheSame =
                    i + 1 < arr.length && arr[i + 1] == arr[i];
            if (!(isLeftTheSame || isRightTheSame)) return false;
        }
        return true;
    }
}
