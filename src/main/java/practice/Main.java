package practice;

import java.util.Arrays;

public class Main {



    public static void main(String[] args) {
        int[] apples = {2, -2, 3};

        int a = (int) Arrays.stream(apples).filter(b -> b > 2).count();
        System.out.println(a);

    }

    static int find_binaryR(int[] origin, int number, int l, int r) {
        if (l > r) return -1;
        int m = (l + r) / 2;
        if (origin[m] == number) return m;
        else if (number > origin[m]) {
            l = m + 1;
        } else if (number < origin[m]) {
            r = m - 1;
        }
        return find_binaryR(origin, number, l, r);
    }

    // runner function
    static int find_binaryR(int[] origin, int number) {

        return find_binaryR(origin, number, 0, origin.length - 1);
    }


    static int find_conventional(int[] origin, int number) {
        int counter = 0;
        for (int el : origin) {
            counter++;
            if (el == number) return counter;
        }
        return counter;
    }


    static int find_binary(int[] origin, int number) {
        int l = 0;
        int r = origin.length - 1;
        System.out.println("L is" + l + ", R is" + r);
        System.out.println("_____________");
        while (l <= r) {
            int m = (l + r) / 2;
            System.out.println(", M is " + m);
            if (origin[m] == number) {
                return m;
            }
            if (number > origin[m]) {
                l = m + 1;
                System.out.println("-> L is" + l + ", R is" + r);
            } else {
                r = m - 1;
                System.out.println("<-L is" + l + ", R is" + r);
            }
        }

        return -1;
    }


}