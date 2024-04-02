import java.io.*;
import java.util.*;

public class Main {
    static int N, M = 0;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int CNT = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

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

        dfs(0);

        System.out.println(CNT);

        bw.close();
        br.close();
    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            CNT = Math.max(CNT, bfs());
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            tmp[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int fx = x + dx[i];
                int fy = y + dy[i];

                if (fx >= 0 && fy >= 0 && fx < N && fy < M) {
                    if (tmp[fx][fy] == 0) {
                        tmp[fx][fy] = 2;
                        q.offer(new int[]{fx, fy});
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}