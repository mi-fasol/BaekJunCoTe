import java.io.*;
import java.util.*;

public class Main {
    public static Integer[][] dp;
    public static int[][] arr;
    public static int SELECTED, N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1][3];
        arr = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        SELECTED = 0;

        int red = recur(N - 1, 0);
        dp = new Integer[N + 1][3];
        int green = recur(N - 1, 1);
        dp = new Integer[N + 1][3];
        int blue = recur(N - 1, 2);
        int minColor = Math.min(red, Math.min(green, blue));

        bw.write(minColor + "\n");

        br.close();
        bw.close();
    }

    public static int recur(int x, int y) {
        if (dp[x][y] == null) {
            if (x == 0) {
                if (y != SELECTED) dp[x][y] = arr[x][y];
                else
                    dp[x][y] = 1001;
            } else {
                if (x == N - 1) {
                    SELECTED = y;
                }
                if (y == 0) {
                    dp[x][y] = Math.min(recur(x - 1, 1), recur(x - 1, 2)) + arr[x][y];
                } else if (y == 1) {
                    dp[x][y] = Math.min(recur(x - 1, 0), recur(x - 1, 2)) + arr[x][y];
                } else {
                    dp[x][y] = Math.min(recur(x - 1, 0), recur(x - 1, 1)) + arr[x][y];
                }
            }
        }
        return dp[x][y];
    }
}