import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int T, N, K, W, start;
    static int[] D;
    static int[] dp;
    static HashMap<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            map = new HashMap<>();
            for (int j = 1; j <= N; j++) {
                D[j] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N + 1];
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (!map.containsKey(y)) {
                    map.put(y, new ArrayList<>());
                }
                map.get(y).add(x);
            }

            W = Integer.parseInt(br.readLine());

            Arrays.fill(dp, -1);

            start = findStart();

            dp[start] = D[start];
            System.out.println(recur(W));
        }
    }

    public static int recur(int idx) {
        if(dp[idx] != -1) {
            return dp[idx];
        }

        int max = 0;
        if(!map.containsKey(idx)) {
            return dp[idx] = D[idx];
        }

        for(int prev: map.get(idx)) {
            max = Math.max(max, recur(prev));
        }

        return dp[idx] = max + D[idx];
    }

    public static int findStart() {
        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }
}