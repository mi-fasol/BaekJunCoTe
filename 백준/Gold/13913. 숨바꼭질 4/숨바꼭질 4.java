import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    private static int n, k;
    private static int[] time, visited;
    private static int dx[] = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        time = new int[100001];
        visited = new int[100001];

        bfs();

        System.out.println(time[k]);

        int now = k;

        Stack<Integer> stack = new Stack<>();

        while (now != n) {
            stack.add(now);
            now = visited[now];
        }

        stack.add(now);

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.close();
        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        time[n] = 0;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            if (q == k) return;

            int nx;
            for (int i = 0; i < 3; i++) {
                if (i == 2)
                    nx = q * dx[i];
                else
                    nx = q + dx[i];

                if (nx >= 0 && nx <= 100000 && time[nx] == 0) {
                    time[nx] = time[q] + 1;
                    visited[nx] = q;
                    queue.add(nx);
                }
            }
        }
    }
}