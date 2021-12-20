package hackerRank.newImplemenations;

import java.util.Arrays;

public class FlatlandSpaceStations {

    /**
     * https://www.hackerrank.com/challenges/flatland-space-stations
     */
//    public static void main(String[] args) {
//        int[] citiesHaveSpaceCitations = {0, 4};
//        System.out.println(
//                flatlandSpaceStations(5, citiesHaveSpaceCitations));
////        expected 2
//    }

    public static int flatlandSpaceStations(int n, int[] arr) {

        Arrays.sort(arr);
        int maxDistance = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int distance = (arr[i] - arr[i - 1]) / 2;
            maxDistance = Math.max(maxDistance, distance);
        }

        int lastGap = (n - 1) - arr[arr.length - 1];
        return Math.max(maxDistance, lastGap);
    }
}
