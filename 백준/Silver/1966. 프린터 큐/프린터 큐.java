import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int want = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();

            for (int j = 0; j < num; j++) {
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            while (!q.isEmpty()) {
                int[] now = q.poll();
                boolean flag = true;

                for (int[] tmp : q) {
                    if (tmp[1] > now[1]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    if (now[0] == want) {
                        System.out.println(num - q.size());
                        break;
                    }
                } else {
                    q.offer(now);
                }
            }
        }
    }
}