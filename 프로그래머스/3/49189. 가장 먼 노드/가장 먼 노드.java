import java.io.*;
import java.util.*;

class Solution {
    static int[] visited;
    static int cnt, maxDis, N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        N = n;
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        visited = new int[N+1];
        
        for(int[] v : edge) {
            int a = v[0];
            int b = v[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        bfs();
        
        for(int i = 2; i <= N; i++) {
            if(visited[i] == maxDis) cnt++;
        }
        
        return cnt;
    }
    
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i : graph.get(now)) {
                if(visited[i] == 0) {
                    visited[i] = visited[now] + 1;
                    maxDis = Math.max(maxDis, visited[i]);
                    q.offer(i);
                }
            }
        }
    }
}