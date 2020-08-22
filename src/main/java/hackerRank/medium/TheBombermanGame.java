package hackerRank.medium;

import java.util.*;

public class TheBombermanGame {

    public static void main(String[] args) {
        int n = 5;
//        String[] grid = {".......", "...0...", "....0..", ".......", "00.....", "00....."};
        String[] grid2 = {".......", "...O.O.", "....O..", "..O....", "OO...OO", "OO.O..."};

        Arrays.stream(bomberMan(n, grid2)).forEach(a -> {
            System.out.println(Arrays.toString(a));
            System.out.println();
        });
    }

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

    static char[][] bomberMan(int n, String[] grid) {
        char[][] charArray = conStToCharArr(grid);

        if (n == 1) {
            return charArray;
        } else if (n % 2 == 0) {
            return fillArrayWithZeros(charArray);
        } else if (n % 4 == 3) {
            return explode(charArray);
        } else {
            explode(charArray);

            System.out.println("Given Grid ");
            Arrays.stream(charArray).forEach(a -> {
                System.out.println(Arrays.toString(a));
                System.out.println();
            });
            return explode(charArray);
        }
    }

    private static char[][] conStToCharArr(String[] grid) {

        char[][] arr = new char[grid.length][grid[0].length()];

        for (int a = 0; a < grid.length; a++) {
            arr[a] = grid[a].toCharArray();
        }


        return arr;
    }

    private static char[][] fillArrayWithZeros(char[][] array) {
        for (char[] chars : array) Arrays.fill(chars, 'O');
        return array;
    }

    static char[][] explode(char[][] grid) {
        ArrayList<Location> bombs = addBombs(grid);

        fillArrayWithZeros(grid);

        for (Location l : bombs) {
            grid[l.y][l.x] = '.';

            if (l.y + 1 < grid.length) {
                grid[l.y + 1][l.x] = '.';
            }

            if (l.y - 1 >= 0) {
                grid[l.y - 1][l.x] = '.';
            }

            if (l.x + 1 < grid[0].length) {

                grid[l.y][l.x + 1] = '.';
            }

            if (l.x - 1 >= 0) {
                grid[l.y][l.x - 1] = '.';
            }
        }

        return grid;
    }

    private static ArrayList<Location> addBombs(char[][] grid) {
        ArrayList<Location> arrayList = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'O') {
                    arrayList.add(new Location(i,j));
                }
            }
        }
        return arrayList;
    }


}
