import java.io.*;
import java.util.*;

class Solution {
    static boolean[] isChecked;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, network;
    public int solution(int n, int[][] computers) {
        N = n;
        isChecked = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            for(int j = 0; j < N; j++) {
                if(computers[i][j] == 1 && i != j) graph.get(i).add(j);
            }
        }
        
        for(int i = 0; i < N; i++){
            if(!isChecked[i]){
                isChecked[i] = true;
                bfs(i);
//                 if(graph.get(i).size() == 0) {
//                     network++;
//                     break;
//                 }
                
                // for(int next : graph.get(i)) {
                //     dfs(next);
                // }
            }
        }
        
        return network;
    }
    
    public static void dfs(int computer) {
        if(isChecked[computer]) {
            return;
        }
        
        for(int next : graph.get(computer)) {
            if(isChecked[next]) continue;
            isChecked[next] = true;
            dfs(next);
        }
        
        network++;
        return;
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next: graph.get(now)) {
                if(isChecked[next]) continue;
                isChecked[next] = true;
                q.offer(next);
            }
        }
        
        network++;
        return;
    }
}