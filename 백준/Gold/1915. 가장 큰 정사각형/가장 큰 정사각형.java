import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[][] dp;
    static long area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[N][M];

        if (N == 1 && M == 1) {
            String str = br.readLine();
            if (str.contains("1")) System.out.println(1);
            else System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = str.charAt(j) - '0';
                dp[i][j] = num;

                if (i > 0 && j > 0 && num == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                area = Math.max(area, dp[i][j]);
            }
        }

        System.out.println((int) Math.pow(area, 2));
    }
}