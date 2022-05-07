package hackerRank.recentImpls;

import java.util.List;

public class BeautifulTriplets {

    /**
     * https://www.hackerrank.com/challenges/beautiful-triplets
     */
//    public static void main(String[] args) {
//
//        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 7, 8, 10);
//        System.out.println(beautifulTriplets(3, integers));
//    }

    public static int beautifulTriplets(int d, List<Integer> arr) {

        int beautifulTriplets = 0;
        for (Integer el : arr) {
            int secondTriplet = el + d;
            int thirdTriplet = secondTriplet + d;
            if (arr.contains(secondTriplet) && arr.contains(thirdTriplet)) {
                beautifulTriplets++;
            }
        }
        return beautifulTriplets;
    }

}
