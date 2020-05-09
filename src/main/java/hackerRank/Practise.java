package hackerRank;

import Practice.Main;

import javax.swing.plaf.IconUIResource;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Practise {


    public static void main(String[] args) {
        String valley = "DDUUDDUDUUUD";
//        System.out.println("Count Valley: " + countingValleys(valley.length(), valley));

        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2));
    }

    static int[] permutationEquation(int[] p) {
//        Object[] objects = IntStream.rangeClosed(1, p.length).boxed().map(a -> IntStream.range(0, p.length).filter(c -> p[c] == a)).toArray();
//       2,3,1
        int[] sequence = new int[p.length];
        for (int a = 1; a <= p.length; a++) {
//            1,2,3,4,5
            for (int b = 0; b < p.length - 1; b++) {
                if (a == p[b + 1]) {
                    sequence[a - 1] = b + 1;
                }
            }
        }
        return sequence;
    }


    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        for (int a = 0; a < c.length; ) {
            if (c[a] == 1) {
                energy = energy - 3;
                if (c[c.length - 1] == 1) {


                }
            } else {
                energy = energy - 1;
            }
        }
        return energy;
    }


    static int countingValleys(int n, String s) {
        int count = 0;
        int current = 0;
        for (int a = 0; a < n; a++) {
            if (s.charAt(a) == 'U') {
                if (current == -1) {
                    count++;
                }
                current++;
            } else {
                current--;
            }
        }
        return count;
    }


    static int pageCount(int n, int p) {

        int second;
        int first = p / 2;
        if ((n % 2 != 0 && n - 1 == p) || p == n || p == 1) {
            System.out.println("s");
            return 0;
        } else if (n % 2 == 0 && p % 2 != 0) {
            System.out.println(((6 - 3) / 2) + 1);
            second = ((n - p) / 2) + 1;
            System.out.println("second:" + second);
            return Math.min(first, second);
        }
        second = (n - p) / 2;
        return Math.min(first, second);
    }

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        int divby400 = year / 100;
        System.out.println(divby400);
        if (year < 1918) {
            if (year % 4 == 0) {
                return "12.09." + year;
            } else {
                return "13.09." + year;
            }
        } else if (year > 1918) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return "12.09." + year;
            } else {
                return "13.09." + year;
            }
        } else {
            return "30.09." + year;
        }

    }
//
//    static int countingValleys(int n, String s) {
//        int valleyEnterAndExit = 0;
//        int previousPosition = 0;
//        int currentPosition = 0;
//        int seaLevel = 0;
//        for (int a = 0; a < s.length(); a++) {
//            previousPosition = currentPosition;
//            if (seaLevel == currentPosition && previousPosition >= 0) {
//                valleyEnterAndExit++;
//            }
//            if (s.charAt(a) == 'D') {
//                currentPosition--;
//            } else { // s.charAt(a) == 'U'
//                currentPosition++;
//            }
//        }
//        return valleyEnterAndExit;
//    }

}
