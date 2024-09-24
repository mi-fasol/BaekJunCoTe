import java.util.*;
import java.io.*;

class Solution {
    static int N, M, min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        bfs(maps);
        
        return min == Integer.MAX_VALUE ? -1 : min +1;
    }
    
    public static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x == N-1 && y == M-1) {
                min = Math.min(min, cnt);
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt+1});
            }
        }
        return;
    }
}