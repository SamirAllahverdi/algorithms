package hackerRank.recentImpls;

public class CountingValleys {

    /**
     * https://www.hackerrank.com/challenges/counting-valleys
     */

//    public static void main(String[] args) {
//        System.out.println(countingValleys(8, "UDDDUDUU"));  //expected 1
//        System.out.println(countingValleys(12,"DDUUDDUDUUUD")); //expected 2
//    }

    public static int countingValleys(int steps, String path) {

        int current = 0;
        int countValley = 0;

        for (int a = 0; a < steps; a++) {

            if (path.charAt(a) == 'U') {
                ++current;
            } else {
                --current;
                if (current == -1) {
                    ++countValley;
                }
            }
        }

        return countValley;
    }

}

