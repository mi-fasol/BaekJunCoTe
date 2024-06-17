import java.io.*;

public class Main {
    static int Queen, res;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queen = Integer.parseInt(br.readLine());
        map = new int[Queen][Queen];

        for (int i = 0; i < Queen; i++) {
            map[0][i] = 1;
            bruteForce(0, i, 1);
            map[0][i] = 0;
        }

        System.out.println(res);

    }

    static void bruteForce(int x, int y, int cnt) {
        if(cnt == Queen) {
            res++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while(nx >= 0 && ny >= 0 && nx < Queen && ny < Queen) {
                map[nx][ny]++;
                nx += dx[i];
                ny += dy[i];
            }
        }

        for (int i = 0; i < Queen; i++) {
            if(map[x+1][i] == 0) {
                map[x+1][i] = 1;
                bruteForce(x+1, i, cnt+1);
                map[x+1][i] = 0;
            }
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while(nx >= 0 && ny >= 0 && nx < Queen && ny < Queen) {
                map[nx][ny]--;
                nx += dx[i];
                ny += dy[i];
            }
        }
    }
}