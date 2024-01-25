import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MAX_VALUE >> 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(arr[i], max);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if((arr[i][j] == max && i != j) || arr[i][j] > 6){
                    System.out.println("Big World!");
                    return;
                }
            }
        }
        System.out.println("Small World!");
    }
}