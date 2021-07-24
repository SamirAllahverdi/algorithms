package newImplemenations.hackerRank;

import java.util.List;

public class CtciBubbleSort {

    /**
     * https://www.hackerrank.com/challenges/ctci-bubble-sort
     */
//    public static void main(String[] args) {
//
//
//        countSwaps(Arrays.asList(6,4,1));
//
////        expected
////        Array is sorted in 3 swaps.
////        First Element: 1
////        Last Element: 6
//    }


    public static void countSwaps(List<Integer> list) {

        int count = 0;

        for (int a = 0; a < list.size(); a++) {
            for (int b = 0; b < list.size() - 1; b++) {
                if (list.get(b) > list.get(b + 1)) {
                    swap(b, b + 1, list);
                    count++;
                }
            }
        }


        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: " + list.get(0));
        System.out.println("Last Element: " + list.get(list.size() - 1));

    }

    private static void swap(int firstIndex, int secondIndex, List<Integer> list) {

        Integer temp = list.get(secondIndex);

        list.set(secondIndex, list.get(firstIndex));
        list.set(firstIndex, temp);
    }

}
