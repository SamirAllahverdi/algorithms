package hackerRank.recentImpls;

import java.util.*;

public class TwoCharacters {

    /**
     * - https://www.hackerrank.com/challenges/two-characters
     */
//    public static void main(String[] args) {
//        System.out.println(alternate("abbacced"));
//    }

    private static int alternatingLength(String orig, char a, char b) {
        Stack<Character> stack = new Stack<>();

        for (char el : orig.toCharArray()) {
            if (el == a || el == b) {
                if (stack.isEmpty() || stack.peek() != el)
                    stack.push(el);
                else
                    return -1;
            }
        }

        return stack.size();
    }

    public static int alternate(String s) {
        List<Character> uniqueList = getUniqueList(s);

        int longestStringLength = 0;
        for (int i = 0; i < uniqueList.size(); i++) {
            for (int j = i + 1; j < uniqueList.size(); j++) {
                int stringLength = alternatingLength(s, uniqueList.get(i), uniqueList.get(j));
                longestStringLength = Math.max(longestStringLength, stringLength);
            }
        }

        return longestStringLength;
    }

    private static List<Character> getUniqueList(String s) {
        Set<Character> hashSet = new HashSet<>();
        for (char el : s.toCharArray())
            hashSet.add(el);

        return new ArrayList<>(hashSet);
    }
}
