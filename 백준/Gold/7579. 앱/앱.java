import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result = Integer.MAX_VALUE;
    static int[] memory;
    static int[] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N];
        cost = new int[N];
        dp = new int[N][100001];

        st = new StringTokenizer(br.readLine());
        StringTokenizer costSt = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(costSt.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cos = cost[i];
            int mem = memory[i];
            for (int j = 0; j <= 100000; j++) {
                if (i == 0) {
                    if (cos <= j) {
                        dp[i][j] = mem;
                    }
                } else {
                    if (cos <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cos] + mem);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= M) {
                    result = Math.min(result, j);
                }
            }
        }
        System.out.println(result);
    }
}