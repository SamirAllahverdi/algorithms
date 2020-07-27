package hackerRank.medium;

import java.util.*;
import java.util.stream.Collectors;

public class CountLuck {
    /**
     * https://www.hackerrank.com/challenges/count-luck/problem
     */
    public static void main(String[] args) {

        String[] matrix = {".X.X......X",
                ".X*.X.XXX.X",
                ".XX.X.XM...",
                "......XXXX."};
        int k = 3;
        System.out.println(countLuck(matrix, k));


//        FOR LOOKING at GRID

//        Arrays.stream(matrix).forEach(a -> {
//            System.out.print(a);
//            System.out.println();
//        });
//

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
            return "Pair:  " +
                    "y = " + y +
                    ", x = " + x;
        }
    }

    static char[][] convertToCharArr(String[] matrix) {
        char[][] charMatrix = new char[matrix.length][];
        for (int i = 0; i < charMatrix.length; i++) {
            charMatrix[i] = matrix[i].toCharArray();
        }
        return charMatrix;
    }

    static String countLuck(String[] matrix, int k) {
        Location start = findStartingPoint(matrix, "M");
        Location destination = findStartingPoint(matrix, "*");

        char[][] charArray = convertToCharArr(matrix);

        Map<Location, Integer> forward = buildJunglePointsInfo(charArray, start, destination);

        return forward.get(destination) == k ? "Impressed" : "Oops!";
    }

    private static Map<Location, Integer> buildJunglePointsInfo(char[][] charArray, Location start, Location destination) {


        Map<Location, Integer> distanceInfoMap = new HashMap<>();
        distanceInfoMap.put(start, 0);

        LinkedList<Location> queue = new LinkedList<>();
        queue.add(start);


        while (!queue.isEmpty()) {

            Location currentLocation = queue.poll();
            charArray[currentLocation.y][currentLocation.x] = '0';

            List<Location> pairsList = getAdjacentPoints(charArray, currentLocation);
            int count = distanceInfoMap.get(currentLocation);

            for (Location next : pairsList) {
                if (distanceInfoMap.get(next) == null) {
                    int nextCount = pairsList.size() == 1 ? count : count + 1;
                    distanceInfoMap.put(next, nextCount);
                    if (next.equals(destination)) {
                        return distanceInfoMap;
                    }
                    queue.add(next);
                }
            }
        }

        return distanceInfoMap;
    }

    private static List<Location> getAdjacentPoints(char[][] charArray, Location start) {
        List<Location> directions = new ArrayList<>();

        int y = start.y;
        int x = start.x;

        directions.add(new Location(y, x + 1));
        directions.add(new Location(y, x - 1));
        directions.add(new Location(y + 1, x));
        directions.add(new Location(y - 1, x));

        return filterPossibleLocations(directions, charArray);
    }

    private static List<Location> filterPossibleLocations(List<Location> directions, char[][] charArray) {
        return directions.stream().filter(a ->
                (a.x >= 0 && a.x < charArray[0].length)
                        && (a.y >= 0 && a.y < charArray.length)
                        && (charArray[a.y][a.x] == '.' || charArray[a.y][a.x] == '*'))
                .collect(Collectors.toList());
    }

    private static Location findStartingPoint(String[] matrix, String l) {
        for (int a = 0; a < matrix.length; a++) {
            if (matrix[a].contains(l)) return new Location(a, matrix[a].indexOf(l));
        }
        return new Location(0, 0);
    }

}
