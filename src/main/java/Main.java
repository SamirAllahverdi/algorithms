import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{};

//        System.out.println(chocolateFeast(10,2,5));
        System.out.println(check(" aca","  aac"));
    }


    public static boolean check(String a, String b) {
        int[] array = new int[26];

        for (int c = 0; c < Math.max(a.length(), b.length()); c++) {
            if (c < a.length() && a.charAt(c) != (char) 32) array[a.charAt(c)-'a']++;
            if (c < b.length() && b.charAt(c) != (char) 32) array[b.charAt(c)-'a']--;
        }

        for (int i : array) {
            if (i != 0) return false;
        }
        return true;
    }
    static int chocolateFeast(int n, int c, int m) {

        int buyedBars =n/c;
        int wraps=buyedBars;
        while(wraps >= m){
            System.out.println("t");
            int nextWraps = (wraps/m);
            int r = buyedBars% m;
            buyedBars =buyedBars + nextWraps;
            wraps= r+nextWraps;
        }
        return buyedBars  ;

    }
    static int hurdleRace(int k, int[] height) {
        int max = Arrays.stream(height).max().orElse(0);
        return k>=max ? 0: max-k ;
    }

    public static String shift(String orig, int toLeft, int toRight) {
        int left = toLeft % 4;
        int right = toRight % 4;
        char[] byIndex = orig.toCharArray();
        char previous;
        int shiftingIndex = 0;
        if (left != 4) {
            for (int b = 0; b < left; b++) {
                previous = byIndex[0];
                byIndex[0] = byIndex[byIndex.length - 1];
                for (int a = 1; a < byIndex.length; a++) {
                    char tmp = byIndex[a];
                    byIndex[a] = previous;
                    previous = tmp;
                }
            }
        }
        if (right != 4) {
            for (int b = 0; b < right; b++) {
                previous = byIndex[byIndex.length - 1];
                byIndex[byIndex.length - 1] = byIndex[0];
                for (int a = byIndex.length - 2; a >= 0; a--) {
                    char tmp = byIndex[a];
                    byIndex[a] = previous;
                    previous = tmp;
                }
            }

        }

        System.out.println(Arrays.toString(byIndex));
        return "sd";
    }

    static int jumpingOnClouds(int[] c) {
        int count = 0;
        int i = 0;
        System.out.println(i);
        while (i < c.length - 1) {
            if (i + 2 < c.length && c[i + 2] != 1) {
                i = i + 2;
                System.out.println("if statement: " + i);
            } else {
                i++;
                System.out.println("else statement: " + i);
            }

            count++;
        }
        return count;
    }

}



