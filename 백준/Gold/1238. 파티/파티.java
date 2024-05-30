import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<List<int[]>> list = new ArrayList<>();
    static int[] studentDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        studentDist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[]{end, time});
        }

        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            studentDist[i] = dijkstra(i, X);
            studentDist[i] += dijkstra(X, i);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, studentDist[i]);
        }

        System.out.println(max);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (dist[curNode] < curDist) continue;

            for (int[] arr : list.get(curNode)) {
                int nextNode = arr[0];
                int nextDist = arr[1] + curDist;

                if (dist[nextNode] > nextDist) {
                    dist[nextNode] = nextDist;
                    pq.offer(new int[]{nextNode, nextDist});
                }
            }
        }
        return dist[end];
    }
}