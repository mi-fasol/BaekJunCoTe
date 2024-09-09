import java.io.*;
import java.util.*;

public class Main {
    static int N, INF = 16_000_000;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        dp = new int[N][1 << N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(TSP(0, 1));
    }

    public static int TSP(int cur, int visited) {
        if (visited == (1 << N) - 1) {
            if (cost[cur][0] == 0) return INF;
            return cost[cur][0];
        }

        if (dp[cur][visited] != -1) return dp[cur][visited];

        dp[cur][visited] = INF;
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0 && cost[cur][i] != 0) {
                dp[cur][visited] = Math.min(dp[cur][visited], TSP(i, visited | (1 << i)) + cost[cur][i]);
            }
        }

        return dp[cur][visited];
    }
}