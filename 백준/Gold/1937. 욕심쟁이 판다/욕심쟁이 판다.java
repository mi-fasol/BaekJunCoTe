import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, result;

    static int[][] game, day;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(br.readLine());

        game = new int[n][n];
        day = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        bw.write(String.valueOf(result));

        bw.close();
        br.close();
    }

    public static int dfs(int x, int y) {

        if (day[x][y] != 0) {
            return day[x][y];
        }

        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fy < 0 || fx < 0 || fy >= n || fx >= n || game[fx][fy] <= game[x][y]) {
                continue;
            }
            cnt = Math.max(dfs(fx, fy) + 1, cnt);
            day[x][y] = cnt;
        }
        return cnt;
    }
}