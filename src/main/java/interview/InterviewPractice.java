package interview;

public class InterviewPractice {

    public static void main(String[] args) {


        A a = A.getInstance();
a.i = 3;
        A b = A.getInstance();
        System.out.println(b.i);
    }
}
