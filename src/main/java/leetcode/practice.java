package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class practice {
    public static void main(String[] args) {
int [] array = {0,1,0,3,12};
        System.out.println("Before " + Arrays.toString(array));
        moveZeroes(array);
        System.out.println("After " + Arrays.toString(array) );
    }

    public static void moveZeroes(int[] nums) {
        int index =0 ;
        int zeroCount = 0;
        for(int a =0 ; a < nums.length;a++){
            if(nums[a] != 0){

                nums[index] = nums[a];
                index++;
            }else{ zeroCount++;}
        }
        System.out.println("Middle " + Arrays.toString(nums));

        for(int b = index; b < nums.length;b++){
            System.out.println(b);
            nums[b]=0;

        }
    }

}
