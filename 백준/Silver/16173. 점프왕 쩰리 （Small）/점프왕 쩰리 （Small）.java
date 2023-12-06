import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] isVisited;

    static int[][] game;


    static int[] dx = {0, 1 };
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        game = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println("Hing");

        bw.close();
        br.close();
    }

    public static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if(game[y][x] == -1){
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int i = 0; i < 2; i++) {
            int fx = x + dx[i] * game[y][x];
            int fy = y + dy[i] * game[y][x];

            if (fy <  0 || fx < 0 || fy >= n || fx >= n || isVisited[fy][fx]) {
                continue;
            }
            dfs(fy, fx);
        }
    }
}