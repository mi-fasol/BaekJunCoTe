import java.io.*;
import java.util.*;

public class Main {
    static int N, M, v2, v1, start = 1;
    static long v1Res = 0, v2Res = 0;
    static List<List<int[]>> graph = new ArrayList<>();
    static StringTokenizer st;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        v1Res += dijkstra(start, v1);
        v1Res += dijkstra(v1, v2);
        v1Res += dijkstra(v2, N);

        v2Res += dijkstra(start, v2);
        v2Res += dijkstra(v2, v1);
        v2Res += dijkstra(v1, N);

        if(v1Res >= Integer.MAX_VALUE && v2Res >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(v1Res, v2Res));
        }
    }

    public static int dijkstra(int s, int d) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new int[]{s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];

            if (dist[node] < dis) continue;

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextDist = dis + next[1];

                if (dist[nextNode] > nextDist) {
                    dist[nextNode] = nextDist;
                    pq.offer(new int[]{nextNode, nextDist});
                }
            }
        }
        return dist[d];
    }
}