package hackerRank;

import java.util.stream.IntStream;

public class BiggerIsGreater {
    public static void main(String[] args) {

        System.out.println(check(3, "abad"));
    }


    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {

        String nw = w;


        for (int a = 2; a <= w.length(); a++) {
//            if (check(a, w)) {
//
//            }
        }


        return "";
    }

    private static int check(int a, String w) {

        String orginal = w;

        int max = w.charAt(w.length() - a);
        boolean isChangeable =false;

        for (int c = 0; c < a - 1; c++) {
            int value = w.charAt(w.length() -1- c);
            if (value < max) {
                isChangeable =true;
                max = value;
            }
        }

        if(isChangeable){


        }
        System.out.println(" MAX " + max);
        return 1;
    }



}
