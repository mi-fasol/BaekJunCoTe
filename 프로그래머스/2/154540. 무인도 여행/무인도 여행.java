import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] visited;
    static int N, M, sum;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if(visited[i][j] || maps[i].charAt(j) == 'X') continue;
                dfs(i,j,maps);
                list.add(sum);
                sum = 0;
            }
        }
        
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    public static void dfs(int x, int y, String[] maps) {
        visited[x][y] = true;
        sum += maps[x].charAt(y) - '0';
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(maps[nx].charAt(ny) == 'X' || visited[nx][ny]) continue;
            
            dfs(nx, ny, maps);
        }
    }
}