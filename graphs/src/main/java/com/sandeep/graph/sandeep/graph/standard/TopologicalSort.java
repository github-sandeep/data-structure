package com.sandeep.graph.sandeep.graph.standard;

import com.sandeep.graph.common.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
   public static void topologicalSortUtil(
         Graph graph, Integer vertex, Stack<Integer> stack,
         Map<Integer, Boolean> visited) {
      visited.put(vertex, true);
      Set<Integer> neighbours = graph.getNeighbours(vertex);
      for(Integer neighbour : neighbours) {
         if(!visited.get(neighbour)) {
            topologicalSortUtil(graph, neighbour, stack, visited);
         }
      }
      // now either vertex has no neighbour or all neighbours are already visited
      stack.push(vertex);
   }

   public static Stack<Integer> getTopologicalSort(Graph graph) {
      Stack<Integer> stack = new Stack<>();
      Set<Integer> vertices = graph.getAllVertices();
      Map<Integer, Boolean> visited = new HashMap<>();
      for(Integer vertex: vertices) {
         visited.put(vertex, false);
      }
      for(Integer vertex: vertices) {
         if(!visited.get(vertex)) {
            topologicalSortUtil(graph, vertex, stack, visited);
         }
      }
      return stack;
   }

   public static void main(String args[]) {
      Graph<Integer> graph = new Graph(true);
      graph.addEdge(1, 3);
      graph.addEdge(1, 2);
      graph.addEdge(2, 4);
      graph.addEdge(2, 5);
      graph.addEdge(3, 4);
      graph.addEdge(3, 6);
      graph.addEdge(4, 5);
      graph.addEdge(4, 6);

      Stack<Integer> result = getTopologicalSort(graph);
      while(!result.isEmpty()) {
         System.out.println(result.pop());
      }
   }
}
