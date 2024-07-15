import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static boolean[][] isConnected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isConnected = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isConnected[a][b] = true;
        }

        floydWarshall();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (isConnected[i][j] || isConnected[j][i]) {
                    count++;
                }
            }
            if (count == N - 1) cnt++;
        }

        System.out.println(cnt);
    }

    public static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (isConnected[i][k] && isConnected[k][j]) {
                        isConnected[i][j] = true;
                    }
                }
            }
        }
    }
}