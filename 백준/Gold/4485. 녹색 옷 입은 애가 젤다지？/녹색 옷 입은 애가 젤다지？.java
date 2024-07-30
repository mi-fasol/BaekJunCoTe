import java.io.*;
import java.util.*;

public class Main {
    static int N, rupee, cnt = 1;
    static int[][] map;
    static int[] dist, dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            map = new int[N][N];
            dist = new int[N * N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();
            cnt++;
        }
    }

    public static void dijkstra(){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.offer(new int[]{0, 0, map[0][0]});
        dist[0] = map[0][0];

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], cost = now[2];

            if(dist[x * N + y] < cost) continue;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                int idx = nx * N + ny;

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(dist[idx] > cost + map[nx][ny]) {
                    dist[idx] = cost + map[nx][ny];
                    q.offer(new int[]{nx, ny, dist[idx]});
                }

                if(nx == N - 1 && ny == N - 1) {
                    rupee = dist[idx];
                    System.out.println("Problem " + cnt + ": " + rupee);
                    return;
                }
            }
        }
    }
}