import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MAX_VALUE >> 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <=n; j++){
                        if(arr[i][k] == 1 && arr[k][j] == 1)
                            arr[i][j] = 1;
                }
            }
        }

        for(int i = 1; i<=n; i++){
            for(int j=1; j <= n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}