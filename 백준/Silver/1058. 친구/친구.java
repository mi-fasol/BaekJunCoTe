import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MAX_VALUE >> 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            String st = br.readLine();
            for (int j = 1; j <= n; j++){
                if(st.charAt(j-1) == 'Y')
                    arr[i][j] = 1;
                else if (i != j)
                    arr[i][j] = max;
            }
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <=n; j++){
                    if(i==j || j == k || i == k)
                        continue;
                    else
                        if(arr[i][j] > arr[i][k] + arr[k][j])
                            arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int result = 0;

        for(int i = 1; i<=n; i++){
            int cnt = 0;

            for(int j=1; j <= n; j++){
                if (i==j)
                    continue;
                else if (arr[i][j] <= 2)
                    cnt++;
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);

    }
}