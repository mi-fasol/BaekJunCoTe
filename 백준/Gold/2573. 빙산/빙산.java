import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, CNT;
    public static int[][] map;
    public static boolean[][] bfsVisited, visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        CNT = 0;
        map = new int[N][M];
        bfsVisited = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        while (true) {
            int cnt = countSection();
            if (cnt >= 2) {
                System.out.println(CNT);
                return;
            } else {
                if (isAllZero()) {
                    System.out.println(0);
                    return;
                }
                bfsVisited = new boolean[N][M];
                bfs();
                CNT++;
            }
        }
    }

    public static void bfs() {
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new int[]{i, j});
                    bfsVisited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !bfsVisited[nx][ny] && map[nx][ny] == 0) {
                    cnt++;
                }
            }
            map[x][y] = Math.max((map[x][y] - cnt), 0);
        }
    }

    public static boolean isAllZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int countSection() {
        visited = new boolean[N][M];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }
    }
}