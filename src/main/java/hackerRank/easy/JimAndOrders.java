package hackerRank.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JimAndOrders {
    /**
     * https://www.hackerrank.com/challenges/jim-and-the-orders/problem
     */
    public static void main(String[] args) {
        int[][] orders = {{1, 3}, {2, 3}, {3, 3}};
        System.out.println(Arrays.toString(jimOrders(orders)));
    }

    static int[] jimOrders(int[][] orders) {

        HashMap<Integer, Integer> orderMap = fillHashMap(orders);

        return orderMap.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).mapToInt(a -> 1 + a.getKey()).toArray();
    }

    private static HashMap<Integer, Integer> fillHashMap(int[][] orders) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int a = 0; a < orders.length; a++) {
            hashMap.put(a, orders[a][0] + orders[a][1]);
        }

        return hashMap;
    }


}
