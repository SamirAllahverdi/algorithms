package hackerRank.mixed;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;


public class Practise {
    public static void main(String[] args) {

        String[] array = {"11101", "10101", " 11001", " 10111", " 10000", " 01110"};
//        System.out.println(Arrays.toString(acmTeam(array)));
        System.out.println(superReducedString("aaabbccdddad"));
    }


    static String superReducedString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            System.out.println( i +  " TURN");
            Character ch = str.charAt(i);
            System.out.println(stack.toString());
            if (!stack.isEmpty() && ch == stack.peek()) {
                System.out.println("Poped "+ ch);
                stack.pop();
            } else {
                System.out.println("ADDED " + ch);
                stack.push(ch);
            }
            System.out.println("_________________________");
        }

        /* Print final result */
        if (stack.isEmpty()) {
            return "Empty String";
        } else {
            String result = "";
            for (char ch : stack) {
                result = result + ch;
            }
            return result;
        }
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
