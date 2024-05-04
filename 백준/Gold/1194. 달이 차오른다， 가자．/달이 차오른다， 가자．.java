import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][64];

        int sx = 0, sy = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }
        System.out.println(bfs(sx, sy));
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0, 0});
        visited[x][y][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];
            int key = cur[3];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny][key] || map[nx][ny] == '#') continue;

                if (map[nx][ny] == '1') {
                    return cnt + 1;
                }

                if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
                    int newKey = key | (1 << (map[nx][ny] - 'a'));
                    visited[nx][ny][newKey] = true;
                    q.offer(new int[]{nx, ny, cnt + 1, newKey});
                } else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
                    if ((key & (1 << (map[nx][ny] - 'A'))) != 0) {
                        visited[nx][ny][key] = true;
                        q.offer(new int[]{nx, ny, cnt + 1, key});
                    }
                } else {
                    visited[nx][ny][key] = true;
                    q.offer(new int[]{nx, ny, cnt + 1, key});
                }
            }
        }
        return -1;
    }
}