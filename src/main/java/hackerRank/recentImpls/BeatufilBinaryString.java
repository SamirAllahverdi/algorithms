package hackerRank.recentImpls;

public class BeatufilBinaryString {


    /**
     * - https://www.hackerrank.com/challenges/beautiful-binary-string
     */

//    public static void main(String[] args) {
//        System.out.println(beautifulBinaryString("0101010"));
//    }
    public static int beautifulBinaryString(String b) {
        StringBuilder str = new StringBuilder();
        int count = 0;

        for (int a = 0; a < b.length(); a++) {

            str.append(b.charAt(a));

            if (str.toString().contains("010")) {
                count++;
                str = new StringBuilder();
            }
        }

        return count;
    }

}
