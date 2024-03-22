import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static boolean[] isVisited;

    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = arr[end][start] = 1;
        }

        System.out.println(bfs(1));

    }

    public static int bfs(int start) {
        int cnt = 0;

        isVisited[start] = true;

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int index = q.poll();

            for (int i = 1; i <= N; i++) {
                if (arr[index][i] == 1 && !isVisited[i]) {
                    q.offer(i);
                    isVisited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}