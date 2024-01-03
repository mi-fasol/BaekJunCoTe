import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int[][] arr;
    static int row, col;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());

        row = Integer.parseInt(s.nextToken());
        col = Integer.parseInt(s.nextToken());

        arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < col; i++) {
            dfs(0, i, arr[0][i], -1); // 시작 시 이전 방향은 없으므로 -1로 설정
        }

        System.out.println(result);
        br.close();
    }

    public static void dfs(int y, int x, int res, int prevDir) {
        if (y == row - 1) {
            result = Math.min(result, res);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i != prevDir) {
                int fx = x + dx[i];
                int fy = y + dy[i];

                if (fx >= 0 && fx < col) {
                    dfs(fy, fx, res + arr[fy][fx], i);
                }
            }
        }
    }
}
