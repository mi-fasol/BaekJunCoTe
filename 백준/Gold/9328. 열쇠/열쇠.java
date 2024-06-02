import java.io.*;
import java.util.*;

public class Main {
    static int N, H, W, cnt, key;
    static char[][] map;
    static StringTokenizer st;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> lockedPlace = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H+2][W+2];
            visited = new int[H+2][W+2];

            for (int j = 0; j < H+2; j++) {
                Arrays.fill(map[j], '.');
                Arrays.fill(visited[j], -1);
            }

            for (int j = 1; j <= H; j++) {
                String line = br.readLine();
                for (int k = 1; k <= W; k++) {
                    map[j][k] = line.charAt(k - 1);
                }
            }

            key = 0;
            cnt = 0;

            String keys = br.readLine();
            for (int j = 0; j < keys.length(); j++) {
                if (keys.charAt(j) == '0') continue;
                key |= 1 << (keys.charAt(j) - 'a');
            }

            bfs(0, 0);

            while (!lockedPlace.isEmpty()) {
                int[] cur = lockedPlace.poll();
                if((key & 1 << (map[cur[0]][cur[1]] - 'A')) == 0) continue;
                bfs(cur[0], cur[1]);
            }

            System.out.println(cnt);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = key;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= H+2 || ny >= W+2) continue;
                if (visited[nx][ny] == key) continue;
                if(map[nx][ny] == '*') continue;

                if(map[nx][ny] == '$') {
                    cnt++;
                    map[nx][ny] = '.';
                    visited[nx][ny] = key;
                    q.offer(new int[]{nx, ny});
                } else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    key |= 1 << (map[nx][ny] - 'a');
                    map[nx][ny] = '.';
                    visited[nx][ny] = key;
                    q.offer(new int[]{nx, ny});
                } else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    if((key & 1 << (map[nx][ny] - 'A')) == 0){
                        lockedPlace.offer(new int[]{nx, ny});
                        continue;
                    }
                        map[nx][ny] = '.';
                        visited[nx][ny] = key;
                        q.offer(new int[]{nx, ny});
                } else{
                    visited[nx][ny] = key;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}