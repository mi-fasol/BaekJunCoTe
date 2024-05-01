import java.io.*;
import java.util.*;

public class Main {
    static int N, SUM, LEN = Integer.MAX_VALUE;
    static int[] arr, prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        SUM = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= SUM) {
                System.out.println(1);
                return;
            }
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int start = 0;
        int end = 0;

        while (start <= end && end <= N) {
            int sum = prefixSum[end] - prefixSum[start];
            if (sum >= SUM) {
                LEN = Math.min(LEN, end - start);
                if(sum > SUM) start++;
                else end++;
            } else {
                end++;
            }
        }
        System.out.println(LEN == Integer.MAX_VALUE ? 0 : LEN);
    }
}