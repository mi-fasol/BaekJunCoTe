import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 1; j < N; j++) {
                for(int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1) continue;

                    if (k == 0) {
                        dp[nx][ny][0] += dp[i][j][0] + dp[i][j][2];
                    } else if (k == 1) {
                        dp[nx][ny][1] += dp[i][j][1] + dp[i][j][2];
                    } else {
                        if (map[i][j + 1] == 0 && map[i + 1][j] == 0) {
                            dp[nx][ny][2] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
                        }
                    }
                }
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}