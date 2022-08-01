package hackerRank.recentImpls;

public class ChocolateFeast {


    /*
     * https://www.hackerrank.com/challenges/chocolate-feast
     */
//    public static void main(String[] args) {
//
//        System.out.println(chocolateFeast(6,2,2));
//    }


    public static int chocolateFeast(int n, int c, int m) {
        int chocolate = n / c;
        return chocolate + getFreeChocolate(chocolate, m, 0);
    }


    public static int getFreeChocolate(int wrappers, int m, int free) {
        if (wrappers < m)
            return free;

        return getFreeChocolate(wrappers - m + 1, m, ++free);
    }

}
