package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    public static void main(String[] args) {
        int n = 0;
        int k = 0;

        System.out.println(getHappyString(n, k));
    }


    public static String getHappyString(int n, int k) {

        List<StringBuilder> list = new ArrayList<>();
        char[] letters = {'a', 'b', 'c'};
        int idx = 0;


        while (true) {

            list.add(new StringBuilder());

            for (int a = 0; a < n; a++) {

                if (idx == 3) {
                    list.get(list.size() - 1).append(letters[0]);
                    idx = 1;
                }else {


                }
            }


        }

        return "";
    }


}
