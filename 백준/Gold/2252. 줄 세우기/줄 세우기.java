import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] rank;
    static ArrayList<ArrayList<Integer>> students = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rank = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            students.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            students.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < students.get(i).size(); j++) {
                int next = students.get(i).get(j);
                rank[next]++;
            }
        }

        topologicalSort();
        System.out.println(sb);
    }

    public static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (rank[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int i = 0; i < students.get(cur).size(); i++) {
                int next = students.get(cur).get(i);
                rank[next]--;

                if (rank[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}