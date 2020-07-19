package hackerRank.mixed;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class GemstoneDiscussion {
    public static void main(String[] args) {
        String[] array = {"abcdde", "baccd", "eeabg"};
        System.out.println(gemstones(array));
    }


    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int[] count = new int[26];
        Set<Character> hashSet = new HashSet<>();
        for (int a = 0; a < arr.length; a++) {
            for (char b : arr[a].toCharArray()) {
                hashSet.add(b);
            }
            hashSet.forEach(c -> count[c - 'a']++);
            hashSet.clear();
        }
        int total = 0;
        for (int i : count) {
            if (i >= arr.length) total++;
        }
        return total;
    }


}
