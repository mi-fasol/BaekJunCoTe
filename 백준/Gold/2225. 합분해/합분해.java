import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][K + 1];

        if(K == 1) {
            System.out.println(1);
            return;
        }

        for(int i = 0; i <= N; i++) {
            dp[i][1] = 1;
            dp[i][2] = i + 1;
        }

        if(K == 2) {
            System.out.println(dp[N][K]);
            return;
        }

        for(int i = 0; i <= N; i++) {
            for (int j = 3; j <= K; j++) {
                long sum = 0;
                for (int k = 0; k <= i; k++) {
                    sum += dp[k][j - 1];
                }
                dp[i][j] = sum % 1000000000;
            }
        }
        
        System.out.println(dp[N][K]);
    }
}