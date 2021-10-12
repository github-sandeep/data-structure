package com.sandeep.graph.sandep.graph.misc;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitMaze {
   public int nearestExit(char[][] maze, int[] entrance) {
      int row = maze.length;
      int col = maze[0].length;
      boolean[][] visited = new boolean[row][col];
      int[] rows = {0, 0, 1, -1};
      int[] cols = {1, -1, 0, 0};
      int count = 0;
      Queue<int[]> queue = new LinkedList<>();
      queue.add(entrance);
      visited[entrance[0]][entrance[1]] = true;

      while(!queue.isEmpty()) {
         int size = queue.size();
         count++;
         for(int s =0; s < size ;s++) {
            int[] curr = queue.poll();
            for(int k = 0; k < 4 ; k++) {
               int x = curr[0]+rows[k];
               int y = curr[1]+cols[k];
               if( x<0 || x>=row || y<0 || y>=col || visited[x][y] == true || maze[x][y]=='+') {
                  continue;
               }
               if(x==0 || x ==row-1 || y==0 || y==col-1)
                  return count;
               queue.add(new int[]{x,y});
               visited[x][y] = true;
            }
         }
      }
      return -1;
   }

   public static void main(String args[]) {
      NearestExitMaze obj = new NearestExitMaze();
      /*char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
      int[] entrance = {1,0};*/

      char[][] maze = {{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+',
            '.','.','.','.','.','+'},{'+','+','+','+','.','+','.'}};
      int[] entrance = {0,1};
      System.out.println(obj.nearestExit(maze, entrance));
   }
}
