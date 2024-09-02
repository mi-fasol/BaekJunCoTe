import java.io.*;
import java.util.*;

public class Main {
    static int N, DIV = 1000000000;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new long[101][10];
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][1];
                else if (j == 9) dp[i][j] = dp[i - 1][8];
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= DIV;
            }
        }

        System.out.println(Arrays.stream(dp[N]).sum() % DIV);
    }
}