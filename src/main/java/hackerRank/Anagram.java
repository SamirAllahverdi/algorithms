package hackerRank;

public class Anagram {


    public static void main(String[] args) {
        String s = "xaxbbbxx";
        System.out.println(anagram(s));
    }

    static int anagram(String s) {


        StringBuilder first = new StringBuilder(s.substring(0, s.length() / 2));
        StringBuilder second = new StringBuilder(s.substring((s.length() / 2)));

        if (first.length() != second.length()) return -1;

        int count = 0;
        for (int a = 0; a < second.length(); a++) {
            if (!first.toString().contains(String.valueOf(second.charAt(a)))) {
                count++;
            } else {
                first.deleteCharAt(first.indexOf(String.valueOf(second.charAt(a))));
            }
        }
        return count;

    }

    static int anagram2(String s) {


        StringBuilder first = new StringBuilder(s.substring(0, s.length() / 2));
        StringBuilder second = new StringBuilder(s.substring((s.length() / 2)));

        if (first.length() != second.length()) return -1;

        int count = 0;
        for (char c : first.toString().toCharArray()) {
            int index = second.toString().indexOf(c);
            if (index == -1) {
                count++;
            } else {
                second.deleteCharAt(index);
            }
        }
        return count;

    }

    static int anagram3(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return -1;
        }
        String s1 = s.substring(0, (n / 2));
        String s2 = s.substring(n / 2);
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            int index = s2.indexOf(s1.charAt(i));
            if (index == -1) {
                count++;
            } else {
                s2 = s2.replaceFirst(Character.toString(s1.charAt(i)), "");
            }
        }
        return count;

    }
}
