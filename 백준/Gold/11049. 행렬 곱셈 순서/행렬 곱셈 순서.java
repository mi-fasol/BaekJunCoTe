import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static ArrayList<int[]> sizeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sizeList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0, N - 1));
    }

    public static int solve(int start, int end) {
        if(start == end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        int result = Integer.MAX_VALUE;
        
        for(int i = start; i < end; i++) {
            result= Math.min(result, solve(start, i) + solve(i+1, end) + sizeList.get(start)[0] * sizeList.get(i)[1] * sizeList.get(end)[1]);
        }

        return dp[start][end] = result;
    }
}