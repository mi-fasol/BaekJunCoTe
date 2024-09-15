import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[] order;
    static ArrayList<int[]> cctv = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if(now >= 1 && now <= 5) {
                    cctv.add(new int[]{i, j});
                }
            }
        }

        order = new int[cctv.size()];
        permutation(0, cctv.size());
        System.out.println(min);
    }

    public static void permutation(int depth, int r) {
        if(depth == r) {
            int[][] copyMap = new int[N][M];
            for(int i = 0; i < N; i++) {
                copyMap[i] = map[i].clone();
            }

            for(int i = 0; i < r; i++) {
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                int type = map[x][y];
                int dir = order[i];

                if(type == 1) {
                    watch(copyMap, x, y, dir);
                } else if(type == 2) {
                    watch(copyMap, x, y, dir);
                    watch(copyMap, x, y, (dir + 2) % 4);
                } else if(type == 3) {
                    watch(copyMap, x, y, dir);
                    watch(copyMap, x, y, (dir + 1) % 4);
                } else if(type == 4) {
                    watch(copyMap, x, y, dir);
                    watch(copyMap, x, y, (dir + 1) % 4);
                    watch(copyMap, x, y, (dir + 2) % 4);
                } else if(type == 5) {
                    watch(copyMap, x, y, dir);
                    watch(copyMap, x, y, (dir + 1) % 4);
                    watch(copyMap, x, y, (dir + 2) % 4);
                    watch(copyMap, x, y, (dir + 3) % 4);
                }
            }

            min = Math.min(min, getBlindSpot(copyMap));
            return;
        }

        for(int i = 0; i < 4; i++) {
            order[depth] = i;
            permutation(depth + 1, r);
        }
    }

    public static void watch(int[][] map, int x, int y, int dir) {
        if(dir == 0) {
            for(int i = x - 1; i >= 0; i--) {
                if(map[i][y] == 6) {
                    break;
                }
                map[i][y] = -1;
            }
        } else if(dir == 1) {
            for(int i = y + 1; i < M; i++) {
                if(map[x][i] == 6) {
                    break;
                }
                map[x][i] = -1;
            }
        } else if(dir == 2) {
            for(int i = x + 1; i < N; i++) {
                if(map[i][y] == 6) {
                    break;
                }
                map[i][y] = -1;
            }
        } else if(dir == 3) {
            for(int i = y - 1; i >= 0; i--) {
                if(map[x][i] == 6) {
                    break;
                }
                map[x][i] = -1;
            }
        }
    }

    public static int getBlindSpot(int[][] map) {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}