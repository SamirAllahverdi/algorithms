import java.util.Arrays;
import java.util.List;

public class InterviewPractice {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        int [] array ={10, 7, 2, 8, 3};


    }



    private static boolean isPower(int c) {
        System.out.println("IS POWER " + c);
        if( c == 2) return true;
        else if(c % 2 == 1 || c== 0) return false;
        return isPower(c/2);
    }


}
