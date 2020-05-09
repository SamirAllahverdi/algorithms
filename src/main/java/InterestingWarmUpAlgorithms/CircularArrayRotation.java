package InterestingWarmUpAlgorithms;

public class CircularArrayRotation {
    public static void main(String[] args) {
        System.out.println(circularArrayRotation(new int[]{3, 2, 1}, 1,new int[]{1,2}));
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
//       1<= queries.elements
        int n = a.length;
        int[] yeni = new int[queries.length];
        for (int a0 = 0; a0 < queries.length; a0++) {
// before find rotation after k, then increment by position in queries, then % n her ehtimal uchun
            yeni[a0] = a[(n   - (k % n)+ queries[a0]) % n];
        }
        return yeni;

    }

}


