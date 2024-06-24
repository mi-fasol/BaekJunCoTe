import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res = Integer.MAX_VALUE, rx, ry, bx, by;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][][] visited = new boolean[10][10][10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        bfs();

        if (res > 10) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0];
            int cry = cur[1];
            int cbx = cur[2];
            int cby = cur[3];
            int cnt = cur[4];

            if(cnt > 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nrx = crx;
                int nry = cry;
                int nbx = cbx;
                int nby = cby;

                while(map[nrx][nry] != '#' && map[nrx][nry] != 'O') {
                    nrx += dx[i];
                    nry += dy[i];
                }

                while(map[nbx][nby] != '#' && map[nbx][nby] != 'O') {
                    nbx += dx[i];
                    nby += dy[i];
                }

                if(map[nrx][nry] == '#') {
                    nrx -= dx[i];
                    nry -= dy[i];
                }

                if(map[nbx][nby] == '#') {
                    nbx -= dx[i];
                    nby -= dy[i];
                }

                if(map[nbx][nby] == 'O') {
                    continue;
                }

                if(map[nrx][nry] == 'O') {
                    res = cnt + 1;
                    return;
                }

                if(nrx == nbx && nry == nby) {
                    int rDist = Math.abs(nrx - crx) + Math.abs(nry - cry);
                    int bDist = Math.abs(nbx - cbx) + Math.abs(nby - cby);
                    
                    if(rDist > bDist) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }
                
                if(!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new int[]{nrx, nry, nbx, nby, cnt + 1});
                }
            }
        }
    }
}