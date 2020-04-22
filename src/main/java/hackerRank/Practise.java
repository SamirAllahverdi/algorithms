package hackerRank;

import Practice.Main;

import javax.swing.plaf.IconUIResource;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Practise {


    public static void main(String[] args) {
        System.out.println("Result with Java 7: " + birthday(new ArrayList<>(Arrays.asList(4)), 4, 1));
//        System.out.println("Result with Java 8: " + birthday2(new ArrayList<>(Arrays.asList(4)), 4, 1));
IntStream.range(0,5).forEach(System.out::println);
    }
    static int birthday2(List<Integer> s, int d, int m) {
        return (int) IntStream.rangeClosed(0,s.size()-m).map(a->IntStream.range(a+1,a+m).map(c->s.get(c)).sum()+s.get(a))
                .boxed().filter(sum-> sum==d).count();
    }
    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;

        for (int a = 0; a+m <= s.size(); a++) {

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
