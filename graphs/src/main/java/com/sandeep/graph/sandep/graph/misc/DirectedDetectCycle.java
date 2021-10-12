package com.sandeep.graph.sandep.graph.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectedDetectCycle {
   static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
      adj.get(u).add(v);
   }

   static ArrayList<ArrayList<Integer>> createAdjacencyList(int A, int[][] B) {
      ArrayList<ArrayList<Integer> > adj
            = new ArrayList<ArrayList<Integer> >(A+1);

      for (int i = 0; i < A+1; i++)
         adj.add(new ArrayList<Integer>());

      for(int i =0; i < B.length ; i++) {
         addEdge(adj, B[i][0],B[i][1]);
      }
      return adj;
   }

   static void moveVertex(int curr, Set<Integer> source, Set<Integer> target) {
      source.remove(curr);
      target.add(curr);
   }

   static boolean DFS(ArrayList<ArrayList<Integer> > adj, int curr, Set<Integer> whiteSet, Set<Integer> graySet,
                      Set<Integer> blackSet) {
      moveVertex(curr, whiteSet, graySet);
      List<Integer> neighbours = adj.get(curr);
      for(Integer neighbour: neighbours) {
         if(blackSet.contains(neighbour)) {
            continue;
         }
         if(graySet.contains(neighbour)) {
            return true;
         }
         if(DFS(adj, neighbour, whiteSet, graySet, blackSet)) {
            return true;
         }
      }
      moveVertex(curr,graySet, blackSet);
      return false;
   }

   static int solve(int A, int[][] B) {
      ArrayList<ArrayList<Integer> > adj = createAdjacencyList(A,B);
      Set<Integer> whiteSet = new HashSet<>();
      Set<Integer> graySet = new HashSet<>();
      Set<Integer> blackSet = new HashSet<>();
      for(int i =0; i < B.length ; i++) {
         whiteSet.add(B[i][0]);
         whiteSet.add(B[i][1]);
      }
      while(whiteSet.size() > 0) {
         int curr = whiteSet.iterator().next();
         if(DFS(adj, curr, whiteSet, graySet, blackSet)) {
            return 1;
         }
      }
      return 0;
   }

   public static void main(String args[]) {
      int[][] g1 =
            {
               {1,2},
               {4,1},
               {2,4},
               {3,4},
               {5,2},
               {1,3}
            };
      if(solve(5, g1) ==1) {
         System.out.println("Cycle detected");
      } else {
         System.out.println("Cycle not detected");
      }
      int[][] g2 =
            {
                  {1,2},
                  {2,3},
                  {3,4},
                  {4,5}
            };
      if(solve(5, g2) ==1) {
         System.out.println("Cycle detected");
      } else {
         System.out.println("Cycle not detected");
      }
   }
}
