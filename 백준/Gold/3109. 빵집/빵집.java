import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i= 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++){
            if(map[i][1] == 'x') continue;
            max += dfs(i, 1);
        }

        System.out.println(max);
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;

        if(y == C - 1) return 1;

        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] == 'x') continue;

            if(dfs(nx, ny) == 1) return 1;
        }

        return 0;
    }
}