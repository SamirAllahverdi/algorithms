package hackerRank.recentImpls;

public class DrawingBook {

    /**
     * https://www.hackerrank.com/challenges/drawing-book
     */

//    public static void main(String[] args) {
//        System.out.println(pageCount(6,5));
//    }

    public static int pageCount(int n, int p) {
        return p/2 <= n/2-p/2 ? p/2 : n/2-p/2;
    }


}
