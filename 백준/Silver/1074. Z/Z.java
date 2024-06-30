import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recur(0, 0, (int) Math.pow(2, N));
    }

    public static void recur(int x, int y, int size) {
        if (size == 1) {
            System.out.println(res);
            return;
        }

        int half = size / 2;
        int area = half * half;

        if (r < x + half && c < y + half) {
            recur(x, y, half);
        } else if (r < x + half && c >= y + half) {
            res += area;
            recur(x, y + half, half);
        } else if (r >= x + half && c < y + half) {
            res += area * 2;
            recur(x + half, y, half);
        } else {
            res += area * 3;
            recur(x + half, y + half, half);
        }
    }
}