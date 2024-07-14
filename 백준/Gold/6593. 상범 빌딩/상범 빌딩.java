import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static int[] start = new int[3], end = new int[3];
    static char[][][] building;
    static boolean[][][] visited;
    static StringTokenizer st;
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[R][C][L];
            visited = new boolean[R][C][L];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for(int k = 0; k < C; k++) {
                        building[j][k][i] = str.charAt(k);

                        if(building[j][k][i] == 'S') {
                            start[0] = j;
                            start[1] = k;
                            start[2] = i;
                        } else if(building[j][k][i] == 'E') {
                            end[0] = j;
                            end[1] = k;
                            end[2] = i;
                        }
                    }
                }

                br.readLine();
            }

            bfs();
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int floor = now[2];
            int cnt = now[3];

            if(x == end[0] && y == end[1] && floor == end[2]) {
                System.out.println("Escaped in " + cnt + " minute(s).");
                return;
            }

            for(int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nextFloor = floor + dz[i];

                if(nx < 0 || ny < 0 || nextFloor < 0 || nx >= R || ny >= C || nextFloor >= L || visited[nx][ny][nextFloor] || building[nx][ny][nextFloor] == '#') {
                    continue;
                }

                visited[nx][ny][nextFloor] = true;
                q.offer(new int[]{nx, ny, nextFloor, cnt + 1});
            }
        }

        System.out.println("Trapped!");
    }
}