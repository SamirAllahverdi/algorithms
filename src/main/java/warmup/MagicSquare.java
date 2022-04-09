package warmup;

public class MagicSquare {
    public static void main(String[] args) {
        int size = 7;
        int[][] magicArray3X3 = generateMagicSquare(size);
        for (int i = 0; i < magicArray3X3.length; i++) {
            for (int j = 0; j < magicArray3X3[i].length; j++) {
                if (magicArray3X3[i][j] < 10) System.out.print(" ");  // for alignment
                if (magicArray3X3[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(magicArray3X3[i][j] + " ");
            }
            System.out.println();
        }

//      for  HackerRank
//int [] [] a = {
//        {5,3,4},
//        {1,5,8},
//        {6,4,2},
//};
//        System.out.println("Returning value: "formingMagicSquare(a));
    }

    public static int[][] generateMagicSquare(int n) {
        int[][] array = new int[n][n];
//         it is only for odd number
        if (n % 2 == 0) throw new RuntimeException("n must be odd");
// it is for assign number 1.
        int row = n - 1;
        int col = n / 2;
        array[row][col] = 1;
// for other numbers.
        for (int i = 2; i <= n * n; i++) {
// first check the cell is empty or not.
            if (array[(row + 1) % n][(col + 1) % n] == 0) {
                System.out.println(i + " number, indexes:(" + row + " + " + 1 + ") %" + n + " = [ "+(row + 1) % n +" ] , (" + col + " + " + 1 + ") %" + n + " = [" + (col + 1) % n + "]");
                row = (row + 1) % n;
                col = (col + 1) % n;
            } else {
//                if it is not empty , just decrement row,
                row = row - 1;
                // don't change col
                System.out.println("occupied " + i + " number, indexes: " + row + "" + col);
            }
            array[row][col] = i;
        }
        return array;
    }


    // hackerRank Magic Square
//    https://www.hackerrank.com/challenges/magic-square-forming/problem
    static int formingMagicSquare(int[][] s) {
//        write all possible combinations to match.
        int[][] magicSquare = {
                {8, 1, 6, 3, 5, 7, 4, 9, 2},
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
                {2, 9, 4, 7, 5, 3, 6, 1, 8},
                {4, 9, 2, 3, 5, 7, 8, 1, 6},
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {6, 7, 2, 1, 5, 9, 8, 3, 4},
                {2, 7, 6, 9, 5, 1, 4, 3, 8},
        };
        int min = Integer.MAX_VALUE;
//        So  for matching , we need to loop all over it.
        for (int a = 0; a < magicSquare.length; a++) {
//         define total variable here.because we need to total = 0 after one magicSquare combination.
            int total = 0;
            System.out.println(a + " index: ");
            for (int b = 0; b < magicSquare[a].length; b++) {
                System.out.println(total + Math.abs(s[b / 3][b % 3] - magicSquare[a][b]) + "=" + total + "+" + s[b / 3][b % 3] + "-" + magicSquare[a][b]);
//             increase total by Math.abs(s[b / 3][b % 3] - magicSquare[a][b]):
//             we do not care about which index equals to s.because at least changes must be it
//             we count all costs in indexes with s. then find min .
                total = total + Math.abs(s[b / 3][b % 3] - magicSquare[a][b]);
            }
            if (total < min) min = total;
        }
        return min;
    }


}

