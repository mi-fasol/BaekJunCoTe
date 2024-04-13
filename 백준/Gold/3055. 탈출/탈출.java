import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, CNT, HX, HY;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'S') {
                    HX = i;
                    HY = j;
                }
                map[i][j] = str.charAt(j);
            }
        }

        bfs(HX, HY);

        System.out.println(CNT == Integer.MAX_VALUE ? "KAKTUS" : CNT);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        CNT = Integer.MAX_VALUE;

        int cnt = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            makeWater();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int a = cur[0];
                int b = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = a + dx[i];
                    int ny = b + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] & map[nx][ny] != 'X') {
                        if (map[nx][ny] == '.') {
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        } else if (map[nx][ny] == 'D') {
                            CNT = Math.min(CNT, cnt + 1);
                        }
                    }
                }
            }
        }
    }

    public static Queue<int[]> findWater() {
        Queue<int[]> waterQ = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*') {
                    waterQ.offer(new int[]{i, j});
                }
            }
        }
        return waterQ;
    }

    public static void makeWater() {
        Queue<int[]> waterQ = findWater();
        while (!waterQ.isEmpty()) {
            int[] cur = waterQ.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                    }
                }
            }
        }
    }
}