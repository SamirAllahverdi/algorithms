package hackerRank.easy;

import java.util.*;
import java.util.stream.IntStream;

public class MakingAnagrams {
    public static void main(String[] args) {
        String s1 = "absdjkvuahdakejfnfauhdsaavasdlkj";
        String s2 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";

        System.out.println(makingAnagrams(s1, s2));

    }

    static int makingAnagrams(String s1, String s2) {

        int[] chars = new int[26];
        for (char c1 : s1.toCharArray()) {
            chars[c1 - 'a']++;
        }

        for (char c2 : s2.toCharArray()) {
            chars[c2 - 'a']--;
        }

        return Arrays.stream(chars).filter(a -> a != 0).map(Math::abs).reduce(Integer::sum).orElse(0);
    }

    static int makingAnagramsOptimized(String s1, String s2) {
        int[] freq = new int[26];
        s1.chars().forEach(c -> freq[c - 'a']++);
        s2.chars().forEach(c -> freq[c - 'a']--);
        return Arrays.stream(freq).map(Math::abs).sum();
    }
}
