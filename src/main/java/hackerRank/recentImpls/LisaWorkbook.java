package hackerRank.recentImpls;

import java.util.Arrays;
import java.util.List;

public class LisaWorkbook {

    /**
     * https://www.hackerrank.com/challenges/lisa-workbook/
     */
//    public static void main(String[] args) {
//        System.out.println(workbook(5,3,Arrays.asList(4,2,1,6,10)));
//    }

    public static int workbook(int n, int k, List<Integer> chaptersProblems) {

        int special = 0;
        int page = 1;

        for (int chapterProblems : chaptersProblems) {
            for (int problem = 1; problem <= chapterProblems; problem++) {
                if (problem == page)
                    special++;

                if (problem % k == 0 || problem == chapterProblems)
                    page++;
            }
        }

        return special;
    }
}
