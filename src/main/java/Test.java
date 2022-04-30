import java.math.BigDecimal;
import java.util.*;

public class Test {


    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(3*0.1).setScale(1));
        double sqrt = Math.sqrt(17);

        String s = String.valueOf(sqrt);
        System.out.println("s = " + s.endsWith(".0"));
    }


//    public static int longestIncreasingSubsequence(List<Integer> arr) {
//        List<Integer> list = new ArrayList<>();
//        list.add(arr.get(0));
//        int len = 1;
//        int idx;
//
//        for (Integer a : arr) {
//            if (a > list.get(len - 1)) {
//                list.add(a);
//                len++;
//            } else {
//                idx = Collections.binarySearch(list, a);
//                if (idx < 0) {
//                    idx += 1;
//                    idx *= -1;
//                    list.set(idx, a);
//                }
//            }
//        }
//        return len;
//    }

//    public static void staircase(int n) {
//        int l = n -1;
//        for(int a = 0; a < n; a++){
//            StringBuilder builder = new StringBuilder();
//            for(int b = 0; b < l ;b++){
//                builder.append(" ");
//            }
//
//            for(int c = 0; c<n -l;c++){
//                builder.append("#");
//            }
//            System.out.println(builder);
//            l--;
//        }
//
//    }


//    public static int equalizeArray(List<Integer> arr) {
//        int[] counts = new int[101];
//
//        for (int a : arr) {
//            counts[a]++;
//        }
//
//        int max = 0;
//        for(int a : counts){
//            max = Math.max(max, a);
//        }
//
//        return arr.size() - max;
//    }


//    @Override
//    public int compare(Player a, Player b){
//        if(a.score == b.score){
//            return a.name.compareTo(b.name);
//        }else{
//            return b.score - a.score;
//        }
//
//    }



}
