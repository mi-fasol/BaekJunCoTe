import java.io.*;
import java.util.*;

public class Main {
    static int N, M, F, startX, startY;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static List<int[]> customer = new ArrayList<>();
    static ArrayList<Customer> list = new ArrayList<>();

    static class Customer {
        int x, y, dist;

        public Customer(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int destX = Integer.parseInt(st.nextToken()) - 1;
            int destY = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 2;
            customer.add(new int[]{x, y, destX, destY});
        }

        while (!customer.isEmpty()) {
            int dist = bfs();

            if (dist == -1) {
                System.out.println(-1);
                break;
            }

            F -= dist;

            Customer cus = list.get(0);
            int sx = cus.x;
            int sy = cus.y;

            int[] dest = findCustomer(sx, sy);
            if(dest == null) {
                System.out.println(-1);
                break;
            }
            int idx = customer.indexOf(dest);
            int destX = dest[2];
            int destY = dest[3];

            if (map[destX][destY] == 1) {
                System.out.println(-1);
                break;
            }

            int result = drive(sx, sy, destX, destY);
            if (result == -1) {
                System.out.println(-1);
                break;
            }

            if(F < result) {
                System.out.println(-1);
                break;
            }

            startX = destX;
            startY = destY;

            F += result;

            map[sx][sy] = 0;

            list.remove(0);
            customer.remove(idx);

            if (list.isEmpty() && customer.isEmpty()) {
                System.out.println(F);
                break;
            }
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited = new boolean[N][N];
        visited[startX][startY] = true;

        list = new ArrayList<>();

        if (map[startX][startY] == 2) {
            list.add(new Customer(startX, startY, 0));
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (cnt == F && list.isEmpty())
                return -1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1 || visited[nx][ny]) continue;

                if (map[nx][ny] == 2) {
                    list.add(new Customer(nx, ny, cnt + 1));
                }

                q.add(new int[]{nx, ny, cnt + 1});
                visited[nx][ny] = true;
            }
        }

        if (list.isEmpty()) return -1;

        list.sort((o1, o2) -> {
            if (o1.dist == o2.dist) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
            return o1.dist - o2.dist;
        });

        Customer c = list.get(0);
        map[c.x][c.y] = 0;
        return c.dist;
    }

    public static int drive(int x, int y, int destX, int destY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited = new boolean[N][N];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if (cx == destX && cy == destY && cnt <= F) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1 || visited[nx][ny]) continue;

                q.add(new int[]{nx, ny, cnt + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    public static int[] findCustomer(int x, int y) {
        for (int[] c : customer) {
            if (c[0] == x && c[1] == y) {
                return c;
            }
        }
        return null;
    }
}