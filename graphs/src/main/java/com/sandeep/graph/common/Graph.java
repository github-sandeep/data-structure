package com.sandeep.graph.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
   private Map<T, Set<T>> verticesMap;
   private int edgesCout;
   private boolean isDirected;

   public Graph(boolean isDirected) {
      verticesMap = new HashMap<>();
      this.isDirected = isDirected;
   }

   public int getNumberOfVertices() {
      return verticesMap.size();
   }

   public int getNumberOfEdges() {
      return edgesCout;
   }

   public int getDegree(T vertex) {
      if(!hasVertex(vertex)) throw new IllegalArgumentException(vertex.toString() + " is invalid vertex");
      return verticesMap.get(vertex).size();
   }

   public boolean hasVertex(T vertex) {
      return verticesMap.containsKey(vertex);
   }

   public boolean hasEdge(T u, T v) {
      if(!hasVertex(u)) throw new IllegalArgumentException(u.toString() + " is invalid vertex");
      if(!hasVertex(v)) throw new IllegalArgumentException(v.toString() + " is invalid vertex");
      return verticesMap.get(u).contains(v);
   }

   public void addVertex(T vertex) {
      if(!hasVertex(vertex)) verticesMap.put(vertex, new HashSet<>());
   }

   public void printGraph() {
      for(Map.Entry<T, Set<T>> entry : verticesMap.entrySet()) {
         T vertex = entry.getKey();
         Set<T> neighbours = entry.getValue();
         for(T neighbour: neighbours) {
            System.out.println(vertex.toString() + " -> " + neighbour.toString());
         }
      }
   }

   public void addEdge(T u, T v) {
      if(!hasVertex(u)) addVertex(u);
      if(!hasVertex(v)) addVertex(v);
      if(!hasEdge(u,v)) edgesCout++;
      verticesMap.get(u).add(v);
      if(!isDirected) verticesMap.get(v).add(u);
   }

   public Set<T> getAllVertices() {
      Set<T> vertices = new HashSet<>();
      for(Map.Entry<T, Set<T>> entry : verticesMap.entrySet()) {
         vertices.add(entry.getKey());
      }
      return vertices;
      //return verticesMap.values();
   }

   public Set<T> getNeighbours(T vertex) {
      return verticesMap.get(vertex);
   }
}
