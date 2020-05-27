package hackerRank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Practise {
    public static void main(String[] args) {

        String[] array = {"11101", "10101", " 11001", " 10111", " 10000", " 01110"};
        System.out.println(Arrays.toString(acmTeam(array)));
    }

    static int[] acmTeam(String[] topic) {
        int[] result = {0, 0};
        int max = 0;
        int count = 0;
        for (int a = 0; a < topic.length; a++) {
            for (int b = a; b < topic.length; b++) {
                int countR = helper(a, b, topic);
                System.out.println("A " + a + " B " + b);

                if (countR > max) {
                    max = countR;
                    count = 1;
                } else if (countR == max) {
                    System.out.println("COUNTR " + countR);
                    count++;
                }
            }
        }
        result[0] = max;
        result[1] = count;
        return result;
    }

    private static int helper(int first, int second, String[] topic) {
        int count = 0;
        for (int a = 0; a < topic[0].length(); a++) {
            if (topic[first].charAt(a) == '1' || topic[second].charAt(a) == '1') {
//                System.out.println("INDEX " +a);
//                System.out.println("DOHELPER FIRST-> " + topic[first]+" SECOND -> " + topic[second]);
                count++;
            }
        }
        return count;
    }


    static int equalizeArray(int[] arr) {
        int len = arr.length;
        int aux[] = new int[101];
        for (int i = 0; i < len; i++) {
            int index = arr[i];
            aux[index]++;
        }

        int maxFreqCount = getMaxFreqCount(aux);
        return len - maxFreqCount;
    }

    private static int getMaxFreqCount(int[] aux) {
        int maxFreqCount = Integer.MIN_VALUE;
        System.out.println("ARRAY" + Arrays.toString(aux));
        for (int freqCount : aux) {
            if (freqCount > maxFreqCount) {
                maxFreqCount = freqCount;
            }
        }
        return maxFreqCount;
    }


}
