import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static HashMap<Integer, ArrayList<Integer>> light = new HashMap<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;

            int key = x * N + y;
            int value = a * N + b;

            if (!light.containsKey(key)) {
                light.put(key, new ArrayList<>());
            }
            light.get(key).add(value);
        }

        map[0][0] = 2;

        bfs(0, 0);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int idx = cx * N + cy;

            if (light.containsKey(idx))
                for (int value : light.get(idx)) {
                    int nx = value / N;
                    int ny = value % N;
                    map[nx][ny] = 2;
                }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                if (map[nx][ny] == 2) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});

                    if (light.containsKey(nx * N + ny))
                        for (int value : light.get(nx * N + ny)) {
                            int vx = value / N;
                            int vy = value % N;
                            for (int j = 0; j < 4; j++) {
                                int nvx = vx + dx[j];
                                int nvy = vy + dy[j];
                                if (nvx < 0 || nvy < 0 || nvx >= N || nvy >= N) continue;
                                if (visited[nvx][nvy] && map[nvx][nvy] == 2) {
                                    q.offer(new int[]{nvx, nvy});
                                }
                            }
                        }
                }
            }
        }
    }
}