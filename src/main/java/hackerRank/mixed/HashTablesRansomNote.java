package hackerRank.mixed;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HashTablesRansomNote {
    public static void main(String[] args) {

        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "today"};
        checkMagazine(magazine, note);
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Long> words = Arrays.stream(magazine).collect(Collectors.groupingBy(w -> w, Collectors.counting()));
/**   merge -> get ,  operation  , put **/
        boolean ok = Arrays.stream(note).allMatch(w -> words.merge(w, -1L, Long::sum) >= 0);

        System.out.println(ok ? "Yes" : "No");
    }

}
