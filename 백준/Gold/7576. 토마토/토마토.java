import java.io.*;
import java.util.*;

public class Main {
    static int N, M, zeroCnt, CNT;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<int[]> tomato = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 0) zeroCnt++;
                else if (num == 1) q.offer(new int[]{i, j, 0});
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(CNT);
    }

    public static void bfs() {
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            cnt = cur[2];

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        CNT = cnt;
    }
}