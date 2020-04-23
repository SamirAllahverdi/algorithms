package hackerRank;

import Practice.Main;

import javax.swing.plaf.IconUIResource;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Practise {


    public static void main(String[] args) {
        System.out.println("Migratory Bids: " + migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }


    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Long> hashMap = arr.stream().collect(Collectors.groupingBy(b -> b, Collectors.counting()));
        return    hashMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == Collections.max(hashMap.values()))
                .min((a, b) -> a.getKey() > a.getKey() ? 1 : -1).get().getKey();
    }


    static int birthday2(List<Integer> s, int d, int m) {
        return (int) IntStream.rangeClosed(0, s.size() - m).map(a -> IntStream.range(a + 1, a + m).map(c -> s.get(c)).sum() + s.get(a))
                .boxed().filter(sum -> sum == d).count();
    }

    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;

        for (int a = 0; a + m <= s.size(); a++) {

            sum += s.get(a);
            for (int b = a + 1; b < m + a; b++) {
                sum += s.get(b);
            }
            if (sum == d) {
                count++;
            }
            sum = 0;
        }


        return count;
    }

    static int countingValleys(int n, String s) {
        int valleyEnterAndExit = 0;
        int previousPosition = 0;
        int currentPosition = 0;
        int seaLevel = 0;
        for (int a = 0; a < s.length(); a++) {
            previousPosition = currentPosition;
            if (seaLevel == currentPosition && previousPosition >= 0) {
                valleyEnterAndExit++;
            }
            if (s.charAt(a) == 'D') {
                currentPosition--;
            } else { // s.charAt(a) == 'U'
                currentPosition++;
            }
        }
        return valleyEnterAndExit;
    }

}
