import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static char[][] map;
    static int N, M, JX, JY;
    static Queue<int[]> fireQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'J') {
                    JX = i;
                    JY = j;
                } else if (c == 'F') {
                    fireQueue.offer(new int[]{i, j});
                }
                map[i][j] = str.charAt(j);
            }
        }

        int result = bfs();

        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{JX, JY, 0});

        while (!q.isEmpty()) {
            int size = fireQueue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = fireQueue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
                        map[nx][ny] = 'F';
                        fireQueue.offer(new int[]{nx, ny});
                    }
                }
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int cnt = cur[2];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        return cnt + 1;
                    }

                    if (map[nx][ny] == '.') {
                        q.offer(new int[]{nx, ny, cnt + 1});
                        map[nx][ny] = 'J';
                    }
                }
            }
        }
        return -1;
    }
}