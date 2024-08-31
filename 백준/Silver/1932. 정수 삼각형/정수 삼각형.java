import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[][] arr, dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = arr[i][j];
                if(i > 0) {
                    if(j == 0) dp[i][j] += dp[i - 1][j];
                    else if(j == i) dp[i][j] += dp[i - 1][j - 1];
                    else dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}