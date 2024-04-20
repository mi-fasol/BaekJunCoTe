import java.io.*;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[2001];

        for (int i = 0; i <= 2000; i++)
            dp[i] = i;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 2; true; j++) {
                if (i * j > 1000) break;
                dp[i * j] = Math.min(dp[i] + j, dp[i * j]);
            }
            for (int j = 1000; j >= 2; j--)
                dp[j] = Math.min(dp[j + 1] + 1, dp[j]);
        }
        System.out.println(dp[N]);
    }
}