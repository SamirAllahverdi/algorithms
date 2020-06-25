package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FullCountSort {
    public static void main(String[] args) {

        List<String> product_a = Arrays.asList("0", "ab");
        List<String> product_b = Arrays.asList("6", "cd");
        List<String> product_c = Arrays.asList("0", "ef");
        List<String> product_1 = Arrays.asList("6", "ch");
        List<String> product_2 = Arrays.asList("4", "ij");
        List<String> product_3 = Arrays.asList("0", "ab");
        List<String> product_4 = Arrays.asList("6", "gh");

        List<List<String>> products = new ArrayList<>();
        products.add(product_a);
        products.add(product_b);
        products.add(product_c);
        products.add(product_1);
        products.add(product_2);
        products.add(product_3);
        products.add(product_4);


        countSort(products);
    }


    static void countSort(List<List<String>> arr) {
        StringBuffer[] st = new StringBuffer[arr.size()];

        IntStream.range(0, arr.size()).forEach(a -> st[a] = new StringBuffer());

        fillValues(st, arr);

        Arrays.stream(st).forEach(System.out::print);
    }

    private static void fillValues(StringBuffer[] stringBuilders, List<List<String>> arr) {
        IntStream.range(0, arr.size()).forEach(a -> {
            int key = Integer.parseInt(arr.get(a).get(0));
            String value = arr.get(a).get(1);
            if (a >= arr.size() / 2) {
                stringBuilders[key] = stringBuilders[key].append(value + " ");
            } else {
                stringBuilders[key] = stringBuilders[key].append("- ");
            }
        });
    }

}
