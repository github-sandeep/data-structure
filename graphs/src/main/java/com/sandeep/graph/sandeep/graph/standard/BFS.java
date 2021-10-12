package com.sandeep.graph.sandeep.graph.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS {
   static void addEdge(Map<Character, List<Character>> graph, char source, char target) {

      List<Character> list = graph.get(source);
      if (list == null) {
         list = new ArrayList<>();
         list.add(target);
      } else {
         list.add(target);
      }
      graph.put(source, list);
   }

   static void printGraph(Map<Character, List<Character>> graph) {

      for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
         Character source = entry.getKey();
         List<Character> list = entry.getValue();
         for (Character target : list) {
            System.out.println(source + " -> " + target);
         }
      }
   }

   static Set<Character> getAllVertex(Map<Character, List<Character>> graph) {

      Set<Character> set = new HashSet<>();
      for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
         Character source = entry.getKey();
         List<Character> list = entry.getValue();
         for (Character target : list) {
            set.add(source);
            set.add(target);
         }
      }
      return set;
   }

   static void bfsUtil(Map<Character, List<Character>> graph, Character source, Map<Character, Boolean> visited) {

      Queue<Character> queue = new LinkedList<>();
      queue.add(source);
      visited.put(source, true);
      while (!queue.isEmpty()) {
         Character v = queue.poll();
         System.out.print(v + " ");
         List<Character> neighbours = graph.get(v);
         for (Character neighbour : neighbours) {
            if (!visited.get(neighbour)) {
               visited.put(neighbour, true);
               queue.add(neighbour);
            }
         }
      }
   }

   static void doBFSTraversal(Map<Character, List<Character>> graph) {

      Map<Character, Boolean> visited = new HashMap<>();
      Set<Character> vertex = getAllVertex(graph);
      for (Character v : vertex) {
         visited.put(v, false);
      }
      bfsUtil(graph, 's', visited);
   }

   public static void main(String args[]) {

      Map<Character, List<Character>> graph = new HashMap<>();
      addEdge(graph, 'r', 's');
      addEdge(graph, 's', 'r');
      addEdge(graph, 'r', 'v');
      addEdge(graph, 'v', 'r');
      addEdge(graph, 's', 'w');
      addEdge(graph, 'w', 's');
      addEdge(graph, 'w', 't');
      addEdge(graph, 't', 'w');
      addEdge(graph, 'w', 'x');
      addEdge(graph, 'x', 'w');
      addEdge(graph, 't', 'x');
      addEdge(graph, 'x', 't');
      addEdge(graph, 't', 'u');
      addEdge(graph, 'u', 't');
      addEdge(graph, 'x', 'y');
      addEdge(graph, 'y', 'x');
      addEdge(graph, 'x', 'u');
      addEdge(graph, 'u', 'x');
      addEdge(graph, 'u', 'y');
      addEdge(graph, 'y', 'u');
      printGraph(graph);
      doBFSTraversal(graph);
   }
}
