import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(arr).sorted().toArray();

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(st.nextToken());
            int index = binarySearch(x);
            System.out.println(index);
        }
    }

    public static int binarySearch(int x){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == x){
                return 1;
            } else if(arr[mid] < x){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}