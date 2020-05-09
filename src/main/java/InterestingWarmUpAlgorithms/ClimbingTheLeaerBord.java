package InterestingWarmUpAlgorithms;

import jdk.swing.interop.SwingInterOpUtils;
import org.eclipse.jetty.util.InetAddressSet;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ClimbingTheLeaerBord {
    public static void main(String[] args) {
        System.out.println("Alice's scores: " + Arrays.toString(climbingLeaderboard(new int[]{100, 90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102})));
        System.out.println("Alice's scores: " + Arrays.toString(climbingLeaderboard2(new int[]{100, 90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102})));

    }
// my favorite
    static int[] climbingLeaderboard2(int[] scores, int[] alice) {
        int results[] = new int[alice.length];
        int rank = 1;
        int rankScore = scores[0];
// begin to iteration over alice[]
        for (int a = alice.length - 1, s = 0; a >= 0; a--) {
            System.out.println( a + " iteration:");
//            if it is higher than 0 index of scores which is highest do not go inside if
            if (alice[a] < rankScore) {
                for (; s < scores.length; s++) {
                    System.out.println(scores[s] + " compare " + rankScore);
                    if (scores[s] < rankScore) {
                        rank++;
                        rankScore = scores[s];
                    }
                    if(alice[a] >= scores[s]) break;
                }
            }
            results[a] = (s == scores.length) ? rank + 1 : rank;
            System.out.println(results[a]);
        }

        return results;
    }

// with binary seacrch
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int n = scores.length;
        int m = alice.length;
// https://www.youtube.com/channel/UCx1hbK753l3WhwXP5r93eYA/videos
//        first for rank we define rank array and result for result
        int res[] = new int[m];
        int[] rank = new int[n];
//first result will be 1 because of descending order
        rank[0] = 1;
//fill rank array
        for (int i = 1; i < n; i++) {
//            if next elemet is same as previous, define previous rank to next
            if (scores[i] == scores[i - 1]) {
                rank[i] = rank[i - 1];
            } else {
//                if not increment by one
                rank[i] = rank[i - 1] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int aliceScore = alice[i];
//            if  alicescore higher than 0 then it is 1
            if (aliceScore > scores[0]) {
                res[i] = 1;
//                if less than last one it is length +1
            } else if (aliceScore < scores[n - 1]) {
                res[i] = rank[n - 1] + 1;
            } else {
//                go to binary search
                int index = binarySearch(scores, aliceScore);
                res[i] = rank[index];

            }
        }
        return res;

    }

    private static int binarySearch(int[] a, int key) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return mid;
            }
//             if it is not in array, then we need this else if statement. Debug yourself understand)))
//            descending order
            else if (a[mid] < key && key < a[mid - 1]) {
                return mid;
            } else if (a[mid] > key && key > a[mid + 1]) {
                return mid + 1;
            } else if (a[mid] < key) {
                hi = mid - 1;
            } else if (a[mid] > key) {
                lo = mid + 1;
            }
        }
        return -1;
    }


}


