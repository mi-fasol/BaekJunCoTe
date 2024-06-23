import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(res);
    }

    public static void bfs() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];

            if (x == N - 1 && y == M - 1) {
                res = Math.min(res, cnt);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[nx][ny] == 0) {
                    q.addFirst(new int[]{nx, ny, cnt});
                } else if(map[nx][ny] == 1){
                    q.offer(new int[]{nx, ny, cnt + 1});
                }

                map[nx][ny] = 2;
            }
        }
    }
}