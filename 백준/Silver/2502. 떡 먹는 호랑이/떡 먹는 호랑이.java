import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        int[] dp = new int[num];

        for(int i = 1; i < total/2; i++){
            for(int j = i; j < total; j++){
                dp[0] = i;
                dp[1] = j;

                for(int k = 2; k < num; k++){
                    dp[k] = dp[k-1] + dp[k-2];
                }

                if(dp[num-1] == total){
                    System.out.println(dp[0]);
                    System.out.println(dp[1]);
                    System.exit(0);
                }
            }
        }
    }
}