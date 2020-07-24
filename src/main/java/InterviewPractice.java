import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class InterviewPractice {
    public static void main(String[] args) {
        String name = "aa";
        changeToHomer(name);
        System.out.println(name);
    }


    static void changeToHomer(String name) {
        name = "Homer";
    }

    private static boolean isPower(int c) {
        System.out.println("IS POWER " + c);
        if( c == 2) return true;
        else if(c % 2 == 1 || c== 0) return false;
        return isPower(c/2);
    }


}
