import java.io.*;
import java.util.*;

public class Main {
    public static int N, NORMAL_AREA, BLIND_AREA;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static char[] area = {'R', 'G', 'B'};
    public static char[] blind_area = {'R', 'B'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == area[k]) {
                        bfs(i, j, area[k]);
                        NORMAL_AREA++;
                    }
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] &&(map[i][j] == blind_area[k])) {
                        bfs(i, j, blind_area[k]);
                        BLIND_AREA++;
                    }
                }
            }
        }

        System.out.println(NORMAL_AREA + " " + BLIND_AREA);
    }

    public static void bfs(int x, int y, char area) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] == area) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}