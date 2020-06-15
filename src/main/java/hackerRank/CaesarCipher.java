package hackerRank;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CaesarCipher {
    public static void main(String[] args) {

        System.out.println(myCaesarCipher("y", 5));

        System.out.println(dissCaesarCipher("y", 5));
    }

    static String dissCaesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            sb.append(encryptChar(s.charAt(i), k));
        }
        return sb.toString();
    }

    private static char encryptChar(char c, int k) {
        if(!Character.isAlphabetic(c)) return c;
        int base = Character.isLowerCase(c) ? 'a' : 'A';
        return (char)((c + k - base) % 26 + base);
    }

    static String myCaesarCipher(String s, int k) {
        char[] chars = s.toCharArray();

        IntStream.range(0, chars.length).filter(e ->
                matcher(s.charAt(e))
        ).forEach(a -> {
            if (isUpper(s.charAt(a))) chars[a] = (char) ((s.charAt(a) + k - 'A') % 26 + 'A');
            if (!isUpper(s.charAt(a))) chars[a] = (char) ((s.charAt(a) + k - 'a') % 26 + 'a');
        });

        StringBuilder a = new StringBuilder();
        a.append(chars);
        return a.toString();
    }

    private static boolean isUpper(char charAt) {
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(String.valueOf(charAt));
        return matcher.find();
    }
    private static boolean matcher(char charAt) {
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(String.valueOf(charAt));
        return matcher.find();
    }
}
