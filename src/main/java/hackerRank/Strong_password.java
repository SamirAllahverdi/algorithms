package hackerRank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strong_password {
    public static void main(String[] args) {
        System.out.println(myMinimumNumber(3, "Ab1"));
        System.out.println(dissMinimumNumber(3,"Ab1"));

    }

    private static int dissMinimumNumber(int n, String password) {
        int count = 0;

        if(!password.matches(".*[a-z].*")) {
            count++;
        }

        if(!password.matches(".*[A-Z].*")) {
            count++;
        }

        if(!password.matches(".*[0-9].*")) {
            count++;
        }

        if(password.matches("^[a-zA-Z0-9]*")) {
            count++;
        }

        int lengthDifference = 6 - password.length();

        return Math.max(count, lengthDifference);
    }

    static int myMinimumNumber(int n, String password) {
        int total = hasDigit(password) + hasSpecialChar(password) + hasUpperCase(password) + hasLowerCase(password);
//        System.out.println("total " + total);
        int mustLength = hasCorrectLength(n);
//        System.out.println("lengthMustBe" + mustLength);

        return Math.max(total, mustLength);
    }

    static int hasSpecialChar(String password) {
        Pattern pattern = Pattern.compile("[-!@#$%^&*()+]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find() ? 0 : 1;
    }

    static int hasLowerCase(String password) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find() ? 0 : 1;
    }

    static int hasUpperCase(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find() ? 0 : 1;
    }

    static int hasDigit(String password) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find() ? 0 : 1;
    }

    static int hasCorrectLength(int length) {
        return length >= 6 ? 0 : 6 - length;
    }

}
