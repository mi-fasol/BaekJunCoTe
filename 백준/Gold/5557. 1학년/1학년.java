import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        // dp에는 이전 값에서 더한 값, 뺀 값을 각각 저장
        dp = new long[N + 1][21];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[N];

        dp[0][arr[0]] = dp[1][arr[1]] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 21; j++) {
                if(dp[i-1][j] != 0){
                    if(j + arr[i] <= 20 && j + arr[i] >= 0){
                        dp[i][j + arr[i]] += dp[i-1][j];
                    }
                    if(j - arr[i] <= 20 && j - arr[i] >= 0){
                        dp[i][j - arr[i]] += dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[N-1][sum]);
    }
}