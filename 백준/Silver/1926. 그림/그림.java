import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int max, sum, cnt = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    dfs(i, j);

                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);

        bw.close();
        br.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        sum += 1;

        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fx >= 0 && fy >= 0 && fx < map.length && fy < map[0].length && !visited[fx][fy] && map[fx][fy] == 1) {
                dfs(fx, fy);
            }
        }
    }
}