import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String a = "ABCD";

//        System.out.println("Original: " + a);
//        System.out.println(shift(a, 3, 2));


        List<Integer> abb = new ArrayList<>(Arrays.asList(4, 5, 6));
        abb.add(3);
        System.out.println(abb);


    }


    public static String shift(String orig, int toLeft, int toRight) {
        int left = toLeft % 4;
        int right = toRight % 4;
        char[] byIndex = orig.toCharArray();
        char previous;
        int shiftingIndex = 0;
        if (left != 4) {
            for (int b = 0; b < left; b++) {
                previous = byIndex[0];
                byIndex[0] = byIndex[byIndex.length - 1];
                for (int a = 1; a < byIndex.length; a++) {
                    char tmp = byIndex[a];
                    byIndex[a] = previous;
                    previous = tmp;
                }
            }
        }
        if (right != 4) {
            for (int b = 0; b < right; b++) {
                previous = byIndex[byIndex.length - 1];
                byIndex[byIndex.length - 1] = byIndex[0];
                for (int a = byIndex.length - 2; a >= 0; a--) {
                    char tmp = byIndex[a];
                    byIndex[a] = previous;
                    previous = tmp;
                }
            }

        }

        System.out.println(Arrays.toString(byIndex));
        return "sd";
    }

    static int jumpingOnClouds(int[] c) {
        int count = 0;
        int i = 0;
        System.out.println(i);
        while (i < c.length - 1) {
            if (i + 2 < c.length && c[i + 2] != 1) {
                i = i + 2;
                System.out.println("if statement: " + i);
            } else {
                i++;
                System.out.println("else statement: " + i);
            }

            count++;
        }
        return count;
    }

}



