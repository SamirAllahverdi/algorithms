package hackerRank.medium;

import java.util.*;

public class TheBombermanGame {

    public static void main(String[] args) {
        int n = 10;
        String[] grid = {".......", "...0...", "....0..", ".......", "00.....", "00....."};

        Arrays.stream(bomberMan(n, grid)).forEach(a -> System.out.println(Arrays.toString(a)));
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

    static char[][] bomberMan(int n, String[] grid) {

        char[][] charArray = fillCharArray(grid);

        System.out.println("Char Array: ");
        Arrays.stream(charArray).forEach(a -> System.out.println(Arrays.toString(a)));

        Set<Location> hashSet = new HashSet<>();
        int newN = n % 3;
        for (int a = 0; a < newN; a++) {
            if (a % 3 == 0) {
                firstSecond(charArray);
            } else if (a % 3 == 1) {
                hashSet = secondSecond(charArray);
            } else {
                System.out.println("THIRD");
                thirdSecond(hashSet, charArray);
            }
        }

        return charArray;

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
//                System.out.println("A " + a + ", B " + b);
                if (charArray[a][b] == '.') {
                    charArray[a][b] = '0';
                    locSet.add(new Location(a, b));
                }

            }
        }
//
//        System.out.println("---------");
//        Arrays.stream(charArray).forEach(a -> System.out.println(Arrays.toString(a)));

//        thirdSecond(locSet, charArray);
        return locSet;
    }

    private static void thirdSecond(Set<Location> locSet, char[][] charArray) {

//        locSet.stream().forEach(a-> System.out.println("Loc y " + a.y + ", Loc x " + a.x ));

        for (int a = 0; a < charArray.length; a++) {
            for (int b = 0; b < charArray[0].length; b++) {
                if (!locSet.contains(new Location(a, b))) {
//                    System.out.println("___________________________");
//                    System.out.println("MUST BE DENOTED LOC " + a + "  " + b);
                    detonate(a, b, charArray);
//                    charArray[a][b] = '0';
                }
            }
        }
    }

    private static void detonate(int a, int b, char[][] charArray) {

        getPossibleDetonatedLocations(a, b).stream().
                filter(l -> (l.y < charArray.length && l.y >= 0) && (l.x < charArray[0].length && l.x >= 0))
                .forEach(l -> {
                    if (charArray[l.y][l.x] == '0') {
                        System.out.println("L:  y = " + l.y + " x = " + l.x);
                        charArray[l.y][l.x] = '.';
                    }
                });

        System.out.println("_______________________________");
        Arrays.stream(charArray).forEach(c -> System.out.println(Arrays.toString(c)));

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
