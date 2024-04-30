import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        visited[0][0][0] = true;

        int count = 0;

        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                int x = node.x;
                int y = node.y;
                int wallCnt = node.wallCnt;

                if (x == N - 1 && y == M - 1) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (graph[nx][ny] == 1 && wallCnt == 1) {
                        visited[nx][ny][1] = true;
                        q.offer(new Node(nx, ny, 0));
                    } else if (graph[nx][ny] == 0 && !visited[nx][ny][wallCnt]) {
                        visited[nx][ny][wallCnt] = true;
                        q.offer(new Node(nx, ny, wallCnt));
                    }
                }
            }
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int wallCnt;

    public Node(int x, int y, int wallCnt) {
        this.x = x;
        this.y = y;
        this.wallCnt = wallCnt;
    }
}