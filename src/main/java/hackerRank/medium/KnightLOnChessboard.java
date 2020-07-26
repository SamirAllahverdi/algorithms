package hackerRank.medium;

import java.util.*;

public class KnightLOnChessboard {
    /**
     * https://www.hackerrank.com/challenges/knightl-on-chessboard/problem
     */
    public static void main(String[] args) {
        int n = 5;
        int[][] array = knightlOnAChessboard(n);

        Arrays.stream(array).forEach(a ->
                System.out.println(Arrays.toString(a)));

    }


    static int[][] knightlOnAChessboard(int n) {

        Map<Pair, Integer> countMap = new HashMap<>();
        int[][] counts = new int[n - 1][n - 1];


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (!countMap.containsKey(new Pair(i, j))) {
                    int count = knightLOnAChessboard(n, i, j);
                    counts[i - 1][j - 1] = count;
                    countMap.put(new Pair(i, j), count);
                }
            }
        }
        return counts;
    }

    static int knightLOnAChessboard(int n, int i, int j) {

        Map<Pair, Integer> distanceInfo = buildDistanceInfo(n, i, j);
        Pair destination = new Pair(n - 1, n - 1);

        return distanceInfo.get(destination) == null ? -1 : distanceInfo.get(destination);
    }

    static Map<Pair, Integer> buildDistanceInfo(int n, int i, int j) {
        Pair source = new Pair(0, 0);

        Map<Pair, Integer> distanceInfoMap = new HashMap<>();
        distanceInfoMap.put(source, 0);

        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();

            for (Pair pair : getAdjacents(n, currentPair, i, j)) {
                Integer currentDistance = distanceInfoMap.get(pair);
                if (currentDistance == null) {
                    int nodeDistance = distanceInfoMap.get(currentPair) + 1;
                    distanceInfoMap.put(pair, nodeDistance);
                    queue.add(pair);
                }
            }
        }
        return distanceInfoMap;
    }


    static List<Pair> getAdjacents(int n, Pair currentPair, int i, int j) {
        Pair[] allPossibleAdjacents = new Pair[8];

        int x = currentPair.x;
        int y = currentPair.y;

        allPossibleAdjacents[0] = new Pair(x + i, y + j);
        allPossibleAdjacents[1] = new Pair(x - i, y - j);
        allPossibleAdjacents[2] = new Pair(x - i, y + j);
        allPossibleAdjacents[3] = new Pair(x + i, y - j);

        allPossibleAdjacents[4] = new Pair(x + j, y + i);
        allPossibleAdjacents[5] = new Pair(x - j, y - i);
        allPossibleAdjacents[6] = new Pair(x - j, y + i);
        allPossibleAdjacents[7] = new Pair(x + j, y - i);


        List<Pair> adjacents = new ArrayList<>();
        for (Pair pair : allPossibleAdjacents) {
            if ((pair.x >= 0 && pair.x < n) && (pair.y >= 0 && pair.y < n)) {
                adjacents.add(pair);
            }
        }
        return adjacents;
    }

    static class Pair {
        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x << 16 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return pair.x == this.x && pair.y == this.y;
        }

        @Override
        public String toString() {
            return "Pair: " +
                    "x: " + x +
                    ", y:" + y;
        }
    }

}
