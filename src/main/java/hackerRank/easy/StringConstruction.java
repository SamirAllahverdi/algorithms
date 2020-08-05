package hackerRank.easy;

public class StringConstruction {
    /**
     * https://www.hackerrank.com/challenges/string-construction/problem
     **/

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(stringConstruction(s));
    }

    static int stringConstruction(String s) {
        return (int) s.chars().distinct().count();
    }


}
