package leetcode.easy;

public class SplitAStringBalancedString {


    public static void main(String[] args) {
        String a = "RLRRLLRLRL";

//       For first
        System.out.println(balancedStringSplit(a));

//       For second
        System.out.println(balancedStringSplit2(a));

//       For third
        System.out.println(balancedStringSplit3(a));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        int idx = 0;

        int L = 0;
        int R = 0;

        boolean restart = false;

        while (idx < s.length()) {
            if (restart) {
                R = 0;
                L = 0;
                restart = false;
            }
            if (s.charAt(idx) == 'L') {
                L++;
            } else {
                R++;
            }
            if (L == R) {
                count++;
                restart = true;
            }
            idx++;
        }
        return count;
    }

    public static int balancedStringSplit2(String s) {
        int l = 0, r = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') l++;
            else r++;
            if (l == r) res++;
        }
        return res;
    }

    public static int balancedStringSplit3(String s) {
        int bal = 0, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            bal += s.charAt(i) == 'L' ? 1 : -1;
            if (bal == 0) ++res;
        }
        return res;
    }
}
