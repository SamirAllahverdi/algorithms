package hackerRank.mixed;

public class SeperateNumber {
    public static void main(String[] args) {
        separateNumbers("9101147");
    }

    static void separateNumbers(String s) {
        String subsSt = "";
        boolean isValid = false;
        for (int a = 1; a <= s.length() / 2; a++) {
//            System.out.println(a);
            subsSt = s.substring(0, a);
            Long num = Long.parseLong(subsSt);
            String validSt = subsSt;
            while (validSt.length() < s.length()) {
                validSt += Long.toString(++num);
            }
//            System.out.println(validSt);
            if (s.equals(validSt)) {
                isValid = true;
                break;
            }
        }

        System.out.println(isValid ? "YES " + subsSt : "NO");
    }


}
