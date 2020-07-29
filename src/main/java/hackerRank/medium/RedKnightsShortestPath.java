package hackerRank.medium;

import java.util.*;
import java.util.stream.Collectors;

public class RedKnightsShortestPath {

    /**
     * https://www.hackerrank.com/challenges/red-knights-shortest-path/problem
     */

    public static void main(String[] args) {

        int n = 7, start_i = 6, start_j = 6, end_i = 0, end_j = 1;

        printShortestPath(n, start_i, start_j, end_i, end_j);
    }

    static class Location {

        public final int i;
        public final int j;
        public String direction;

        public Location(int i, int j, String direction) {
            this.j = j;
            this.i = i;
            this.direction = direction;
        }

        @Override
        public int hashCode() {
            return j << 16 + i;
        }

        @Override
        public boolean equals(Object obj) {
            Location location = (Location) obj;
            return location.j == this.j && location.i == this.i;
        }

        @Override
        public String toString() {
            return "Location:" +
                    ", i = " + i +
                    ", j = " + j +
                    ", direction = " + direction;
        }
    }

    static class Info {

        private final int distance;
        private final String direction;
        private final Location lastLocation;

        public Info(int distance, Location lastLocation, String direction) {
            this.distance = distance;
            this.direction = direction;
            this.lastLocation = lastLocation;
        }
    }

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {

        Location start = new Location(i_start, j_start, "");
        Location destination = new Location(i_end, j_end, "");

        Map<Location, Info> hashMap = getInfoAboutShortestPath(n, start, destination);

        printShortestPath(start, destination, hashMap);

    }

    static void printShortestPath(Location start, Location destination, Map<Location, Info> hashMap) {

        LinkedList<Location> queue = new LinkedList<>();
        queue.push(destination);

        Location previous = hashMap.containsKey(destination) ? hashMap.get(destination).lastLocation : null;


        while (previous != null && !previous.equals(start)) {
            queue.push(previous);
            previous = hashMap.containsKey(previous) ? hashMap.get(previous).lastLocation : null;
        }

        if (previous == null) {
            System.out.print("Impossible");
        } else {
            System.out.println(hashMap.get(destination).distance);
            queue.forEach(s -> System.out.print(s.direction + " "));
        }

    }

    static Map<Location, Info> getInfoAboutShortestPath(int n, Location start, Location destination) {

        Map<Location, Info> infoMap = new HashMap<>();
        infoMap.put(start, new Info(0, start, ""));

        Queue<Location> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            Location curr = queue.poll();

            List<Location> currentAdjacents = possibleAdjacents(curr, n);

            for (Location next : currentAdjacents) {
                if (infoMap.get(next) == null) {

                    int nextDistance = infoMap.get(curr).distance + 1;
                    String direction = infoMap.get(curr).direction;

                    infoMap.put(next, new Info(nextDistance, curr, direction));

                    if (next.equals(destination)) {
                        destination.direction = next.direction;
                        return infoMap;
                    }
                    queue.add(next);
                }
            }
        }

        return infoMap;
    }

    static List<Location> possibleAdjacents(Location curr, int n) {
        List<Location> list = fillArray(curr);

        return list.stream().filter(a ->
                (a.j >= 0 && a.j < n)
                        && (a.i >= 0 && a.i < n)
        ).collect(Collectors.toList());
    }

    static List<Location> fillArray(Location curr) {

        return Arrays.asList(new Location(curr.i - 2, curr.j - 1, "UL"),
                new Location(curr.i - 2, curr.j + 1, "UR"),
                new Location(curr.i, curr.j + 2, "R"),
                new Location(curr.i + 2, curr.j + 1, "LR"),
                new Location(curr.i + 2, curr.j - 1, "LL"),
                new Location(curr.i, curr.j - 2, "L"));
    }


}
