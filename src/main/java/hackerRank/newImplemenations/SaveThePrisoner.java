package hackerRank.newImplemenations;

public class SaveThePrisoner {

    /**
     * https://www.hackerrank.com/challenges/save-the-prisoner
     */
//    public static void main(String[] args) {
//
//        System.out.println(saveThePrisoner(4, 6, 2)); //expected 3
//    }


    public static int saveThePrisoner(int n, int m, int s) {
        return ((m - 1) + (s - 1)) % n + 1;
    }

}
