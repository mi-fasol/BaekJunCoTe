import java.io.*;
import java.util.*;

public class Main {
    static int T, K;
    static int[] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            cost = new int[K];
            dp = new int[K][K];
            for (int j = 0; j < K; j++) {
                Arrays.fill(dp[j], Integer.MAX_VALUE);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(getCost(0, K - 1));
        }
    }

    public static int getCost(int start, int end) {
        if (start == end) return 0;

        if (dp[start][end] == Integer.MAX_VALUE) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += cost[i];
            }

            for (int i = start; i < end; i++) {
                dp[start][end] = Math.min(dp[start][end], getCost(start, i) + getCost(i + 1, end) + sum);
            }
        }
        return dp[start][end];
    }
}