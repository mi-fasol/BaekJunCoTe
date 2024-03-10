import java.io.*;
import java.util.*;

public class Main {
    static Integer[] dp;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        dp = new Integer[44650007];


        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n > 3){
                for(int j = 4; j <= n; j++){
                    recur(3, n);
                }
            }
            System.out.println(dp[n]);
        }
    }

    public static void recur(int now, int want) {
        if (now == want) {
            return;
        }
        dp[now+1] = dp[now - 1] + dp[now - 2] + dp[now];
        recur(now + 1, want);
    }
}