package warmup;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class AltChar {


    public static void main(String[] args) {
        String s = "AAABBBA";
        System.out.println(s);
        System.out.println(alternatingCharacters(s));

        for(int a= 0; a < 13_000;a++)
            System.out.print(UUID.randomUUID() + ",");
    }


    static int alternatingCharacters(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int a = 1;
        int count = 0;

        while (a < stringBuilder.length()) {

            if (stringBuilder.charAt(a) == stringBuilder.charAt(a - 1)) {
                stringBuilder.deleteCharAt(a);
                count++;
            } else {
                a++;
            }
            System.out.println(stringBuilder);

        }
        return count;
    }


    static int alternatingCharacters2(String s) {

        int count = 0;
        char lastItem = 0;

        for(char item: s.toCharArray()){
            if(lastItem == item){
                count++;
            }
            lastItem = item;
        }
        return count;

    }

    static class Pair<A, B> {
        final A a;
        final B b;

        Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return String.format("P[%s:%s]", a, b);
        }
    }

    static List<Character> sToList(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    static <A, T> A fold(Iterable<T> data, A initial, BiFunction<A, T, A> f) {
        Iterator<T> it = data.iterator();
        A acc = initial;

        while (it.hasNext()) {
            System.out.println(acc);
            acc = f.apply(acc, it.next());
        }

        return acc;
    }



    static int alternatingCharacters3(String s) {
        BiFunction<
                Pair<Integer, Character>,
                Character,
                Pair<Integer, Character>
                > f = (p, c) -> p.b != c ? new Pair<>(p.a, c) : new Pair<>(p.a + 1, c);

        return fold(
                sToList(s),
                new Pair<>(0, '_'),
                f
        ).a;
    }
}
