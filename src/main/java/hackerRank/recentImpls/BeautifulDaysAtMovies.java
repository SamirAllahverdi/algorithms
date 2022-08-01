package hackerRank.recentImpls;

public class BeautifulDaysAtMovies {

//    public static void main(String[] args) {
//        System.out.println(beautifulDays(10,20,6));
//    }
    public static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int a = i; a <= j; a++) {
            int b = reverse(a);
            int c = Math.abs(a - b);
            if (c == 0 || c % k == 0)
                count++;
        }

        return count;
    }

    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }
}
