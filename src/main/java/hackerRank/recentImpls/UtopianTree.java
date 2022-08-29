package hackerRank.recentImpls;

public class UtopianTree {

    /**
     *  https://www.hackerrank.com/challenges/utopian-tree
     */

//    public static void main(String[] args) {
//        System.out.println(utopianTree(4));
//    }

    public static int utopianTree(int n) {
        int height = 1;
        for (int a = 1; a <= n; a++)
            if (a % 2 == 1)
                height *= 2;
            else
                height += 1;

        return height;
    }


}
