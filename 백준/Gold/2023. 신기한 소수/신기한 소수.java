import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] prime = {2, 3, 5, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 4; i++) {
            dfs(1, prime[i]);
        }

        System.out.println(sb);
    }

    public static void dfs(int len, int num) {
        if (len == N) {
            sb.append(num).append('\n');
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int nextNum = num * 10 + i;
            if (isPrime(nextNum)) {
                dfs(len + 1, nextNum);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}