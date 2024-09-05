import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<int[]>> network = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            network.get(A).add(new int[]{B, C});
            network.get(B).add(new int[]{A, C});
        }
        
        System.out.println(mst(1));
    }

    public static int mst(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        visited = new boolean[N + 1];
        int cost = 0;

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (visited[curNode]) continue;

            visited[curNode] = true;
            cost += curCost;

            for (int[] next : network.get(curNode)) {
                if (!visited[next[0]]) {
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }

        return cost;
    }
}