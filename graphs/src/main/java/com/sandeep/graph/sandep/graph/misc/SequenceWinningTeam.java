package com.sandeep.graph.sandep.graph.misc;

import com.sandeep.graph.common.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SequenceWinningTeam {
   public Graph createAdjacencyGraph(char outcome[][]) {
      Graph<Character> graph = new Graph(true);
      for(int i =0; i < outcome.length ; i++) {
         graph.addEdge(outcome[i][0], outcome[i][1]);
      }
      return graph;
   }

   public boolean isReachableDFS(Graph graph, char s, char d, Map<Character, Boolean> visited) {
      if(s == d) {
         return true;
      }
      if(visited.get(s) == null || visited.get(s)) {
         return false;
      }
      visited.put(s, true);
      Set<Character> neighbours = graph.getNeighbours(s);
      for(char neighbour: neighbours) {
         if(isReachableDFS(graph, neighbour, d, visited)) {
            return true;
         }
      }
      return false;
   }

   public static void main(String args[]) {
      char outcome[][] = {{'A', 'B'}, {'B', 'D'}, {'B', 'C'}, {'C', 'E'}};
      SequenceWinningTeam obj = new SequenceWinningTeam();
      Graph graph = obj.createAdjacencyGraph(outcome);
      Map<Character, Boolean> visited = new HashMap<>();
      Set<Character> vertices = graph.getAllVertices();
      for(char vertex: vertices) {
         visited.put(vertex, false);
      }
      System.out.println(obj.isReachableDFS(graph, 'A', 'E', visited));
   }
}
