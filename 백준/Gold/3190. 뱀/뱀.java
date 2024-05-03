import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L, D, sx, sy, TIME;
    static int[][] map, snake;
    static Queue<Integer> q = new LinkedList<>();
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static HashMap<Integer, Character> dir = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        snake = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x - 1][y - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        q.offer(0);

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            dir.put(X, C);
        }

        moveUntilDie();
        System.out.println(TIME);
    }

    public static void moveUntilDie() {
        while (true) {
            sx = sx + dx[D];
            sy = sy + dy[D];
            TIME++;

            if (sx < 0 || sy < 0 || sx >= N || sy >= N || snake[sx][sy] == 1) {
                return;
            }

            q.offer(sx * N + sy);

            if (map[sx][sy] == 1) {
                map[sx][sy] = 0;
                snake[sx][sy] = 1;
            } else {
                snake[sx][sy] = 1;
                int tail = q.poll();
                snake[tail / N][tail % N] = 0;
            }

            if(dir.containsKey(TIME)) {
                D = dir.get(TIME) == 'D' ? (D + 1) % 4 : (D + 3) % 4;
            }
        }
    }
}