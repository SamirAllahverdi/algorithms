package hackerRank.recentImpls;


public class Anagram {


    /**
     * -https://www.hackerrank.com/challenges/anagram
     */
//    public static void main(String[] args) {
//        System.out.println(anagram("aazzbb"));
//    }


    public static int anagram(String s) {
        int n = s.length();

        if (n % 2 == 1)
            return -1;

        String first = s.substring(0, n / 2);
        String second = s.substring(n / 2);


        int[] characters = new int[27];
        for (char curr : first.toCharArray())
            characters[curr - 96]++;


        int minChange = 0;
        for (char curr : second.toCharArray())
            if (characters[curr - 96] > 0)
                characters[curr - 96]--;
            else
                minChange++;

        return minChange;
    }
}
