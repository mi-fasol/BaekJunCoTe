import java.io.*;
import java.util.*;

public class Main {
    static int N, RESULT_START, RESULT_END;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;

        while (true) {
            if (start >= end) {
                break;
            }

            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                RESULT_START = start;
                RESULT_END = end;
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(arr[RESULT_START] + " " + arr[RESULT_END]);
    }
}