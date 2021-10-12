package com.sandeep.graph.sandep.graph.misc;

import java.util.ArrayList;
import java.util.List;

public class AllPath {
   private static List<List<Integer>> ans = new ArrayList<>();

   public static List<Integer> getNeighbours(int[][] graph, int v) {
      List<Integer> neighbours = new ArrayList<>();
      for(int j =0; j < graph[v].length ;j ++) {
         neighbours.add(graph[v][j]);
      }
      return neighbours;
   }

   public static void dfs(int[][] graph, int s, int d, List<Integer> path,
                   boolean visited[]) {
      if(s==d) {
         List<Integer> pathToAdd = new ArrayList<>();
        for(int i: path) {
           pathToAdd.add(i);
        }
         ans.add(pathToAdd);
         return;
      }
      visited[s] = true;
      List<Integer> neighbours = getNeighbours(graph, s);
      for(int neighbour: neighbours) {
         if(!visited[neighbour]) {
            path.add(neighbour);
            dfs(graph, neighbour, d, path, visited);
            path.remove(new Integer(neighbour));
         }
      }
      visited[s] = false;
   }

   public static void allPathsSourceTargetUtil(int[][] graph, int s, int d, int n) {
      boolean visited[] = new boolean[n];
      for(int i =0; i < n ; i++) {
         visited[i] = false;
      }
      List<Integer> path = new ArrayList<>();
      path.add(s);
      dfs(graph, s, d, path, visited);
      //return ans;
   }

   public static void allPathsSourceTarget(int[][] graph) {
      int n = graph.length;
      int d = n-1;
      int s = 0;
      allPathsSourceTargetUtil(graph, s, d, n);
   }

   public static void main(String args[]) {
      int graph[][] = {{1,2},{3},{3},{}};
      allPathsSourceTarget(graph);
      System.out.println(ans);
   }
}
