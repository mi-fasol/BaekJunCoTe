import java.io.*;
import java.util.*;

public class Main {
    public static int[] dp;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[k + 1];

        dp[0] = 1;

        // 동전 개수만큼
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            // 동전의 가치만큼
            for (int j = arr[i]; j <= k; j++)
                dp[j] += dp[j - arr[i]];
        }

        bw.write(dp[k] + "\n");

        br.close();
        bw.close();
    }
}