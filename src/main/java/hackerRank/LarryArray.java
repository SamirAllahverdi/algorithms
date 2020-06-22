package hackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LarryArray {
    public static void main(String[] args) {
        int[] array = {8, 1, 3, 5, 4};

        System.out.println(larrysArray(array));

        System.out.println(Arrays.toString(array));

    }

    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {

        IntStream.range(0, A.length).forEach(b -> IntStream.rangeClosed(0, A.length - 3).forEach(a -> rotate(a, a + 1, a + 2, A)));
        return IntStream.range(1, A.length).allMatch(a -> A[a] >= A[a - 1]) ? "YES" : "NO";
    }

    public static void rotate(int a, int b, int c, int[] A) {
        int min = Math.min(Math.min(A[a], A[b]), A[c]);

        for (int e = 0; e < 3; e++) {
//            System.out.println(" T ");
            if (min == A[a]) break;
            int temp = A[a];
            A[a] = A[b];
            A[b] = A[c];
            A[c] = temp;
        }
    }


    static class Sum {
        static int sum = 0;
    }
/**  What a soluthio */
    static String larrysArrayMathAppro(int[] A) {

        IntStream.range(0, A.length).forEach(b -> IntStream.range(b + 1, A.length).forEach(a -> {
            if (A[b] > A[a]) Sum.sum++;
        }));
//        When use HackerRank, make Sum.sum =0 before each return(Whether it is "YES" or "NO")
        return Sum.sum % 2 == 0 ? "YES" : "NO";
    }


}
