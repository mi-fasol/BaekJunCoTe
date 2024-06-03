import java.io.*;
import java.util.*;

public class Main {
    static int N, K, min;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        scores = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = Arrays.stream(scores).sum();

        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;
            int sum = 0;

            for(int i = 0; i < N; i++){
                sum += scores[i];
                if(sum >= mid){
                    cnt++;
                    sum = 0;
                }
            }

            if(cnt >= K){
                min = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(min);
    }
}