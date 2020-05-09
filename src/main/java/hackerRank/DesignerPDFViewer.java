package hackerRank;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DesignerPDFViewer {
    public static void main(String[] args) {
//        int[] word = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
//        System.out.println("DesignerPDFViewer: " + designerPdfViewer(word, "zaba"));
//        System.out.println("DesignerPDFViewerStream: " + designerPdfViewer2(word, "zaba"));


//        System.out.println(viralAdvertising(3));
//        System.out.println(viralAdvertising2(3));
//        System.out.println(Arrays.toString(circularArrayRotation(new int[]{3, 2, 1}, 1)));
        int[] array = new int[]{3, 2, 9,1};
        int[] queries = new int[]{0,1, 2,3};
//        String a = Arrays.toString();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }
        String a = stringBuilder.toString();
        int total = 2 % a.length();
        int middle = a.length()-total;
        String b= total == 0 ? a : a.substring(middle).concat(a.substring(0,middle));
        char c1 = b.charAt(1);

if(total == 0){}
        int[] ints = Arrays.stream(queries).map(c -> Integer.parseInt(String.valueOf(b.charAt(c)))).toArray();
        System.out.println(Arrays.toString(ints));
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            stringBuilder.append(a[i]);
        }
        String newS = stringBuilder.toString();
        int total = k % newS.length();
        int middle = newS.length()-total;
        String b= newS.substring(middle).concat(newS.substring(0,middle));

        return   Arrays.stream(queries).map(c ->  Integer.parseInt(String.valueOf(b.charAt(c+1)))).toArray();

    }

    static int designerPdfViewer2(int[] h, String word) {
        return IntStream.range(0, word.length()).map(b -> h[word.charAt(b) - 'a']).max().orElse(0) * word.length();
    }

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        List index = new ArrayList();
        for (int a = 0; a < word.length(); a++) {
            int ascii = word.charAt(a) - 97;
            index.add(h[ascii]);
        }
        return (int) index.stream().filter(a -> a == Collections.max(index)).findFirst().orElse(0) * word.length();
    }

    static int viralAdvertising(int n) {
        int shared = 5;
        int sum = 0;
        for (int a = 1; a <= n; a++) {
            sum += shared / 2;
            shared = (shared / 2) * 3;
        }
        return sum;

    }

    static class Record {
        static int shared = 5;
        static int sum = 0;
    }

    static int viralAdvertising2(int n) {
        return IntStream.rangeClosed(1, n).map(a -> {
            Record.sum += Record.shared / 2;
            Record.shared = (Record.shared / 2) * 3;
            return Record.sum;
        }).boxed().max((c, e) -> c > e ? 1 : -1).orElse(0);
    }


    static int[] circularArrayRotation(int[] a, int k) {
        int e = 0;
        while (e < k) {
            int save = 0;
            for (int c = 0; c < a.length; c++) {
                System.out.println(c + " Turn ");
                if (c == a.length - 1) {
                    a[0] = save;
                } else if (c == 0) {
                    save = a[c + 1];
                    a[c + 1] = a[c];
                } else {
                    int cur = a[c + 1];
                    a[c + 1] = save;
                    save = cur;
                }
                System.out.println(Arrays.toString(a));
                System.out.println("Saving value: " + save);
            }
            e++;
        }


        return a;
    }

}