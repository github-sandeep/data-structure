package com.sandeep.graph.sandep.graph.misc;

public class EscapeMaze {
   static int count =0;
   public boolean isSafe(int blocked[][], int newX, int newY) {
      int row = blocked.length;
      for(int i = 0; i < row ; i++) {
         if(newX == blocked[i][0] && newY == blocked[i][1]) {
            return false;
         }
      }
      return newX >= 0 && newX < 1000000 && newY >= 0 && newY < 1000000;
   }

   public boolean isEscapePossibleUtil(int[][] blocked, int[] source, int[] target) {
      count++;
      System.out.println(count);
      if((source[0] == target[0]) && (source[1] == target[1]))
         return true;

      int x[] = {0, 0, 1, -1};
      int y[] = {1, -1, 0, 0};

      for(int i = 0; i < 4 ; i++) {
         int newX = source[0] + x[i];
         int newY = source[1] + y[i];
         if(isSafe(blocked, newX, newY)) {
            int newSource[] = new int[2];
            newSource[0] = newX;
            newSource[1] = newY;
            if(isEscapePossibleUtil(blocked, newSource, target))
               return true;
         }
      }
      return false;
   }

   public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
      if(blocked.length == 0)
         return true;

      return isEscapePossibleUtil(blocked, source, target);
   }

   public static void main(String args[]) {
      /*int blocked[][] = {{0,1},{1,0}};
      int source[] = {0,0};
      int target[] = {0,2};*/
      int blocked[][] = {{691938,300406},{710196,624190},{858790,609485},{268029,225806},{200010,188664},{132599,
                                                                                                          612099},{329444,633495},{196657,757958},{628509,883388}};
      int source[] = {655988,180910};
      int target[] = {267728,840949};
      EscapeMaze obj = new EscapeMaze();
      System.out.println(obj.isEscapePossible(blocked, source , target));
   }
}
