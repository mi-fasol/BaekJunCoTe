import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] item, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        item = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            item[i][0] = w;
            item[i][1] = v;
        }

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            // 무게
            for (int j = 1; j <= K; j++) {
                // 만약 담을 수 있으면
                if (j >= item[i][0]) {
                    // 가치 중 최댓값을 찾기
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item[i][0]] + item[i][1]);
                } else {
                    // 담을 수 없으면 이전 값을 가져옴
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}