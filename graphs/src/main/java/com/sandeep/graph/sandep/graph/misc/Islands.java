package com.sandeep.graph.sandep.graph.misc;

public class Islands {
   static int ROW =0;
   static int COL =0;

   private static boolean isSafe(int M[][], boolean visited[][], int i, int j) {
      if(i >=0 && i < ROW && j >=0 && j < COL && M[i][j] ==1 && visited[i][j] == false) {
         return true;
      }
      return false;
   }

   private static void dfs(int M[][], boolean visited[][], int i, int j) {
      visited[i][j] = true;
      int row[] = {0, 1, -1, 1, -1, 0, 1, -1};
      int col[] = {-1, -1, -1, 0, 0, 1, 1, 1};
      for(int k =0; k < 8 ; k++) {
         if(isSafe(M, visited, i+ row[k], j + col[k])) {
            dfs(M, visited, i+ row[k], j + col[k]);
         }
      }
   }

   private static int countIslands(int M[][]) {
      ROW = M.length;
      COL = M[0].length;
      int count = 0;
      boolean visited[][] = new boolean[ROW][COL];
      for(int i =0; i < ROW; i++) {
         for(int j =0; j < COL; j++) {
            if(M[i][j] == 1 && !visited[i][j]) {
               dfs(M, visited, i, j);
               count++;
            }
         }
      }
      return count;
   }

   public static void main(String[] args)
   {
      int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                { 0, 1, 0, 0, 1 },
                                { 1, 0, 0, 1, 1 },
                                { 0, 0, 0, 0, 0 },
                                { 1, 0, 1, 0, 1 } };
      System.out.println("Number of islands is: " + countIslands(M));
   }
}
