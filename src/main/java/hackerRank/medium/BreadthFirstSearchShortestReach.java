package hackerRank.medium;

import java.util.*;

public class BreadthFirstSearchShortestReach {

    /**
     * https://www.hackerrank.com/challenges/bfsshortreach/problem
     */

    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int s = 1;
        int[][] edges = {{1, 2}, {1, 3}};

        System.out.println(Arrays.toString(bfs(n, m, edges, s)));
    }


    static LinkedList<LinkedList<Integer>> initLinkedList(int n, int m, int[][] edges) {
        LinkedList<LinkedList<Integer>> adj = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        return adj;
    }

    static int[] bfs(int n, int m, int[][] edges, int s) {
        LinkedList<LinkedList<Integer>> adj = initLinkedList(n, m, edges);

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];


        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        visited[s] = true;
        distance[s] = 0;

        while (q.size() != 0) {
            int parent = q.remove();
            for (int w : adj.get(parent)) {
                if (!visited[w]) {
                    q.add(w);
                    distance[w] = distance[parent] + 6;
                    visited[w] = true;
                }
            }
        }

        return getResults(n, distance, s);
    }

    private static int[] getResults(int n, int[] distance, int s) {
        int[] result = new int[n - 1];

        int original = 1;
        int trimmed = 0;

        while (original < n + 1) {
            if (original == s) {
                original++;
                continue;
            } else if (distance[original] == 0) {
                result[trimmed] = -1;
            } else {
                result[trimmed] = distance[original];
            }

            original ++;
            trimmed ++;
        }
        return result;
    }
}
