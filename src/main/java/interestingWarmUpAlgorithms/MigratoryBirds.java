package interestingWarmUpAlgorithms;

import java.util.*;
import java.util.stream.Collectors;

public class MigratoryBirds {
    public static void main(String[] args) {
        System.out.println("Migratory Bids with stream: " + migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
        System.out.println("Migratory Bids without stream: " + migratoryBirds2(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));

// https://www.hackerrank.com/challenges/migratory-birds/problem
//https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
    }


    static int migratoryBirds(List<Integer> arr) {
//        Here after groupingBy all the elements and counting them,
//        i open entryset stream and compare each one value with max value
//        (Cllection.max(hashmap.values()) it accept all values , and chose max).
//        Then , find min key with max value and return it

        Map<Integer, Long> hashMap = arr.stream().collect(Collectors.groupingBy(b -> b, Collectors.counting()));

        return hashMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == Collections.max(hashMap.values()))
                .min(Comparator.comparingInt(Map.Entry::getKey)).get().getKey();
    }

    static int migratoryBirds2(List<Integer> arr) {
        Map<Integer, Integer> counType = new HashMap<Integer, Integer>();
        for (int types_i = 0; types_i < arr.size(); types_i++) {
           int number = arr.get(types_i);
            if (counType.containsKey(number)) {
                counType.replace(number, counType.get(number) + 1);
                continue;
            }
                counType.put(number, 1);
        }
        int max = Collections.max(counType.values());

        for (Map.Entry<Integer, Integer> entry : counType.entrySet()) {
            if (entry.getValue().equals(max)) {
               return entry.getKey();
            }
        }
        return 0;
    }
}
