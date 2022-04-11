package leetcode.recentImpls;

import java.util.Map;

public class RomanToInteger {

    static Map<Character, Integer> symbols = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public static int romanToInt(String s) {
        int total = symbols.get(s.charAt(s.length() - 1));
        for (int a = 1; a < s.length(); a++) {
            Integer curr = symbols.get(s.charAt(a));
            Integer beforeCurr = symbols.get(s.charAt(a - 1));
            if (beforeCurr < curr) {
                total -= beforeCurr;
            } else {
                total += beforeCurr;
            }
        }
        return total;
    }

    /**
     * https://leetcode.com/problems/roman-to-integer/
     */
//    public static void main(String[] args) {
//        System.out.println(romanToInt("MCMXCIV")); //1994
//        System.out.println(romanToInt("LVIII"));//58
//        System.out.println(romanToInt("IX"));//9
//        System.out.println(romanToInt("X"));//10
//    }
}
