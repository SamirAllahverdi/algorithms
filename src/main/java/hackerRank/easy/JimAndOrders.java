package hackerRank.easy;

import java.util.Arrays;
import java.util.Comparator;
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
      return IntStream.range(0, orders.length).boxed().collect(Collectors.toMap(a -> a+1, a -> orders[a][0] + orders[a][1]))
                .entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).mapToInt(Map.Entry::getKey).toArray();
    }

}
