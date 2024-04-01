import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T = 0;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int CNT = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (CNT > T) {
            System.out.println("Fail");
            return;
        }

        System.out.println(CNT);

        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(0, 0));
        visited[0][0] = true;
        int count = -1;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int step = 0; step < size; step++) {
                Loc temp = queue.poll();

                int a = temp.r;
                int b = temp.c;

                if (map[a][b] == 2) {
                    CNT = count + N - 1 - a + M - 1 - b;
                    continue;
                } else if (a == N - 1 && b == M - 1) {
                    CNT = Math.min(CNT, count);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = a + dx[i];
                    int nc = b + dy[i];

                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 1) {
                        queue.offer(new Loc(nr, nc));
                        visited[nr][nc] = true;

                    }
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}

class Loc {
    int r, c;

    public Loc(int r, int c) {
        this.r = r;
        this.c = c;
    }
}