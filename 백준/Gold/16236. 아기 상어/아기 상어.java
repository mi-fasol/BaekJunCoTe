import java.io.*;
import java.util.*;

public class Main {

    static int N, CNT, sharkX, sharkY, sharkSize, sharkEatCnt;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static class Fish {
        int x, y, dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    sharkX = i;
                    sharkY = j;
                    sharkSize = 2;
                }
            }
        }

        if(!canSwim()){
            System.out.println(0);
            return;
        }

        while (canEatMore()) {
            visited = new boolean[N][N];
            int result = bfs();
            if(result == 0) break;
            else CNT += result;
        }

        System.out.println(CNT);

    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;
        ArrayList<Fish> fishList = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt + 1});
                if(map[nx][ny] != 0 && map[nx][ny] < sharkSize){
                    fishList.add(new Fish(nx, ny, cnt + 1));
                }
            }
        }

        Collections.sort(fishList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.dist == o2.dist){
                    if(o1.x == o2.x){
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
                return o1.dist - o2.dist;
            }
        });
        if(!fishList.isEmpty()){
            Fish fish = fishList.get(0);
            sharkX = fish.x;
            sharkY = fish.y;
            map[sharkX][sharkY] = 0;
            sharkEatCnt++;
            if(sharkEatCnt == sharkSize){
                sharkSize++;
                sharkEatCnt = 0;
            }
            return fish.dist;
        }
        return 0;
    }

    public static boolean canEatMore() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < sharkSize && map[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canSwim() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < sharkSize && map[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}