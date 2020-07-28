package hackerRank.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectedCellsInAGrid {

    /**
     * https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
     */
    public static void main(String[] args) {
// FOR first solution
        int[][] matrix = {{1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
// FOR second solution
        int[][] matrix2= {{1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
//         FOR DEBUGGING ARRAY
//        Arrays.stream(matrix).forEach(a -> System.out.println(Arrays.toString(a)));


        System.out.println(connectedCell(matrix));
        System.out.println(connectedCell2(matrix2));


    }

    /**
     * - FIRST SOLUTION -
     */
    static class Location {
        public final int y;
        public final int x;

        public Location(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x << 16 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Location location = (Location) obj;
            return location.x == this.x && location.y == this.y;

        }

        @Override
        public String toString() {
            return "Location:  " +
                    "y = " + y +
                    ", x = " + x;
        }
    }

    static int connectedCell(int[][] matrix) {
        int count = Integer.MIN_VALUE;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    count = Math.max(count, getRegionCellsCount(matrix, new Location(y, x)));
                }
            }
        }
        return count;
    }

    private static int getRegionCellsCount(int[][] matrix, Location start) {
        LinkedList<Location> queue = new LinkedList<>();
        queue.add(start);

        matrix[start.y][start.x] = -1;
        int count = 1;

        while (!queue.isEmpty()) {
            Location crr = queue.poll();
            List<Location> locList = possibleAdjacents(crr, matrix);
            for (Location lc : locList) {
                matrix[lc.y][lc.x] = -1;
                count++;
                queue.add(lc);
            }
        }
        return count;
    }

    private static List<Location> possibleAdjacents(Location l, int[][] matrix) {
        List<Location> adjacents = new ArrayList<>();
        adjacents.add(new Location(l.y + 1, l.x));
        adjacents.add(new Location(l.y - 1, l.x));
        adjacents.add(new Location(l.y, l.x + 1));
        adjacents.add(new Location(l.y, l.x - 1));

        adjacents.add(new Location(l.y + 1, l.x + 1));
        adjacents.add(new Location(l.y + 1, l.x - 1));
        adjacents.add(new Location(l.y - 1, l.x + 1));
        adjacents.add(new Location(l.y - 1, l.x - 1));

        return adjacents.stream().filter(a ->
                (a.x >= 0 && a.x < matrix[0].length)
                        && (a.y >= 0 && a.y < matrix.length)
                        && matrix[a.y][a.x] == 1)
                .collect(Collectors.toList());

    }


    /**
     * - SECOND SOLUTION -
     */
    public static int getSize(int[][] matrix, int y, int x) {
        if (x < 0 || y < 0 || y >= matrix.length || x >= matrix[0].length) {
            return 0;
        }
        if (matrix[y][x] == 0) {
            return 0;
        }

        int size = 1;
        matrix[y][x] = 0;

        for (int row = y - 1; row <= y + 1; row++) {
            for (int col = x - 1; col <= x + 1; col++) {
                if (y != row || x != col)
                    size += getSize(matrix, row, col);
            }
        }
        return size;
    }

    public static int connectedCell2(int[][] matrix) {
        int max = 0;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    int size = getSize(matrix, y, x);
                    max = Math.max(size, max);
                }
            }
        }
        return max;
    }
}
