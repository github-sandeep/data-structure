package com.sandeep.graph.sandep.graph.misc;

public class MaxAreaIsland {
   public static boolean isSafe(int[][] grid, boolean[][]visited, int i, int j, int row, int col) {
      return i>=0 && i<row && j>=0 && j<col && grid[i][j] ==1 && !visited[i][j];
   }

   public static int dfs(int grid[][], boolean visited[][], int i, int j, int row, int col) {
      int rows[] = {0, 0, -1, 1};
      int cols[] = {-1, 1, 0, 0};
      int count = 0;
      if(isSafe(grid, visited, i , j , row, col)) {
         count++;
         visited[i][j] = true;
      }

      for(int k = 0; k < 4; k++) {
         if(isSafe(grid, visited, i + rows[k], j + cols[k], row, col)) {
            count = count + dfs(grid, visited, i+rows[k], j+cols[k], row, col);
         }
      }
      return count;
   }

   public static int maxAreaOfIslandUtil(int grid[][], boolean visited[][], int row, int col) {
      int max = 0;
      for(int i =0; i < row ; i++) {
         for(int j =0; j < col ; j++) {
            if(grid[i][j] == 1 && !visited[i][j]) {
               int count = dfs(grid, visited, i, j, row, col);
               if(count > max) {
                  max = count;
               }
            }
         }
      }
      return max;
   }

   public static int maxAreaOfIsland(int[][] grid) {
      int row = grid.length;
      int col = grid[0].length;
      boolean visited[][] = new boolean[row][col];
      for(int i =0; i < row ; i++) {
         for(int j =0; j < col ; j++) {
            visited[i][j] = false;
         }
      }
      return maxAreaOfIslandUtil(grid, visited, row, col);
   }

   public static void main(String args[]) {
      int grid[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0
            ,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,
            0,0,0,0,1,1,0,0,0,0}};
      //int grid[][] = {{1}};
      System.out.println(maxAreaOfIsland(grid));
   }
}
