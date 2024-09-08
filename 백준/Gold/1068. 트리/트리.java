import java.io.*;
import java.util.*;

public class Main {
    static int N, deletedNode, leafNodeCnt = 0, rootNode;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                rootNode = i;
                continue;
            }
            tree.get(parent).add(i);
        }

        deletedNode = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        if(deletedNode == rootNode) {
            System.out.println(0);
            return;
        }

        dfs(rootNode);

        System.out.println(leafNodeCnt);
    }

    public static void dfs(int node) {
        visited[node] = true;

        if(tree.get(node).size() == 0) {
            leafNodeCnt++;
            return;
        }

        for(int next : tree.get(node)) {
            if(next == deletedNode) {
                if(tree.get(node).size() == 1) {
                    leafNodeCnt++;
                }
                continue;
            }
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}