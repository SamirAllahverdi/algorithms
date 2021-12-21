package hackerRank.newImplemenations;

import java.util.Arrays;

public class ElectronicsShop {

    private static final int NOT_POSSIBLE_PRICE = -1;

    /**
     * https://www.hackerrank.com/challenges/electronics-shop
     */
//    public static void main(String[] args) {
//        int[] keyboards = {3, 1};
//        int[] drives = {5, 2, 8};
//        int b = 10;
//        System.out.println(getMoneySpent(keyboards,drives,b));
//    }


    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int mostExpensiveKeyboardAndUSBPrice = NOT_POSSIBLE_PRICE;
        for (int keyboard : keyboards) {
            int currKeyboardAndUSBPrice = -1;
            for (int drive : drives) {
                if (keyboard + drive > b) break;
                currKeyboardAndUSBPrice = keyboard + drive;
            }
            mostExpensiveKeyboardAndUSBPrice = Math.max(currKeyboardAndUSBPrice, mostExpensiveKeyboardAndUSBPrice);
        }

        return mostExpensiveKeyboardAndUSBPrice;
    }


}
