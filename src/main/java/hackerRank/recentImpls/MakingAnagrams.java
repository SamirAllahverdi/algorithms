package hackerRank.recentImpls;

public class MakingAnagrams {
    /**
     * https://www.hackerrank.com/challenges/making-anagrams
     */

//    public static void main(String[] args) {
//        System.out.println(makingAnagrams("abcd","cder"));
//    }
    public static int makingAnagrams(String s1, String s2) {

        int[] chars = new int[26];

        for (char el : s1.toCharArray()) {
            chars[el - 'a']++;
        }
        for (char el : s2.toCharArray()) {
            chars[el - 'a']--;
        }

        int count = 0;
        for (int el : chars) {
            count += Math.abs(el);
        }

        return count;
    }
}
