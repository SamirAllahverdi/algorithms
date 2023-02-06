package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    /*
     * - https://leetcode.com/problems/group-anagrams
     * */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] elements = new char[26];
            for (char c : str.toCharArray())
                elements[c - 'a']++;
            String sorted = new String(elements);
            List<String> list;
            if (map.containsKey(sorted)) {
                list = map.get(sorted);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(sorted, list);
        }

        return new ArrayList<>(map.values());
    }
}
