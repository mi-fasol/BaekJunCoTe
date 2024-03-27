import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        exit:
        for (int i = 0; i < s; i++) {
            for (int j = 1; j <= K; j++) {
                bfs(j);
                if (graph.get(x - 1).get(y - 1) != 0) break exit;
            }
        }

        System.out.println(graph.get(x - 1).get(y - 1));

        bw.close();
        br.close();
    }
    
    public static Queue<int[]> findKIndex(int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (graph.get(i).get(j) == n)
                    q.offer(new int[]{i, j});
            }

        return q;
    }

    public static void bfs(int n) {
        Queue<int[]> q = findKIndex(n);
        
        while (!q.isEmpty()) {
            int[] f = q.poll();
            int fx = f[0];
            int fy = f[1];

            if (fx != -1 && fy != -1) {

                for (int i = 0; i < 4; i++) {
                    int nx = fx + dx[i];
                    int ny = fy + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || graph.get(nx).get(ny) != 0) continue;
                    graph.get(nx).set(ny, n);
                }
            }
        }
    }
}