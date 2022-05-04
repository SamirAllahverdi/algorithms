package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckBalance {


    public static final int UNIMPORTANT_CONTEST = 0;
    public static final int CONTEST_TYPE = 1;
    public static final int LUCK = 0;


//    public static void main(String[] args) {
//
//        List<List<Integer>> contests = new ArrayList<>();
//
//        contests.add(Arrays.asList(5,1));
//        contests.add(Arrays.asList(2,1));
//        contests.add(Arrays.asList(1,1));
//        contests.add(Arrays.asList(8,1));
//        contests.add(Arrays.asList(10,0));
//        contests.add(Arrays.asList(5,0));
//
//        System.out.println(luckBalance(3,contests)); /* expected 29 */
//    }

    public static int luckBalance(int k, List<List<Integer>> contests) {

        Integer sum = 0;
        ArrayList<Integer> importantContestLucks = new ArrayList<>();
        for (List<Integer> contest : contests) {
            if (contest.get(CONTEST_TYPE) == UNIMPORTANT_CONTEST) {
                sum += contest.get(LUCK);
            } else {
                importantContestLucks.add(contest.get(LUCK));
            }
        }

        Collections.sort(importantContestLucks);

        for (int i = importantContestLucks.size() - 1; i >= 0; i--) {
            if (k > 0) {
                sum += importantContestLucks.get(i);
                k--;
            } else {
                sum -= importantContestLucks.get(i);
            }
        }

        return sum;
    }
}
