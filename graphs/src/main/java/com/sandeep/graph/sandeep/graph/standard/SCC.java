package com.sandeep.graph.sandeep.graph.standard;

import com.sandeep.graph.common.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SCC {
   private static void dfsUtil(
           Graph<Integer> graph, Stack<Integer> stack, Map<Integer, Boolean> visited,
         Integer vertex) {
      visited.put(vertex, true);
      Set<Integer> neighbours = graph.getNeighbours(vertex);
      for(Integer neighbour: neighbours) {
         if(!visited.get(neighbour)) {
            dfsUtil(graph, stack, visited, neighbour);
         }
      }
      stack.push(vertex);
   }

   private static void doDfs(Graph<Integer> graph, Stack<Integer> stack) {
      Set<Integer> vertices = graph.getAllVertices();
      Map<Integer, Boolean> visited = new HashMap<>();
      for(Integer vertex: vertices) {
         visited.put(vertex, false);
      }

      for(Integer vertex: vertices) {
         if(!visited.get(vertex)) {
            dfsUtil(graph, stack, visited, vertex);
         }
      }
   }

   private static Stack<Integer> getDfsStack(Graph<Integer> graph) {
      Stack<Integer> stack = new Stack<>();
      doDfs(graph, stack);
      return stack;
   }

   private static Graph<Integer> getTranspose(Graph<Integer> graph) {
      Graph<Integer> graphT = new Graph<>(true);
      Set<Integer> vertices = graph.getAllVertices();
      for(Integer vertex: vertices) {
         Set<Integer> neighbours = graph.getNeighbours(vertex);
         for(Integer neighbour: neighbours) {
            graphT.addEdge(neighbour, vertex);
         }
      }
      return graphT;
   }

   private static void dfsUtilPrint(Graph<Integer> graph, Map<Integer, Boolean> visited, Integer vertex) {
      visited.put(vertex, true);
      System.out.print(vertex + " ");
      Set<Integer> neighbours = graph.getNeighbours(vertex);
      for(Integer neighbour: neighbours) {
         if(!visited.get(neighbour)) {
            dfsUtilPrint(graph, visited, neighbour);
         }
      }
   }

   private static void printDfs(Graph<Integer> graph, Stack<Integer> stack) {
      Set<Integer> vertices = graph.getAllVertices();
      Map<Integer, Boolean> visited = new HashMap<>();
      for(Integer vertex: vertices) {
         visited.put(vertex, false);
      }

      while(!stack.isEmpty()) {
         Integer vertex = stack.pop();
         if(!visited.get(vertex)) {
            dfsUtilPrint(graph, visited, vertex);
         }
         System.out.println();
      }
   }

   private static void sscTraverse(Graph<Integer> graph) {
      Stack<Integer> stack = getDfsStack(graph);
      Graph<Integer> graphT = getTranspose(graph);
      //graphT.printGraph();
      printDfs(graphT, stack);
   }

   public static void main(String args[]){
      Graph<Integer> graph = new Graph<>(true);
      graph.addEdge(0, 1);
      graph.addEdge(1, 2);
      graph.addEdge(2, 0);
      graph.addEdge(1, 3);
      graph.addEdge(3, 4);
      graph.addEdge(4, 5);
      graph.addEdge(5, 3);
      graph.addEdge(5, 6);
      //graph.printGraph();
      sscTraverse(graph);
      /*StronglyConnectedComponent scc = new StronglyConnectedComponent();
      List<Set<Vertex<Integer>>> result = scc.scc(graph);

      //print the result
      result.forEach(set -> {
         set.forEach(v -> System.out.print(v.getId() + " "));
         System.out.println();
      });*/
   }
}
