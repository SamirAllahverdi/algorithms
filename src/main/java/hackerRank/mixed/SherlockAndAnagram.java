package hackerRank.mixed;

import java.util.stream.IntStream;

public class SherlockAndAnagram {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String test = "cdcd";
        System.out.println(sherlockAndAnagrams(test));

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed);
    }



    static int sherlockAndAnagrams(String s) {
        return IntStream.range(1, s.length()).map(a -> findCount(a, s)).reduce(0, Integer::sum);
    }

    private static int findCount(int a, String s) {
        int count = 0;
        for (int c = 0; c < s.length() - a; c++) {
            String st = s.substring(c, c + a);
            for (int b = c + 1; b <= s.length() - a; b++) {
                String st2 = s.substring(b, b + a);
                if (IsAnagram(st, st2)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean IsAnagram(String st, String st2) {
        int[] lettermap = new int[26];
        for (int j = 0; j < st.length(); j++) {
            char ch = st.charAt(j);
            lettermap[ch - 'a']++;
            ch = st2.charAt(j);
            lettermap[ch - 'a']--;
        }
        return IntStream.range(0, lettermap.length).anyMatch(a -> lettermap[a] != 0) ? false : true;
    }

}
