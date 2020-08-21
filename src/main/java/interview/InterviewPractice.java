package interview;

public class InterviewPractice {

    public static void main(String[] args) {
//   Reverse String
        String name = "Samir";

        System.out.println(reverse(name));

    }

    private static String reverse(String name) {
        for (int i = 0; i < name.length(); i++) {
            name = String.format("%s%s%s",name.substring(1, name.length() - i),
                    name.substring(0, 1),
                    name.substring(name.length() - i));
        }
        return name;
    }


}
