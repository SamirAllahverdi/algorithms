package hackerRank.newImplemenations;

import java.util.stream.IntStream;

public class SherlockAndAnagram {

//    public static void main(String[] args) {
//        System.out.println(sherlockAndAnagrams("cdcd"));
//    }

    static int sherlockAndAnagrams(String s) {
        return IntStream.range(1, s.length())
                .map(a -> findCount(a, s)).sum();

    }

    private static int findCount(int a, String word) {
        int count = 0;
        for (int c = 0; c < word.length() - a; c++) {
            String substring1 = word.substring(c, c + a);
            for (int b = c + 1; b <= word.length() - a; b++) {
                String substring2 = word.substring(b, b + a);
                if (IsAnagram(substring1, substring2)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean IsAnagram(String substring1, String substring2) {
        int[] letters = new int[26];

        for (int j = 0; j < substring1.length(); j++) {
            letters[substring1.charAt(j) - 'a']++;
            letters[substring2.charAt(j) - 'a']--;
        }

        return IntStream.range(0, letters.length)
                .noneMatch(a -> letters[a] != 0);
    }


}
