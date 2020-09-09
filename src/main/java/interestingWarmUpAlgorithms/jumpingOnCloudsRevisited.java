package interestingWarmUpAlgorithms;

public class jumpingOnCloudsRevisited {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 0, 0, 1, 1, 0};

        System.out.println(jumpingOnClouds(array, 2));
    }

    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int a = (k % c.length);
        energy = energy - (c[a] * 2 + 1);
        while (a != 0) {
            a =   (a+k) % c.length;
            energy = energy - (c[a] * 2 + 1);

        }
        return energy;
    }

}
