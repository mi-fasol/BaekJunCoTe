import java.io.*;
import java.util.*;

public class Main {
    static int num;
    static int[][] arr, maxDp, minDp;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new int[num+1][3];
        maxDp = new int[num+1][3];
        minDp = new int[num+1][3];

        for (int i = 1; i <= num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 1) {
                    maxDp[i][j] = arr[i][j];
                    minDp[i][j] = arr[i][j];
                }
            }
        }

        for (int i = 2; i <= num; i++) {
            maxDp[i][0] = arr[i][0] + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = arr[i][1] + Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2]));
            maxDp[i][2] = arr[i][2] + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);

            minDp[i][0] = arr[i][0] + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = arr[i][1] + Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2]));
            minDp[i][2] = arr[i][2] + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }

        for (int i = 0; i < 3; i++) {
            maxResult = Math.max(maxResult, maxDp[num][i]);
            minResult = Math.min(minResult, minDp[num][i]);
        }

        System.out.println(maxResult + " " + minResult);
        br.close();
    }
}
