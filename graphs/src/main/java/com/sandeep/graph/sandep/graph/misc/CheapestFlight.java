package com.sandeep.graph.sandep.graph.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CheapestFlight {
   private class Min {
      int minimum;
   }

   public int getCost(List<Integer> path, int cost[][]) {
      int total =0;
      for(int i = 1; i < path.size(); i++) {
         total = total + cost[path.get(i-1)][path.get(i)];
      }
      return total;
   }

   public void findCheapestPriceUtil(Map<Integer, List<Integer>> graph, int s, int d, Min min,
                                          Map<Integer, Boolean> visited, List<Integer> path, int cost[][], int k) {
      if(s == d) {
         if(path.size()-2 > k) {
            return;
         }
         int total = getCost(path, cost);
         if(total < min.minimum) {
            min.minimum = total;
         }
      }

      visited.put(s, true);
      List<Integer> neighbours = graph.get(s);
      if(neighbours!=null) {
         for(int neighbour: neighbours) {
            if(!visited.get(neighbour)) {
               path.add(neighbour);
               findCheapestPriceUtil(graph, neighbour, d, min, visited, path, cost, k);
               path.remove(new Integer(neighbour));
            }
         }
      }
      visited.put(s, false);
   }

   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      int rows = flights.length;
      Map<Integer, List<Integer>> graph = new HashMap<>();
      Set<Integer> vertex = new HashSet<>();
      int cost[][] = new int[n][n];
      for(int i=0; i < rows; i++) {
         cost[flights[i][0]][flights[i][1]] = flights[i][2];
         List<Integer> neighbours = graph.get(flights[i][0]);
         if(neighbours == null) {
            neighbours = new ArrayList<>();
         }
         neighbours.add(flights[i][1]);
         graph.put(flights[i][0], neighbours);

         vertex.add(flights[i][0]);
         vertex.add(flights[i][1]);
      }
      Map<Integer, Boolean> visited = new HashMap();
      for(int v: vertex) {
         visited.put(v, false);
      }
      Min min = new Min();
      min.minimum = Integer.MAX_VALUE;

      List<Integer> path = new ArrayList<>();
      path.add(src);
      findCheapestPriceUtil(graph, src, dst, min, visited, path, cost, k);
      return min.minimum;
   }

   public static void main(String args[]) {
      int flights[][] =  {{0,1,100},{1,2,100},{0,2,500}};
      CheapestFlight obj = new CheapestFlight();
      int res = obj.findCheapestPrice(3, flights, 0 ,2,0);
      System.out.println("min cost: " + res);
   }
}
