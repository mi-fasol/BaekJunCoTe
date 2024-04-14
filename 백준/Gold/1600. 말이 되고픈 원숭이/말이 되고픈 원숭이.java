import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, CNT, K;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static int[] horseX = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] horseY = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(CNT);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, K, 0});
        visited[0][0][K] = true;

        CNT = -1;

        while (!q.isEmpty()) {

            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int kCnt = now[2];
            int cnt = now[3];

            if (x == N - 1 && y == M - 1) {
                CNT = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny][kCnt] && map[nx][ny] != 1) {
                    visited[nx][ny][kCnt] = true;
                    q.offer(new int[]{nx, ny, kCnt, cnt+1});
                }
            }

            if (kCnt > 0) {
                for (int j = 0; j < 8; j++) {
                    int hx = x + horseX[j];
                    int hy = y + horseY[j];
                    
                    if (hx >= 0 && hy >= 0 && hx < N && hy < M && !visited[hx][hy][kCnt-1] && map[hx][hy] != 1) {
                        visited[hx][hy][kCnt-1] = true;
                        q.offer(new int[]{hx, hy, kCnt - 1, cnt+1});
                    }
                }
            }
        }
    }
}