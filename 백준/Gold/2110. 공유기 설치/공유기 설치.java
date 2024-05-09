import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N - 1] - arr[0] + 1;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            int idx = 0;
            int cnt = 1;

            for (int i = 0; i < N; i++) {
                if (arr[i] - arr[idx] >= mid) {
                    idx = i;
                    cnt++;
                }
            }

            if (cnt < C) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        System.out.println(end-1);
    }
}