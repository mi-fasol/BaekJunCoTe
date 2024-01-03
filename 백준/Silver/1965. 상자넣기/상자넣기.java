import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        // 상자를 입력받는 배열
        int[] arr = new int[num];

        // 넣은 상자의 개수를 저장하는 배열
        int[] dp = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < num; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max)
                max = dp[i];

        }

        System.out.println(max);
        bw.close();
        br.close();
    }
}