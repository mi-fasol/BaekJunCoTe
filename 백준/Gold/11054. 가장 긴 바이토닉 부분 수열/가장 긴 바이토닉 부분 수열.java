import java.io.*;
import java.util.*;

public class Main {
    static int N, MAX;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            for (int k = i; k < N; k++) {
                for (int j = i; j < k; j++) {
                    if (arr[k] < arr[j] && dp[k] < dp[j] + 1) {
                        dp[k] = dp[j] + 1;
                    }
                }
                MAX = Math.max(MAX, dp[k]);
            }
        }

        System.out.println(MAX);
    }
}