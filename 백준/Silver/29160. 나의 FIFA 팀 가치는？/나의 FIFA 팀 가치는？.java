import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] pq = new PriorityQueue[12];

        for (int i = 0; i <= 11; i++) {
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq[position].add(value);
        }

        int[] valueForPosition = new int[12];

        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= 11; j++) {
                if (!pq[j].isEmpty() && valueForPosition[j] < pq[j].peek()) {
                    pq[j].add(valueForPosition[j]);
                    valueForPosition[j] = pq[j].poll();
                }
            }

            for (int j = 1; j <= 11; j++) {
                valueForPosition[j] = Math.max(valueForPosition[j] - 1, 0);
            }

            for (int j = 1; j <= 11; j++) {
                if (!pq[j].isEmpty() && valueForPosition[j] < pq[j].peek()) {
                    pq[j].add(valueForPosition[j]);
                    valueForPosition[j] = pq[j].poll();
                }
            }
        }

        int result = Arrays.stream(valueForPosition).sum();

        System.out.println(result);
    }
}