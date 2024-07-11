import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res, start, end;
    static List<List<int[]>> bridges = new ArrayList<>();
    static boolean[] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            bridges.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bridges.get(a).add(new int[]{b, weight});
            bridges.get(b).add(new int[]{a, weight});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        int left = 0, right = 1000000000;

        while(left <= right) {
            int mid = (left + right) / 2;
            visited = new boolean[N + 1];
            if(bfs(mid)) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static boolean bfs(int weight) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curNode = cur[0];

            if(curNode == end) {
                return true;
            }

            for(int[] next : bridges.get(curNode)) {
                int nextNode = next[0];
                int nextWeight = next[1];

                if(!visited[nextNode] && nextWeight >= weight) {
                    visited[nextNode] = true;
                    q.offer(new int[]{nextNode, nextWeight});
                }
            }
        }
        return false;
    }
}