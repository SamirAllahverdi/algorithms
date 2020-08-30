package leetcode.easy;

import java.util.*;

public class TheKWeakestRowsInMatrix {


    /**
     * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
     */

    public static void main(String[] args) {

        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k = 3;
//  first
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));

//  second
        System.out.println(Arrays.toString(kWeakestRows2(mat, k)));

    }

    /**
     * - first solution -
     */

    public static int[] kWeakestRows(int[][] mat, int k) {

        if (mat == null) return null;

        Map<Integer, Integer> map = fillHashMap(mat);

        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private static Map<Integer, Integer> fillHashMap(int[][] mat) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int a = 0; a < mat.length; a++) {
            int countSol = 0;
            for (int b = 0; b < mat[0].length; b++) {
                if (mat[a][b] == 0) {
                    break;
                } else {
                    countSol++;
                }
            }
            hashMap.put(a, countSol);
        }
        return hashMap;
    }


    /**
     * - second solution -
     */

    public static int[] kWeakestRows2(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            queue.offer(new int[] {numOnes(mat[i]), i});
            if (queue.size() > k)
                queue.poll();
        }

        while (k > 0)
            ans[--k] = Objects.requireNonNull(queue.poll())[1];

        return ans;
    }

    private static int numOnes(int[] row) {
        int left = 0;
        int right = row.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == 1)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
