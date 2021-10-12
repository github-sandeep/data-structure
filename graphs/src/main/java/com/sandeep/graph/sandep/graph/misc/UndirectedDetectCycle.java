package com.sandeep.graph.sandep.graph.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UndirectedDetectCycle {
   static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
      adj.get(u).add(v);
      adj.get(v).add(u);
   }

   static ArrayList<ArrayList<Integer>> createAdjacencyList(int A, int[][] B) {
      ArrayList<ArrayList<Integer>> adj
            = new ArrayList<ArrayList<Integer> >(A+1);

      for (int i = 0; i < A+1; i++)
         adj.add(new ArrayList<Integer>());

      for(int i =0; i < B.length ; i++) {
         addEdge(adj, B[i][0],B[i][1]);
      }
      return adj;
   }

   static boolean DFS(ArrayList<ArrayList<Integer> > adj,  Map<Integer, Boolean> visited, int curr, int parent) {
      visited.put(curr, true);
      List<Integer> neighbours = adj.get(curr);
      for(Integer neighbour: neighbours) {
         if(neighbour == parent) {
            continue;
         }
         if(visited.get(neighbour)) {
            return true;
         }
         if(!visited.get(neighbour)) {
            if(DFS(adj, visited, neighbour, curr)) {
               return true;
            }
         }
      }
      return false;
   }

   static int solve(int A, int[][] B) {
      ArrayList<ArrayList<Integer> > adj = createAdjacencyList(A,B);
      Set<Integer> vertex = new HashSet<>();
      Map<Integer, Boolean> visited = new HashMap<>();
      for(int i =0; i < B.length ; i++) {
         vertex.add(B[i][0]);
         vertex.add(B[i][1]);
         visited.put(B[i][0], false);
         visited.put(B[i][1], false);
      }
      for(Integer start: vertex) {
         if(!visited.get(start)) {
            if(DFS(adj, visited, start, -1)) {
               return 1;
            }
         }
      }
      return 0;
   }

   public static void main(String args[]) {
      int[][] foo =
            {
                  {1,2},
                  {1,3},
                  {2,3},
                  {1,4},
                  {4,5}
            };
      if(solve(5, foo) ==1) {
         System.out.println("Cycle detected");
      } else {
         System.out.println("Cycle not detected");
      }

      int[][] foo1 =
            {
                  {1,2},
                  {1,3}
            };
      if(solve(3, foo1) ==1) {
         System.out.println("Cycle detected");
      } else {
         System.out.println("Cycle not detected");
      }
   }
}
