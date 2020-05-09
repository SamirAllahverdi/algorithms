package hackerRank;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class PickingNumbers {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 0, 0, 1, 1, 0};

        System.out.println(jumpingOnClouds(array, 2));
    }

    static int jumpingOnClouds(int[] c, int k) {
        int spenEnergy = 100;
        int a = (k % c.length);
        spenEnergy = spenEnergy - (c[a] * 2 + 1);
        while (a != 0) {
            a =   (a+k) % c.length;
            spenEnergy = spenEnergy - (c[a] * 2 + 1);

        }
        return spenEnergy;
    }

}
