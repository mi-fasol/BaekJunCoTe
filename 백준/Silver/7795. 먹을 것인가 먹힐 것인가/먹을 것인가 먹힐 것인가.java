import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] aArr = new int[n];
            int[] bArr = new int[m];

            StringTokenizer s = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                aArr[j] = Integer.parseInt(s.nextToken());
            }

            StringTokenizer t = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                bArr[j] = Integer.parseInt(t.nextToken());
            }

            Arrays.sort(bArr);

            int result = 0;

            for (int j = 0; j < n; j++) {
                int start = 0;
                int end = m - 1;
                int idx = 0;

                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (bArr[mid] < aArr[j]) {
                        start = mid + 1;
                        idx = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                result += idx;
            }
            System.out.println(result);
        }

        br.close();
    }
}