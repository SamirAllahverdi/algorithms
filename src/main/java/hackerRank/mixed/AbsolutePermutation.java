package hackerRank.mixed;

import java.util.*;
import java.util.stream.IntStream;

public class AbsolutePermutation {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(absolutePermutation(2, 1)));

    }


    static int[] absolutePermutation(int n, int k) {
        int ans[] = new int[n];
        int no[] = {-1};
        int ok[] = new int[n];
        System.out.println(Arrays.toString(ok));
//        filling ok array
        for (int i = 0; i < n; i++) {
//             +1 because array must begin form 1 to N.
            ok[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
//            Our condition is that Array must start 1
            int a = ( + 1 + k);
            System.out.print(" i + 1 + k " + a);
            int b = (i + 1 - k);
            System.out.print(" i + 1 - k"+ b);

//            first we check smallest abs which is b. check if abs is in range[1,N]
//             then check If it is not used before
            if (b >= 1 && b <= n && ok[b - 1] != -1) {
//                assign value to ans[]
                ans[i] = b;
//                and make this value -1 in ok[]
                ok[b - 1] = -1;
//               second we check biggest abs which is a. check if abs is in range[1,N]
////             then check If it is not used before
            } else if (a >= 1 && a <= n && ok[a - 1] != -1) {
                ans[i] = a;
                ok[a - 1] = -1;
//                if case is not afford 2 conditions, it means both abs is out of range,
//                so return no, which is -1
            } else {return no;}
            System.out.println();
        }
        return ans;
    }


}
