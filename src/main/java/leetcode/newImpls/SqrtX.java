package leetcode.newImpls;

public class SqrtX {

    /**
     * https://leetcode.com/problems/sqrtx
     */
//    public static void main(String[] args) {
//
//        System.out.println(mySqrt(8));
//    }


    public static int mySqrt(int x) {
        long start = 0;
        long end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end == x) {
            return (int) end;
        }
        return (int) start;
    }
}
