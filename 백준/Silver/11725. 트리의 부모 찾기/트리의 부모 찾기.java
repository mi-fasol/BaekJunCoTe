import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge.get(a).add(b);
            edge.get(b).add(a);
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.close();
        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int node : edge.get(x)) {
                if (!visited[node]) {
                    visited[node] = true;
                    parent[node] = x;
                    q.offer(node);
                }
            }
        }
    }
}