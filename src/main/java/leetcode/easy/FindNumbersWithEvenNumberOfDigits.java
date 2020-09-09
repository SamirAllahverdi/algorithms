package leetcode.easy;

public class FindNumbersWithEvenNumberOfDigits {


    public static void main(String[] args) {


        int[] nums = {12, 345, 2, 6, 7896};

        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int length = findLength(num);

            if (length % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    private static int findLength(int num) {
        int length = 0;

        while (num > 0) {
            num /= 10;
            length++;
        }

        return length;
    }
}
