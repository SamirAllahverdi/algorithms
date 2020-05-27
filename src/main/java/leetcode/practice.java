package leetcode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class practice {
    public static void main(String[] args) {

        int[] a = {4,7,9,7,6,7};
        int[] b = {5,0,0,6,1,6,2,2,4};
        System.out.println(getSum(17,13));
    }

    public static int getSum(int a, int b) {
        if( a == 0){return b;}
        if(b == 0){return a;}
        if( Math.abs(a) == Math.abs(b)){
            System.out.println( Math.abs(a));
            System.out.println( Math.abs(b));
            return 0;}

        if (a < 0 || b<0) return getSum(++a,--b);
        else  return getSum(--a,++b);
    }
}


