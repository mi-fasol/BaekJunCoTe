import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, T;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            dp = new int[m + 1];
            dp[0] = 1;
            for (int k = 0; k < N; k++) {
                for (int j = arr[k]; j <= m; j++) {
                    dp[j] += dp[j - arr[k]];
                }
            }
            System.out.println(dp[m]);
        }
    }
}