import java.io.*;
import java.util.*;

public class Main {
    static int N, max = Integer.MIN_VALUE, startIdx = 1;
    static List<List<int[]>> list = new ArrayList<>();
    static StringTokenizer st;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());

            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                list.get(now).add(new int[]{node, weight});
            }
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(startIdx, 0);

        System.out.println(max);
    }

    public static void dfs(int start, int sum) {
        visited[start] = true;

        if(max < sum){
            max = sum;
            startIdx = start;
        }

        for (int[] i : list.get(start)) {
            int next = i[0];
            int weight = i[1];

            if (!visited[next]) {
                dfs(next, sum + weight);
            }
        }
    }
}