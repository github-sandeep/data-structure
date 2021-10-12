package com.sandeep.graph.sandep.graph.misc;

public class ValidPathGrid {
   public boolean isSafe(int x, int y, int m, int n, boolean visited[][]) {
      return x >= 0 && x < m && y >=0 && y < n && visited[x][y] == false;
   }

   public boolean hasValidPathUtil(int[][] grid, int x, int y, boolean[][] visited, int m, int n) {
      if(x == m-1 && y == n-1) {
         return true;
      }

      visited[x][y] = true;
      int x1 = x;
      int x2 = x;
      int y1 = y;
      int y2 = y;

      if(grid[x][y] == 1) {
         x1 = x;
         y1 = y-1;
         x2 = x;
         y2 = y+1;
      }
      else if(grid[x][y] == 2) {
         x1 = x-1;
         y1 = y;
         x2 = x+1;
         y2 = y;
      }
      else if(grid[x][y] == 3) {
         x1 = x+1;
         y1 = y;
         x2 = x;
         y2 = y-1;
      }
      else if(grid[x][y] == 4) {
         x1 = x+1;
         y1 = y;
         x2 = x;
         y2 = y+1;
      }
      else if(grid[x][y] == 5) {
         x1 = x;
         y1 = y-1;
         x2 = x-1;
         y2 = y;
      }
      else if(grid[x][y] == 6) {
         x1 = x-1;
         y1 = y;
         x2 = x;
         y2 = y+1;
      }

      if(isSafe(x1, y1, m, n , visited)) {
         if(hasValidPathUtil(grid, x1, y1, visited, m, n)) {
            return true;
         } else {
            visited[x1][y1] = false;
         }
      }
      if(isSafe(x2, y2, m, n , visited)) {
         if(hasValidPathUtil(grid, x2, y2, visited, m, n)) {
            return true;
         }
         else {
            visited[x2][y2] = false;
         }
      }

      return false;
   }

   public boolean hasValidPath(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      boolean visited[][] = new boolean[m][n];
      return hasValidPathUtil(grid, 0 , 0, visited, m, n);
   }

   public static void main(String args[]) {
      int[][] grid = {{2,4,3}, {6,5,2}};
      System.out.println(new ValidPathGrid().hasValidPath(grid));
   }

}
