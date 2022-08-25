package hackerRank.recentImpls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationEquation {

    /**
     * https://www.hackerrank.com/challenges/permutation-equation
     */

//    public static void main(String[] args) {
//        System.out.println(permutationEquation(Arrays.asList(4,2,3,1,5)));
//    }


    public static List<Integer> permutationEquation(List<Integer> p) {


        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=p.size();i++){
            int  temp = p.indexOf(i);
            int y = p.indexOf(++temp);
            list.add(++y);
        }

        return list;
    }
}
