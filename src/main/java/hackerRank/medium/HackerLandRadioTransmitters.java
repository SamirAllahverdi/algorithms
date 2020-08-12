package hackerRank.medium;

import java.util.Arrays;

public class HackerLandRadioTransmitters {

    /**
     * https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
     */

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 1;
        System.out.println(Arrays.toString(array));
        System.out.println(transmitterNumber(array, k));
    }

    public static int transmitterNumber(int[] houses, int range) {

        Arrays.sort(houses);

        int transmitterHouse, lastHouse = 0, result =0 , i = 0;

        boolean startOver = true;

        while (i < houses.length) {

            if (startOver) {
                lastHouse = houses[i];
                result++;
                startOver = false;
            } else {
                //find location for next transmitter
                while (i < houses.length && (houses[i] - lastHouse) <= range) {
                    ++i;
                }
                transmitterHouse = houses[i - 1];

                //find location for last house in range of transmitter
                while (i < houses.length && houses[i] <= transmitterHouse + range) {
                    ++i;
                }

                startOver = true;
            }
        }
        return result;
    }
}
