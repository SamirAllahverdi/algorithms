package hackerRank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ClosestNumbers {
    public static void main(String[] args) {
        int[] a = {5, 2, 3, 4, 1};
        System.out.println(Arrays.toString(closestNumbers4(a)));
    }

    static class Pair<A, B> {
        A a;
        B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {

        List<Pair<Pair<Integer, Integer>, Integer>> collect = IntStream.range(0, arr.length - 1).boxed().flatMap(a -> IntStream.range(a + 1, arr.length).
                mapToObj(b -> new Pair<>(arr[a], arr[b]))).map(c ->
                new Pair<>(c, Math.abs(c.a - c.b))
        ).collect(Collectors.toList());

        Integer min = collect.stream().min(Comparator.comparingInt(a -> a.b)).map(a -> a.b).orElse(0);

        int[] ints = collect.stream().filter(a -> a.b.equals(min)).
                flatMapToInt(a -> IntStream.of(a.a.a, a.a.b)).sorted().toArray();
        return ints;
    }

    static int[] closestNumbers2(int[] arr) {

//        System.out.println(arr);
        Map<Pair<Integer, Integer>, Integer> collect = IntStream.range(0, arr.length - 1).boxed().flatMap(a -> IntStream.range(a + 1, arr.length).
                mapToObj(b -> new Pair<>(arr[a], arr[b]))).map(c ->
                new Pair<>(c, Math.abs(c.a - c.b))
        ).collect(Collectors.toMap(a -> a.a, a -> a.b));

        return collect.entrySet().stream().filter(a -> a.getValue().equals(Collections.min(collect.values()))).
                flatMapToInt(a -> IntStream.of(a.getKey().a, a.getKey().b)).sorted().toArray();
    }

    static int[] closestNumbers3(int[] arr) {

        int min = Integer.MAX_VALUE;
        List<Integer> collect = new ArrayList<>();

        for (int a = 0; a < arr.length - 1; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                int abs = Math.abs(arr[a] - arr[b]);
                if (abs < min) {
                    min = abs;
                    collect = new ArrayList<>();
                    collect.add(arr[a]);
                    collect.add(arr[b]);
                } else if (abs == min) {
                    collect.add(arr[a]);
                    collect.add(arr[b]);
                }
            }
        }
        return collect.stream().sorted().mapToInt(a -> a).toArray();
    }

    //    TODO this approach does not work
    static class Helper {
        static List<Integer> collect = new ArrayList<>();
        static int min = 0;
    }
    static int[] closestNumbers4(int[] arr) {
        IntStream.range(0, arr.length - 1).forEach(a -> IntStream.range(a + 1, arr.length).forEach(
                b -> {
                    int abs = Math.abs(arr[a] - arr[b]);
                    if (abs < Helper.min) {
                        Helper.min = abs;
                        Helper.collect = new ArrayList<>();
                        Helper.collect.add(arr[a]);
                        Helper.collect.add(arr[b]);
                    } else if (Helper.min == abs) {
                        Helper.collect.add(arr[a]);
                        Helper.collect.add(arr[b]);
                    }
                }
        ));
        return Helper.collect.stream().sorted().mapToInt(a -> a).toArray();
    }
}
