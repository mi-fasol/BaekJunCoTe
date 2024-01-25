import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MAX_VALUE >> 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j)
                    arr[i][j] = max;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            arr[a][b] = arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        
        int result = max;
        int[] score = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != max) {
                    cnt = Math.max(cnt, arr[i][j]);
                }
            }
            score[i] = cnt;
            result = Math.min(result, cnt);
        }

        int res = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (score[i] == result) {
                res++;
                sb.append(i + " ");
            }
        }

        System.out.println(result + " " + res);

        System.out.println(sb);
    }
}