import java.io.*;
import java.util.*;

public class Main {
    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        dp = new Integer[num + 1];

        dp[0] = dp[1] = 0;

        System.out.println(recur(num));
    }

    static int recur(int num) {
        if (dp[num] == null) {
            if (num % 6 == 0) {
                dp[num] = Math.min(recur(num - 1), Math.min(recur(num / 3), recur(num / 2))) + 1;
            } else if (num % 3 == 0) {
                dp[num] =Math.min(recur(num / 3), recur(num - 1)) + 1;
            } else if (num % 2 == 0) {
                dp[num] = Math.min(recur(num / 2), recur(num - 1)) + 1;
            } else {
                dp[num] = recur(num - 1) + 1;
            }
        }
        return dp[num];
    }
}