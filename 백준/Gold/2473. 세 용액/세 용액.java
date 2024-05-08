import java.io.*;
import java.util.*;

public class Main {
    static int N, startIdx, endIdx, extraIdx;
    static long SUM;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new long[N];

        SUM = Long.MAX_VALUE;

        for(int i = 0; i< N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);

        for(int i = 0; i < N-2;i++){
            int start = i+1;
            int end = N-1;
            while(start < end){
                long newSum = arr[start] + arr[end] + arr[i];

                if(Math.abs(newSum) < SUM){
                    SUM = Math.abs(newSum);
                    startIdx = start;
                    extraIdx = i;
                    endIdx = end;
                }

                if(newSum == 0){
                    startIdx = start;
                    endIdx = end;
                    extraIdx = i;
                    break;
                } else if(newSum > 0){
                    end--;
                } else{
                    start++;
                }
            }
        }

        long[] result = {arr[startIdx], arr[extraIdx], arr[endIdx]};
        Arrays.sort(result);

        for(int i = 0; i < 3; i++){
            System.out.print(result[i] + " ");
        }
    }
}