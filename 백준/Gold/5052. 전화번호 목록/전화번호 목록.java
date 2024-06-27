import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new String[N];
            boolean flag = false;

            for (int j = 0; j < N; j++) {
                arr[j] = br.readLine();

            }
            
            Arrays.sort(arr);
            
            for (int j = 0; j < N - 1; j++) {
                if (arr[j + 1].startsWith(arr[j])) {
                    flag = true;
                    break;
                }
            }
            
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}