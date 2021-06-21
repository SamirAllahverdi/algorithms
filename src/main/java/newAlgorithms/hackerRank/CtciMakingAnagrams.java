package newAlgorithms.hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CtciMakingAnagrams {


    public static final String FIRST = "first_";
    public static final String SECOND = "second_";


//    public static void main(String[] args) {
//        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
////        expected 30
//    }

    public static int makeAnagram(String first, String second) {

        Map<String, Integer> map = new HashMap<>();

        first.chars().forEach(character -> {
                    final String firstWordKey = String.format("%s%s", FIRST, Character.toString(character));
                    map.put(firstWordKey, map.getOrDefault(firstWordKey, 0) + 1);
                }
        );

        second.chars().forEach(character -> {
                    final String firstWordKey = String.format("%s%s", FIRST, Character.toString(character));
                    final String secondWordKey = String.format("%s%s", SECOND, Character.toString(character));

                    if (map.containsKey(firstWordKey) && map.get(firstWordKey) > 0) {
                        map.put(firstWordKey, map.get(firstWordKey) - 1);
                    } else {
                        map.put(secondWordKey, map.getOrDefault(secondWordKey, 0) + 1);
                    }
                }
        );

        return map.values().stream()
                .filter(value -> value > 0)
                .reduce(0, Integer::sum);
    }

}
