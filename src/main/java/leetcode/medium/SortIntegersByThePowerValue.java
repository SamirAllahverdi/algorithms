package leetcode.medium;

import java.util.*;

public class SortIntegersByThePowerValue {

    /**
     * https://leetcode.com/problems/sort-integers-by-the-power-value/
     */

    public static void main(String[] args) {

        int lo = 7;
        int hi = 11;
        int k = 4;
        System.out.println(getKth(lo, hi, k));

    }

    public static int getKth(int lo, int hi, int k) {
        if (lo == hi) return lo;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int curr = lo; curr <= hi; curr++) {
            int pow = findPower(curr, 0);
            pq.offer(new int[]{curr, pow});
        }

        while (!pq.isEmpty() && k-- > 1) {
            pq.poll();
        }

        return Objects.requireNonNull(pq.poll())[0];
    }

    private static int findPower(int el, int power) {
        if (el == 1) return power;
        return findPower(el % 2 == 0 ? el / 2 : el * 3 + 1, power + 1);
    }
}
