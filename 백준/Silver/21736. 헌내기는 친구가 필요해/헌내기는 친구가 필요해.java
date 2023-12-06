import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[][] isVisited;

    static char[][] campus;

    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        campus = new char[n][m];
        isVisited = new boolean[n][m];

        int dX = 0;
        int dY = 0;


        for (int i = 0; i < n; i++) {
            campus[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (campus[i][j] == 'I') {
                    dY = i;
                    dX = j;
                }
            }
        }

        dfs(dY, dX);

        if (result == 0) {
            bw.write("TT");
        } else {
            System.out.println(result);
        }

        bw.close();
        br.close();
    }

    public static void dfs(int y, int x) {
        isVisited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fy <  0 || fx < 0 || fy >= n || fx >= m || isVisited[fy][fx] || campus[fy][fx] == 'X') {
                continue;
            }
            if(campus[fy][fx] == 'P') result++;
            dfs(fy, fx);
        }
    }
}