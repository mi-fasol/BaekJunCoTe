import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[][] selectedVirus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        if(checkZero(arr)){
            System.out.println(0);
            return;
        }

        selectedVirus = new int[M][2];
        selectVirus(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void selectVirus(int idx, int now){
        if(now == M){
            int res = bfs();
            if(res != -1){
                result = Math.min(result, res);
            }
            return;
        }

        for(int i = idx; i < virus.size(); i++){
            selectedVirus[now] = virus.get(i);
            selectVirus(i + 1, now+1);
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] copyArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            copyArr[i] = arr[i].clone();
        }

        for(int i = 0; i < M; i++){
            int x = selectedVirus[i][0];
            int y = selectedVirus[i][1];
            copyArr[x][y] = 2;
            visited[x][y] = true;
            q.offer(new int[]{x, y, 0});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(copyArr[nx][ny] != 1 && !visited[nx][ny]){
                        copyArr[nx][ny] = 2;
                        visited[nx][ny] = true;

                        if(checkZero(copyArr)){
                            return cnt + 1;
                        }

                        q.offer(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static boolean checkZero(int[][] copyArr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyArr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}