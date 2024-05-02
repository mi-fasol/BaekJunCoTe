import java.io.*;
import java.util.*;

public class Main {
    static int N, start, end, HIGHEST, LOWEST, FATIGUE, HOME_CNT;
    static char[][] graph;
    static int[][] altitude;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    static List<Integer> altitudeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new char[N][N];
        altitude = new int[N][N];
        HIGHEST = 0;
        LOWEST = Integer.MAX_VALUE;
        altitudeList = new ArrayList<>();
        FATIGUE = Integer.MAX_VALUE;

        int postmanX = 0;
        int postmanY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                if (c == 'P') {
                    postmanX = i;
                    postmanY = j;
                } else if (c == 'K') {
                    HOME_CNT++;
                }
                graph[i][j] = c;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int alt = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 'P' || graph[i][j] == 'K') {
                    HIGHEST = Math.max(HIGHEST, alt);
                    LOWEST = Math.min(LOWEST, alt);
                }
                altitude[i][j] = alt;
                if (!altitudeList.contains(alt))
                    altitudeList.add(alt);
            }
        }

        Collections.sort(altitudeList);
        start = 0;
        end = altitudeList.indexOf(HIGHEST);

        while (start <= end && end < altitudeList.size() && start <= altitudeList.indexOf(LOWEST)) {
            int startAlt = altitudeList.get(start);
            int endAlt = altitudeList.get(end);
            if (bfs(postmanX, postmanY, startAlt, endAlt)) {
                FATIGUE = Math.min(FATIGUE, endAlt - startAlt);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(FATIGUE);
    }

    public static boolean bfs(int x, int y, int startAlt, int endAlt) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int destinations = HOME_CNT;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (destinations == 0) return true;

            for (int j = 0; j < 8; j++) {
                int nx = curX + dx[j];
                int ny = curY + dy[j];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                if (altitude[nx][ny] < startAlt || altitude[nx][ny] > endAlt)
                    continue;

                visited[nx][ny] = true;

                if (graph[nx][ny] == 'K') {
                    destinations--;
                }
                queue.offer(new int[]{nx, ny});
            }
        }
        return false;
    }
}