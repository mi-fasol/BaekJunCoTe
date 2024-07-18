import java.io.*;
import java.util.*;

public class Main {
    static int N, Q, iceSum, area, size;
    static int[][] map;
    static ArrayList<Integer> step = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        size = 1 << N;

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            step.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < Q; i++) {
            int L = step.get(i);
            L = 1 << L;

            rotate(L);
            melt();
        }

        iceSum = 0;
        area = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                iceSum += map[i][j];
            }
        }

        boolean[][] visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                }
            }
        }

        System.out.println(iceSum);
        System.out.println(area);
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt++;
            }
        }

        area = Math.max(area, cnt);
    }

    static void rotate(int L) {
        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i += L) {
            for (int j = 0; j < size; j += L) {
                for (int x = 0; x < L; x++) {
                    for (int y = 0; y < L; y++) {
                        temp[i + y][j + L - 1 - x] = map[i + x][j + y];
                    }
                }
            }
        }

        map = temp;
    }

    static void melt() {
        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int cnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                    if (map[nx][ny] == 0) continue;

                    cnt++;
                }

                if (cnt < 3) {
                    temp[i][j] = Math.max(map[i][j] - 1, 0);
                } else {
                    temp[i][j] = map[i][j];
                }
            }
        }
        map = temp;
    }
}