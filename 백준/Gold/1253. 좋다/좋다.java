import java.io.*;
import java.util.*;

public class Main {
    static int N, start, end, sum, cnt;
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

        for (int i = 0; i < N; i++) {
            start = 0;
            end = N - 1;
            int now = arr[i];

            while (start < end) {
                sum = arr[start] + arr[end];

                if (sum > now) end--;
                else if (sum < now) start++;
                else {
                    if (start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) start++;
                    else end--;
                }
            }
        }
        System.out.println(cnt);
    }
}