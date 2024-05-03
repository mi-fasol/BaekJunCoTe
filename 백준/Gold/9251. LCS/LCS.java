import java.io.*;

public class Main {
    static char[] first, second;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 2; i++) {
            String str = br.readLine();
            if (i == 0) {
                first = str.toCharArray();
            } else {
                second = str.toCharArray();
            }
        }

        dp = new int[first.length + 1][second.length + 1];
        System.out.println(LCS());
    }

    public static int LCS() {
        int result = 0;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
                result = Math.max(result, dp[i + 1][j + 1]);
            }
        }
        return result;
    }
}