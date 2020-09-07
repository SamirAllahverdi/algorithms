package crackingCodingInterview;

public class Practice {
    public static void main(String[] args) {

        System.out.println(powers0f2(68));

    }

    static int powers0f2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int prev = powers0f2(n / 2);
            return prev * 2;
        }
    }

}
