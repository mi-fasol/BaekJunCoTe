import java.io.*;
import java.util.*;

public class Main {
    static int N, M, safeZone;
    static char[][] map;
    static boolean[][] visited, isChecked;
    static StringTokenizer st;
    static HashMap<Character, int[]> directions = new HashMap<>() {{
        put('U', new int[]{-1, 0});
        put('D', new int[]{1, 0});
        put('L', new int[]{0, -1});
        put('R', new int[]{0, 1});
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        isChecked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(safeZone);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        int[] direction = directions.get(map[x][y]);
        int nx = x + direction[0];
        int ny = y + direction[1];

        if (!visited[nx][ny]) {
            dfs(nx, ny);
        } else {
            if (!isChecked[nx][ny]) {
                safeZone++;
            }
        }
        isChecked[x][y] = true;
    }
}