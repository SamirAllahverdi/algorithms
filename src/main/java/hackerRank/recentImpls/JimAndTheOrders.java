package hackerRank.recentImpls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JimAndTheOrders {

   /**
    * - https://www.hackerrank.com/challenges/jim-and-the-orders/
    */

//    public static void main(String[] args) {
//        System.out.println(jimOrders(List.of(
//                List.of(3, 4),
//                List.of(4, 3),
//                List.of(5, 6)
//        )));
//    }


    public static List<Integer> jimOrders(List<List<Integer>> orders) {

        Map<Integer, Integer> customerServeTimes = new HashMap<>();
        int customer = 1;
        for (List<Integer> order : orders)
            customerServeTimes.put(customer++, order.get(0) + order.get(1));


        return customerServeTimes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
