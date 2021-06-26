package newAlgorithms.hackerRank;

public class Kangaroo {

//    /**
//     * https://www.hackerrank.com/challenges/kangaroo
//     */
//    public static void main(String[] args) {
//        System.out.println(kangaroo(0, 2, 5, 3)); /* expected NO */
//        System.out.println(kangaroo(0, 3, 4, 2));  /* expected YES */
//    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        return v1 > v2  &&  (x1 - x2) % (v2 - v1) == 0
                ? "YES" : "NO";
    }
}
