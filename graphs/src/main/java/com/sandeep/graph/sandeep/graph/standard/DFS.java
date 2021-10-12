package com.sandeep.graph.sandeep.graph.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {

   static void addEdge(Map<Character, List<Character>> graph, char source, char target) {
      List<Character> list = graph.get(source);
      if(list == null) {
         list = new ArrayList<>();
      }
      list.add(target);
      graph.put(source, list);
   }

   static void printGraph(Map<Character, List<Character>> graph) {
      for(Map.Entry<Character, List<Character>> entry: graph.entrySet()) {
         Character source = entry.getKey();
         List<Character> list = entry.getValue();
         for(Character target: list) {
            System.out.println(source + " -> " + target);
         }
      }
   }

   static Set<Character> getAllVertex(Map<Character, List<Character>> graph) {
      Set<Character> set = new HashSet<>();
      for(Map.Entry<Character, List<Character>> entry: graph.entrySet()) {
         Character source = entry.getKey();
         List<Character> list = entry.getValue();
         for(Character target: list) {
            set.add(source);
            set.add(target);
         }
      }
      return set;
   }

   static void dfsUtil(Map<Character, List<Character>> graph, char v, Map<Character, Boolean> visited) {
      System.out.print(v + " ");
      visited.put(v, true);
      List<Character> neighbours = graph.get(v);
      for(Character neighbour: neighbours) {
         if(!visited.get(neighbour)) {
            dfsUtil(graph, neighbour, visited);
         }
      }
   }

   static void doDFSTraversal(Map<Character, List<Character>> graph) {
      Map<Character, Boolean> visited = new HashMap<>();
      Set<Character> vertex = getAllVertex(graph);
      for(Character v:  vertex) {
         visited.put(v, false);
      }

      for(Character v: vertex) {
         if(!visited.get(v)) {
            dfsUtil(graph, v, visited);
         }
      }
   }

   public static void main(String args[]) {
      Map<Character, List<Character>> graph =new HashMap<>();
      addEdge(graph, 'u', 'v');
      addEdge(graph, 'u', 'x');
      addEdge(graph, 'x', 'v');
      addEdge(graph, 'v', 'y');
      addEdge(graph, 'y', 'x');
      addEdge(graph, 'w', 'y');
      addEdge(graph, 'w', 'z');
      addEdge(graph, 'z', 'z');
      printGraph(graph);
      doDFSTraversal(graph);
   }
}
