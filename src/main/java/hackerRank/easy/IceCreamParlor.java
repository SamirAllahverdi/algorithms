package hackerRank.easy;

import java.util.*;
import java.util.stream.IntStream;

public class IceCreamParlor {

    public static void main(String[] args) {

        int [] array ={1 ,4 ,5 ,3 ,2};
        int m = 4;
        System.out.println(Arrays.toString(icecreamParlorWithMapAndStream(m, array)));

    }

    static int[] icecreamParlorWithMapAndStream(int m, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] array = new int[2];
        IntStream.range(0, arr.length).forEach(a -> {
            if (map.containsKey(m - arr[a])) {
                array[0] = map.get(m - arr[a]) ;
                array[1] = a+ 1;
            } else {
                map.put(arr[a], a+1);
            }
        });

        return array;
    }

}
