package hackerRank;

import java.util.Arrays;

public class BiggerIsGreater {
    public static void main(String[] args) {
        System.out.println(biggerIsGreaterYo("dkhc"));
    }


    static String biggerIsGreaterYo(String w) {
        char charArray[] = w.toCharArray();
        int n = charArray.length;
        int endIndex = 0;

        // step-1) Start from the right most character and find the first character
        // that is smaller than previous character.
        for (endIndex = n - 1; endIndex > 0; endIndex--) {
            if (charArray[endIndex] > charArray[endIndex - 1]) {
                break;
            }
        }

        // If no such char found, then all characters are in descending order
        // means there cannot be a greater string with same set of characters
        if (endIndex == 0) {
            return "no answer";
        } else {
            int firstSmallChar = charArray[endIndex - 1], nextSmallChar = endIndex;

            // step-2) Find the smallest character on right side of (endIndex - 1)'th
            // character that is greater than charArray[endIndex - 1]
            for (int startIndex = endIndex + 1; startIndex < n; startIndex++) {
                if (charArray[startIndex] > firstSmallChar && charArray[startIndex] < charArray[nextSmallChar]) {
                    nextSmallChar = startIndex;
                }
            }

            // step-3) Swap the above found next smallest character with charArray[endIndex - 1]
            swapYo(charArray, endIndex - 1, nextSmallChar);

            // step-4) Sort the charArray after (endIndex - 1)in ascending order
            Arrays.sort(charArray, endIndex, n);

        }
        return new String(charArray);
    }

    static void swapYo(char charArray[], int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
