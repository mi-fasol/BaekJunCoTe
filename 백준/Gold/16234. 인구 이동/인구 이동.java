import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, day, sum, cnt;
    static int[][] map;
    static boolean[][] isOpened;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            isOpened = new boolean[N][N];
            boolean isDone = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isOpened[i][j]) {
                        bfs(i, j);

                        if (cnt > 1) {
                            isDone = false;
                            int avg = sum / cnt;
                            for (int[] pos : list) {
                                map[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }

            if (isDone) {
                break;
            }

            day++;
        }

        System.out.println(day);
    }

    public static void bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.offer(new int[]{sx, sy});
        list.add(new int[]{sx, sy});
        isOpened[sx][sy] = true;
        sum = map[sx][sy];
        cnt = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || isOpened[nx][ny]) {
                    continue;
                }

                int diff = Math.abs(map[x][y] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    queue.offer(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                    sum += map[nx][ny];
                    cnt++;
                    isOpened[nx][ny] = true;
                }
            }
        }
    }
}