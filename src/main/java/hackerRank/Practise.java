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
        String s = "DDUUDDUDUUUD";

        System.out.println("Valley Count" + countingValleys(s.length(), s));
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
