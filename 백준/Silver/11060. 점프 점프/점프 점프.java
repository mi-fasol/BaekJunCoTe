import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num + 1];
        long[] dp = new long[1101];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;

        for (int i = 1; i <= num; i++) {
            if (dp[i] >= Integer.MAX_VALUE) continue;
            for (int j = 1; j <= arr[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if (dp[num] >= Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(dp[num]);
        }
    }
}