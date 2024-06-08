import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    static List<List<int[]>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, w});
            graph.get(b).add(new int[]{a, w});
        }

        System.out.println(prim());
    }

    public static int prim() {
        int result = 0;
        pq.offer(new int[]{1, 1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (visited[cur[1]]) continue;

            visited[cur[1]] = true;
            result += cur[2];

            for (int[] next : graph.get(cur[1])) {
                if (!visited[next[0]]) {
                    pq.offer(new int[]{cur[1], next[0], next[1]});
                }
            }
        }

        return result;
    }
}