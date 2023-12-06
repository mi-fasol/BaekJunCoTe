import java.io.*;
import java.util.*;

public class Main {
    static int n, m, wr, sr, sCnt, wCnt;
    static boolean[][] isVisited;

    static char[][] game;


    static int[] dx = {0, -1, 0, 1 };
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        game = new char[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            game[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                if(game[i][j] == 'k') sr++;
                else if(game[i][j] == 'v') wr++;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(game[i][j] != '#' && !isVisited[i][j]){
                    wCnt = 0;
                    sCnt = 0;
                    dfs(i, j);

                    if(sCnt > wCnt) wr -= wCnt;
                    else sr -= sCnt;
                }
            }
        }

        System.out.println(sr + " " + wr);

        bw.close();
        br.close();
    }

    public static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if (game[y][x] == 'k') {
            sCnt++;
        } else if (game[y][x] == 'v'){
            wCnt++;
        }


        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fy <  0 || fx < 0 || fy >= n || fx >= m || isVisited[fy][fx] || game[fy][fx] == '#') {
                continue;
            }
            dfs(fy, fx);
        }
    }
}