import java.io.*;
import java.util.*;

public class Main {
    static int N, maxNode;
    static List<List<int[]>> tree = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree.get(parent).add(new int[] {child, weight});
            tree.get(child).add(new int[] {parent, weight});
        }

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(1, 0);
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(maxNode, 0);

        System.out.println(dist[maxNode]);
    }

    public static void dfs(int node, int d) {
        visited[node] = true;
        dist[node] = d;

        if(dist[node] > dist[maxNode]) {
            maxNode = node;
        }

        for(int[] n : tree.get(node)) {
            if(!visited[n[0]]) {
                dfs(n[0], d + n[1]);
            }
        }
    }
}