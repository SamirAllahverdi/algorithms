package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grading {

    /**
     * https://www.hackerrank.com/challenges/grading
     */
//    public static void main(String[] args) {
//        List<Integer> grades = Arrays.asList(78, 82, 30, 22);
//        System.out.println(gradingStudents(grades));
//    }


    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalGrades = new ArrayList<>();

        for (int grade : grades) {
            int roundingGrade = grade;
            if (grade % 5 != 0)
                roundingGrade += (5 - (grade % 5));

            if (roundingGrade - grade < 3 && roundingGrade >= 40)
                finalGrades.add(roundingGrade);
             else
                finalGrades.add(grade);

        }
        return finalGrades;
    }

}
