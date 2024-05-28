import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] degree;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> questions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            questions.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            questions.get(a).add(b);
            degree[b]++;
        }

        solve();

        System.out.println(sb);
    }

    static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for (int next : questions.get(cur)) {
                degree[next]--;
                if (degree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
    }
}