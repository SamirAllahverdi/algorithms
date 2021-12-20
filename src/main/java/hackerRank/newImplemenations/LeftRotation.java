package hackerRank.newImplemenations;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    /**
     * https://www.hackerrank.com/challenges/ctci-array-left-rotation/
     */
//    public static void main(String[] args) {
//
//        List<Integer> elements =
//                Arrays.asList(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51);
//
//        System.out.println(rotLeft(elements, 10));
//        // expected 77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77
//    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {

        int rotation = d % a.size();
        List<Integer> rotatedList = fillList(a.size());

        /* Start from End */
        for (int b = a.size() - 1; b >= 0; b--) {

            int element = a.get(b);
            int newIndex = b - rotation;

            if (newIndex >= 0) {
                rotatedList.set(newIndex, element);
            } else {
                rotatedList.set(a.size() - Math.abs(newIndex), element);
            }
        }

        return rotatedList;
    }

    private static List<Integer> fillList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int b = 0; b < size; b++) {
            list.add(0);
        }
        return list;
    }
}
