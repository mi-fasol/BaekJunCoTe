import java.io.*;
import java.util.*;

public class Main {
    static int N, max, idx;
    static int[] arr;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1){
            System.out.println(1);
            System.out.println(arr[0]);
            return;
        }

        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
            if(max == dp[i]) idx = i;
        }

        for(int i = idx; i >= 0; i--) {
            if(dp[i] == max) {
                sb.insert(0, arr[i] + " ");
                max--;
            }
        }

        System.out.println(dp[idx]);
        System.out.println(sb);
    }
}