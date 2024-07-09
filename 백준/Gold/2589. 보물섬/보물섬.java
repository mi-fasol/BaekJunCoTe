import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res;
    static char[][] map;
    static List<int[]> land = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if(c == 'L') {
                    land.add(new int[]{i, j});
                }
                map[i][j] = c;
            }
        }

        for (int[] cur : land) {
            bfs(cur[0], cur[1]);
        }

        System.out.println(res);
    }

    public static void bfs(int x, int y) {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 'W') continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt + 1});
                res = Math.max(res, cnt + 1);
            }
        }
    }
}