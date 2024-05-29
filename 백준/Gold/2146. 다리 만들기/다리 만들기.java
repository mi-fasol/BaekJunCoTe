import java.io.*;
import java.util.*;

public class Main {
    static int N, islandNum = 2, min = Integer.MAX_VALUE, part = 2;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Node {
        int x, y, cnt, iNum;

        Node(int x, int y, int cnt, int iNum) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.iNum = iNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = islandNum;
                    findIsland(i, j);
                    islandNum++;
                }
            }
        }

        while (part <= islandNum) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -part) {
                        q.offer(new Node(i, j, 0, -part));
                        visited = new boolean[N][N];
                        bfs();
                        q.clear();
                    }
                }
            }
            part++;
        }

        System.out.println(min);
    }


    public static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;
            int iNum = now.iNum;

            if(min < cnt) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                if (map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cnt + 1, iNum));
                } else if (part != Math.abs(map[nx][ny]) && map[nx][ny] != 0) {
                    if(map[nx][ny] > 0 && cnt == 0){
                        min = 1;
                        return;
                    }
                    cnt += 2;
                    if(min < cnt) continue;
                    min = cnt;
                }
            }
        }
    }

    public static void findIsland(int x, int y) {
        Queue<int[]> island = new LinkedList<>();
        island.offer(new int[]{x, y});
        map[x][y] = islandNum;
        boolean[][] isVisited = new boolean[N][N];
        while (!island.isEmpty()) {
            int[] cur = island.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || isVisited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    isVisited[nx][ny] = true;
                    island.offer(new int[]{nx, ny});
                    map[nx][ny] = islandNum;
                } else if (map[nx][ny] == 0) {
                    map[nx][ny] = -islandNum;
                }
            }
        }
    }
}