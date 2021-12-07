package com.sandeep.graph.sandep.graph.misc;

import java.util.Arrays;
import java.util.List;

public class PathCoverFromSource {

    public boolean allRoomsVisited(boolean visited[]) {
        for(int  i=0; i < visited.length; i++) {
            if(visited[i] == false)
                return false;
        }
        return true;
    }

    public boolean isDFS(List<List<Integer>> rooms, boolean visited[], int source) {
        visited[source] = true;
        if(allRoomsVisited(visited))
            return true;
        List<Integer> neighbours = rooms.get(source);
        for(int neighbour: neighbours) {
            if(!visited[neighbour]) {
                if(isDFS(rooms, visited, neighbour))
                    return true;
            }
        }
        return false;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int source =0;
        int n = rooms.size();
        boolean visited[] = new boolean[n];
        for(int i =0; i < n ; i++) {
            visited[i] = false;
        }
        if(isDFS(rooms, visited, source)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) {
        PathCoverFromSource obj = new PathCoverFromSource();

        List<List<Integer>> rooms1 = Arrays.asList(Arrays.asList(1,3), Arrays.asList(3,0,1), Arrays.asList(2), Arrays.asList(0));
        System.out.println(obj.canVisitAllRooms(rooms1));

        List<List<Integer>> rooms2 = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList());
        System.out.println(obj.canVisitAllRooms(rooms2));
    }
}
