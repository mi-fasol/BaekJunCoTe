import java.io.*;
import java.util.*;

public class Main {
    static int N, M, CNT, BEFORE;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        while (true) {
            CNT++;
            dfs(0, 0);
            BEFORE = findLastCheese(arr);
            removeCheese();
            if (haveOne()) {
                visited = new boolean[N][M];
            } else {
                break;
            }
        }

        System.out.println(CNT);
        System.out.println(BEFORE);
    }

    public static int findLastCheese(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                } else if (arr[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static boolean haveOne() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void removeCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                }
            }
        }
    }
}