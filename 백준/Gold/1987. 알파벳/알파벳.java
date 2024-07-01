import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max = Integer.MIN_VALUE;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        char start = map[0][0];
        visited[start - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                char next = map[nx][ny];

                if(!visited[next - 'A']) {
                    visited[next - 'A'] = true;
                    dfs(nx, ny, count + 1);
                    visited[next - 'A'] = false;
                }
            }
        }
    }
}