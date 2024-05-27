import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<List<int[]>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }

        dist[K] = 0;

        daikstra();

        for(int i = 1; i <= V; i++){
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    public static void daikstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (dist[cur[0]] < cur[1]) continue;

            for (int[] next : graph.get(cur[0])) {
                int newDist = cur[1] + next[1];

                if (newDist < dist[next[0]]) {
                    dist[next[0]] = newDist;
                    pq.offer(new int[]{next[0], newDist});
                }
            }
        }
    }
}