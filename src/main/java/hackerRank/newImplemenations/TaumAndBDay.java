package hackerRank.newImplemenations;

public class TaumAndBDay {

    /**
     * https://www.hackerrank.com/challenges/taum-and-bday/problem
     */
//    public static void main(String[] args) {
//        System.out.println(taumBday(3,5,3,4,1));
//        // expected 29
//    }

    public static long taumBday(long b, long w, long bc, long wc, long z) {
        return b * Math.min(bc, wc + z) + w * Math.min(wc, bc + z);
    }

}
