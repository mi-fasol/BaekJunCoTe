import java.io.*;
import java.util.*;

public class Main {
    static Integer[] dp;
    static int[] arr;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        dp = new Integer[num + 1];
        arr = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (num >= 2) dp[2] = arr[1] + arr[2];

        System.out.println(recur(num));
    }

    public static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(recur(n - 1), Math.max(recur(n - 2), recur(n - 3) + arr[n - 1]) + arr[n]);
        }
        return dp[n];
    }
}