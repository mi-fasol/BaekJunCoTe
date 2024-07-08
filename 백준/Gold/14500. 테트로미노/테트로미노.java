import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result = Integer.MIN_VALUE;
    static StringTokenizer st;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                tetromino(i, j, map[i][j], 1);
                visited[i][j] = false;
                anotherTetromino(i, j);
            }
        }

        System.out.println(result);
    }

    public static void tetromino(int x, int y, int sum, int cnt) {
        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            tetromino(nx, ny, sum + map[nx][ny], cnt + 1);
            visited[nx][ny] = false;
        }
    }

    public static void anotherTetromino(int x, int y) {
        if(visited[x][y]) return;

        if(x > 0 && y > 0 && y < M - 1) {
            result = Math.max(result, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1]);
        }
        if(x < N - 1 && y > 0 && y < M - 1) {
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1]);
        }
        if(x > 0 && x < N - 1 && y < M - 1) {
            result = Math.max(result, map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y + 1]);
        }
        if(x > 0 && x < N - 1 && y > 0) {
            result = Math.max(result, map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1]);
        }
    }
}