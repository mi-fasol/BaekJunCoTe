import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] coin;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N];
        dp = new long[K + 1];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        coin = Arrays.stream(coin).sorted().toArray();
        dp[0] = 0;

        for (int i = 1; i <= K; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (i >= coin[j])
                    if (i % coin[j] == 0) {
                        dp[i] = Math.min(i / coin[j], dp[i]);
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                    }
            }
        }

        System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
    }
}