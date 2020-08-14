package hackerRank.medium;

import java.util.*;

public class BreadthFirstSearchShortestReach {

    /**
     * https://www.hackerrank.com/challenges/bfsshortreach/problem
     */


    static int V;
    static LinkedList<Integer> [] adj;
    static int [] distance;
    static boolean [] visited;
    static void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public static void main(String[] args) {

        System.out.println(b);
    }
    static void initialize(int V,int m,int [][] edges){
        BreadthFirstSearchShortestReach.V=V;
        visited=new boolean[V+1];
        distance=new int[V+1];
        adj=(LinkedList<Integer> [] ) new LinkedList[V+1];


        for(int i=0;i<=V;i++){
            adj[i]= new LinkedList<>();
        }


        for(int i=0;i<m;i++){
            addEdge(edges[i][0],edges[i][1]);
        }
    }
    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        initialize(n,m,edges);
        Queue<Integer> q=new LinkedList<>();
        int result []=new int[n-1];
        q.add(s);
        visited[s]=true;
        distance[s]=0;
        while(q.size()!=0){
            int parent=q.remove();
            for(int w:BreadthFirstSearchShortestReach.adj[parent]){
                if(!visited[w])
                {
                    q.add(w);
                    distance[w]=distance[parent]+6;
                    visited[w]=true;
                }
            }

        }

        int original=1;
        int trimmed=0;
        while(original!=n+1){
            if(original==s){
                original+=1;
                continue;
            }
            result[trimmed]=distance[original];
            if(distance[original]==0){
                result[trimmed]=-1;
            }
            original+=1;
            trimmed+=1;
        }

        return result;
    }
}
