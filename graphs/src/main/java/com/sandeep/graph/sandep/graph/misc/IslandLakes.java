package com.sandeep.graph.sandep.graph.misc;

import java.util.*;

public class IslandLakes {
    static int[][] directions4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<int[]> getIslandCoordinates(int[][] grid, int startX, int startY) {
        List<int[]> islandCoordinates = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        Set<String> visited = new HashSet<>();
        visited.add(startX + "," + startY);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            islandCoordinates.add(cell);

            for (int[] dir : directions4) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length &&
                        grid[newX][newY] == 1 && !visited.contains(newX + "," + newY)) {
                    queue.add(new int[]{newX, newY});
                    visited.add(newX + "," + newY);
                }
            }
        }
        return islandCoordinates;
    }

    public static int[][] buildIslandMatrix(List<int[]> islandCoordinates) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (int[] coord : islandCoordinates) {
            minX = Math.min(minX, coord[0]);
            maxX = Math.max(maxX, coord[0]);
            minY = Math.min(minY, coord[1]);
            maxY = Math.max(maxY, coord[1]);
        }

        int[][] islandMatrix = new int[maxX - minX + 1][maxY - minY + 1];
        for (int[] coord : islandCoordinates) {
            islandMatrix[coord[0] - minX][coord[1] - minY] = 1;
        }
        return islandMatrix;
    }

    public static void exploreLake(int[][] islandMatrix, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= islandMatrix.length || j >= islandMatrix[0].length || islandMatrix[i][j] != 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] dir : directions4) {
            exploreLake(islandMatrix, i + dir[0], j + dir[1], visited);
        }
    }

    public static int countLakes(int[][] islandMatrix) {
        int lakes = 0;
        boolean[][] visited = new boolean[islandMatrix.length][islandMatrix[0].length];

        for (int i = 1; i < islandMatrix.length - 1; i++) {
            for (int j = 1; j < islandMatrix[0].length - 1; j++) {
                if (islandMatrix[i][j] == 0 && !visited[i][j]) {
                    exploreLake(islandMatrix, i, j, visited);
                    lakes++;
                }
            }
        }
        return lakes;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0}
        };

        int[][] testCoords = {{0, 7}, {0,10}, {2, 2}, {4, 8}};
        for (int[] coord : testCoords) {
            int x = coord[0], y = coord[1];
            if (grid[x][y] == 1) {
                List<int[]> islandCoordinates = getIslandCoordinates(grid, x, y);
                System.out.println("Island matrix at (" + x + ", " + y + "): " );
                int[][] islandMatrix = buildIslandMatrix(islandCoordinates);
                for(int i =0; i < islandMatrix.length ;i++) {
                    for(int j =0; j < islandMatrix[0].length; j++) {
                        System.out.print(islandMatrix[i][j] + ", ");
                    }
                    System.out.println();
                }
                int numLakes = countLakes(islandMatrix);
                System.out.println("Number of Lakes in this island is: " + numLakes);
            }
        }
    }
}

