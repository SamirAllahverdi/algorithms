package hackerRank.easy;

public class TaumAndBDay {
    /**
     * https://www.hackerrank.com/challenges/taum-and-bday/problem
     */
    public static void main(String[] args) {
        System.out.println(taumBday(3, 3, 1, 9, 2));
    }


    public static long taumBday(long b, long w, long bc, long wc, long z) {
        if (z + bc < wc) {
            long newWc = bc + z;
            return b * bc + newWc * w;
        } else if (z + wc < bc) {
            long newBc = wc + z;
            return b * newBc + wc * w;
        }
        return b * bc + w * wc;
    }

    public static long taumBdayWithTernary(long b, long w, long bc, long wc, long z) {
        return z + bc < wc ? b * bc + (bc + z) * w : z + wc < bc ? b * (wc + z) + wc * w : b * bc + w * wc;
    }
}
