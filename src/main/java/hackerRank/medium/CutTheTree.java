package hackerRank.medium;

import java.util.*;

public class CutTheTree {
    /**
     * https://www.hackerrank.com/challenges/cut-the-tree/problem
     */


    public static void main(String[] args) {

        List<Integer> data = Arrays.asList(100, 200, 100, 500, 100, 600);
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3),
                Arrays.asList(2, 5), Arrays.asList(4, 5), Arrays.asList(5, 6));
        System.out.println(cutTheTree(data, edges));
    }


    static int[] subarray;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    static HashMap<Integer, Integer> map;  //child,parent

    public static int getUnvisited(int index) {
        System.out.println("ADJLIST " + adjList[index]);
        for (int i = 0; i < adjList[index].size(); i++) {
            int v = adjList[index].get(i);
            if (!visited[v])
                return v;
        }
        return -1;

    }

    public static void dfs(int index) {

        Stack<Integer> stack = new Stack<>();
        stack.add(index);

        map.put(index, -1); // root of parent is none
        visited[index] = true;

        while (stack.size() >= 1) {
            int s = stack.peek();
            int next = getUnvisited(s);
            System.out.println("Next " + next );
            if (next == -1) {
                int out = stack.pop();

                System.out.println("IF ");
                System.out.println("Out " + out);

                int sum = subarray[out];
                for (int j = 0; j < adjList[out].size(); j++) {
                    int v = adjList[out].get(j);
                    sum = sum + subarray[v];
                }

                subarray[out] = sum;
                System.out.println("SUM " + sum);
                if (map.get(out) != -1) {

                    System.out.println("MAP.GET(OUT) " + map.get(out));
                    System.out.println("subarray[out] = " + subarray[out] + " - " +  subarray[map.get(out)]);

                    subarray[out] = subarray[out] - subarray[map.get(out)];
                    System.out.println("subarray[out] = " + subarray[out]);
                }

            } else {

                System.out.println("ElSE ");
                map.put(next, s); //child,parent
                stack.add(next);
                visited[next] = true;
                System.out.println("STACK " + stack);
                System.out.println("MAP " + map);
                System.out.println("S " + s);
            }
            System.out.println("--------------");
        }
    }


    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {

        int n = data.size();

        subarray = new int[n];
        visited = new boolean[n];
        adjList = new ArrayList[n];


        int total = 0;
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            total = total + data.get(i);
            subarray[i] = data.get(i);
        }


        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adjList[u - 1].add(v - 1);
            adjList[v - 1].add(u - 1);
        }

        dfs(0);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
             min = Math.min(min,Math.abs(total - 2 * subarray[i]));
        }
        return min;

    }

}
