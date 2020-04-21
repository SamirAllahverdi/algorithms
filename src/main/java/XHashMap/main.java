package XHashMap;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        XHashMap xHashMap = new XHashMap(16);
        xHashMap.put(34, "sd");
        xHashMap.put(2, "dsasa");
        xHashMap.put(1, "dsaassa");




        System.out.println(xHashMap.get(1).value);

    }
}
