import java.io.*;
import java.util.*;

public class Main {
    public static Integer[][] dp;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1][3];
        arr = new int[n+1][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int red = recur(n-1, 0);
        int green = recur(n-1, 1);
        int blue = recur(n-1, 2);

        bw.write(Math.min(red, Math.min(green, blue)) + "\n");
        br.close();
        bw.close();
    }

    public static int recur(int x, int y) {
        if (dp[x][y] == null) {
            if (x == 0) {
                dp[x][y] = arr[x][y];
            } else {
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