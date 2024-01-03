import java.io.*;
import java.util.*;

public class Main {
    static int num;
    static long MOD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        num = Integer.parseInt(br.readLine());
        
        MOD = 1000000007L;

        if (num == 1) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        long[][] dp = new long[3][num + 1];
        dp[0][2] = dp[1][2] = 1;

        for (int i = 3; i <= num; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % MOD;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
        }

        bw.write(dp[0][num] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
