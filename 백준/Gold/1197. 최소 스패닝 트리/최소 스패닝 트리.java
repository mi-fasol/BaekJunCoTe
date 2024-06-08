import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<int[]>> graph = new ArrayList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            parent[i] = i;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{a, b, w});
        }

        kruskal();
    }

    public static void kruskal() {
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (find(cur[0]) != find(cur[1])) {
                union(cur[0], cur[1]);
                sum += cur[2];
            }
        }

        System.out.println(sum);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }
}