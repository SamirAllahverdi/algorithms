package hackerRank.medium;

import java.util.*;

public class TheBombermanGame {

    public static void main(String[] args) {
        int n = 3;
        String[] grid = {".......", "...0...", "....0..", ".......", "00.....", "00....."};
        System.out.println(Arrays.toString(bomberMan(n, grid)));
    }

    static class Location {
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            Location location = (Location) o;
            return location.y == this.y && location.x == this.x;
        }

        @Override
        public int hashCode() {
            return y << 16 + x;
        }
    }

    static String[] bomberMan(int n, String[] grid) {

        char[][] charArray = fillCharArray(grid);

        Set<Location> hashSet = new HashSet<>();

        for (int a = 0; a < n; a++) {
            if (a % 3 == 0) {
                firstSecond(charArray);
            } else if (a % 3 == 1) {
                hashSet = secondSecond(charArray);
            } else {
                System.out.println("THIRD");
                thirdSecond(hashSet, charArray);
            }
        }

        return convToString(charArray);

    }

    private static String[] convToString(char[][] charArray) {
        StringBuilder[] array = new StringBuilder[charArray.length];
        String[] stArray = new String[charArray.length];
        for (int a = 0; a < charArray.length; a++) {
            array[a] = new StringBuilder();

            for (int b = 0; b < charArray.length; b++) {
                array[a].append(charArray[a][b]);
            }
            stArray[a] = array[a].toString();
        }

        return stArray;
    }

    private static char[][] fillCharArray(String[] grid) {

        char[][] arr = new char[grid.length][grid[0].length()];

        for (int a = 0; a < grid.length; a++) {
            arr[a] = grid[a].toCharArray();
        }


        return arr;
    }

    private static Set<Location> secondSecond(char[][] charArray) {

        Set<Location> locSet = new HashSet<>();


        for (int a = 0; a < charArray.length; a++) {
            for (int b = 0; b < charArray[0].length; b++) {
                if (charArray[a][b] == '.') {
                    charArray[a][b] = 'O';
                    locSet.add(new Location(a, b));
                }

            }
        }

        return locSet;
    }

    private static void thirdSecond(Set<Location> locSet, char[][] charArray) {


        for (int a = 0; a < charArray.length; a++) {
            for (int b = 0; b < charArray[0].length; b++) {
                if (!locSet.contains(new Location(a, b))) {
                    detonate(a, b, charArray);
                }
            }
        }
    }

    private static void detonate(int a, int b, char[][] charArray) {

        getPossibleDetonatedLocations(a, b).stream().
                filter(l -> (l.y < charArray.length && l.y >= 0) && (l.x < charArray[0].length && l.x >= 0))
                .forEach(l -> {
                    if (charArray[l.y][l.x] == 'O') {
                        charArray[l.y][l.x] = '.';
                    }
                });

    }

    private static List<Location> getPossibleDetonatedLocations(int a, int b) {
        return Arrays.asList(new Location(a + 1, b),
                new Location(a - 1, b),
                new Location(a, b + 1),
                new Location(a, b - 1),
                new Location(a, b));
    }

    private static void firstSecond(char[][] charArray) {


    }


}
