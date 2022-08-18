package hackerRank.recentImpls;

public class CatsAndMouse {

    /**
     * - https://www.hackerrank.com/challenges/cats-and-a-mouse
     */
//    public static void main(String[] args) {
//        System.out.println(catAndMouse(1, 3, 2));
//    }
    static String catAndMouse(int x, int y, int z) {

        int a = Math.abs(x - z);
        int b = Math.abs(y - z);

        if (a == b)
            return "Mouse C";
        else if (a < b)
            return "Cat A";
        else
            return "Cat B";
    }

}
