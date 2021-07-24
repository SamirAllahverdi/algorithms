package newImplemenations.hackerRank;

import java.util.*;

public class CtciIceCreamParlor {


//    public static void main(String[] args) {
//        whatFlavors(Arrays.asList(2, 1, 3, 5, 6), 5);
////        expected 1 3
//    }


    public static void whatFlavors(List<Integer> cost, int money) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a = cost.size() - 1; a >= 0; a--) {

            int value = money - cost.get(a);

            if (map.containsKey(value)) {
                int firstIndex = a + 1;
                int secondIndex = map.get(value) + 1;
                System.out.println(firstIndex + " " + secondIndex);
                break;
            }

            map.put(cost.get(a), a);
        }

    }
}
