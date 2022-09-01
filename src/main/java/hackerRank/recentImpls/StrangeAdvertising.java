package hackerRank.recentImpls;

public class StrangeAdvertising {

    /**
     * - https://www.hackerrank.com/challenges/strange-advertising
     */

//    public static void main(String[] args) {
//        System.out.println(viralAdvertising(3));
//    }


    public static int viralAdvertising(int n) {

        int totalLiked = 0;

        int shared = 5;
        for (int a = 1; a <= n; a++) {
            int liked = shared / 2;
            totalLiked += liked;
            shared = liked * 3;
        }


        return totalLiked;
    }
}
