import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class InterviewPractice {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        Instant instantObj = clock.instant();

        System.out.println(clock);
        System.out.println(instantObj);
    }



    private static boolean isPower(int c) {
        System.out.println("IS POWER " + c);
        if( c == 2) return true;
        else if(c % 2 == 1 || c== 0) return false;
        return isPower(c/2);
    }


}
