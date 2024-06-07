import java.io.*;
import java.util.*;

public class Main {
    static int N, start, end, max;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            if (dp[max] < arr[i]) {
                dp[++max] = arr[i];
            } else if (dp[max] > arr[i]) {
                start = 0;
                end = max;

                while (start < end) {
                    int mid = (start + end) / 2;
                    if (dp[mid] < arr[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                dp[end] = arr[i];
            }
        }

        System.out.println(max + 1);
    }
}