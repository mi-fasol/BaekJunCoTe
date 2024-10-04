import java.io.*;
import java.util.*;

class Solution {
    static boolean[][] isVisited = new boolean[102][102];
    static int res;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map = new int[102][102];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] r : rectangle) {
            for(int i = 0 ; i < r.length; i++) {
                r[i] *= 2;
            }
            for(int i=r[0]; i<=r[2]; i++){
                for(int j=r[1]; j<=r[3]; j++){
                    if((i==r[0] || i==r[2] || j==r[1] || j==r[3]) && (map[i][j]!=2)) map[i][j]=1;
                    else map[i][j]=2;
                }
            }
        }
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return res;
    }
    
    public static void bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        isVisited[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            
            if(x == ex && y == ey) {
                res = cnt/2;
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || ny<0 || nx >= 102 || ny >= 102 || isVisited[nx][ny] || map[nx][ny] != 1) continue;
                
                q.offer(new int[]{nx, ny, cnt+1});
                isVisited[nx][ny] = true;
            }
        }
    }
}