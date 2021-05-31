package newAlgorithms.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckMagazine {
    /**
     * https://www.hackerrank.com/challenges/ctci-ransom-note/
     */

//    public static void main(String[] args) {
//
//        checkMagazine(Arrays.asList("two", "times", "three", "is", "not", "four"),
//                Arrays.asList("two", "times", "two", "is", "four")); /* expected: No */
//    }


    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Long> magazineMap =
                magazine.stream()
                        .collect(Collectors.groupingBy(b -> b,
                                Collectors.counting()));

        boolean canWrite = true;
        for (String word : note) {
            if (magazineMap.containsKey(word) && magazineMap.get(word) > 0) {
                magazineMap.put(word, magazineMap.get(word) - 1);
            } else {
                System.out.println("No");
                canWrite = false;
                break;
            }
        }

        if (canWrite) {
            System.out.println("Yes");
        }
    }

}
