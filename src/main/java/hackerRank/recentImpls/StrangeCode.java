package hackerRank.recentImpls;

public class StrangeCode {

    /**
     * https://www.hackerrank.com/challenges/strange-code
     */
//    public static void main(String[] args) {
//        System.out.println(strangeCounter(3));
//    }

    public static long strangeCounter(long t) {
        long v = 4;
        while (v <= t)
            v = v * 2 + 2;
        return v - t;
    }

}
