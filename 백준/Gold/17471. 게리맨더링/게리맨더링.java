import java.io.*;
import java.util.*;

public class Main {
    static int N, gap = Integer.MAX_VALUE;
    static int[] person;
    static boolean[] visited, isContained;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> area1, area2;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        person = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            combination(1, i);
        }

        System.out.println(gap == Integer.MAX_VALUE ? -1 : gap);
    }

    public static void combination(int start, int cnt) {
        if (cnt == 0) {
            area1 = new ArrayList<>();
            area2 = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (visited[i]) area1.add(i);
                else area2.add(i);
            }

            if (isConnected()) {
                int sum1 = 0, sum2 = 0;
                for (int a1 : area1) {
                    sum1 += person[a1];
                }

                for (int a2 : area2) {
                    sum2 += person[a2];
                }

                gap = Math.min(gap, Math.abs(sum1 - sum2));
            }
        } else {
            for (int i = start; i <= N; i++) {
                visited[i] = true;
                combination(i + 1, cnt - 1);
                visited[i] = false;
            }
        }
    }

    public static void dfs(int now, ArrayList<Integer> list) {
        for (int next : graph.get(now)) {
            if (!isContained[next] && list.contains(next)) {
                isContained[next] = true;
                dfs(next, list);
            }
        }
    }

    public static boolean isConnected() {
        isContained = new boolean[N + 1];

        isContained[area1.get(0)] = true;
        isContained[area2.get(0)] = true;
        dfs(area1.get(0), area1);
        dfs(area2.get(0), area2);

        for (int i = 1; i <= N; i++) {
            if (!isContained[i]) return false;
        }

        return true;
    }
}