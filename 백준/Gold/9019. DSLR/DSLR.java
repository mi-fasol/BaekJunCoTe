import java.io.*;
import java.util.*;

public class Main {
    static int T, A, B;
    static StringBuilder result = new StringBuilder();
    static boolean[] visited = new boolean[10000];
    static class Data {
        int num;
        String str;

        public Data(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(result);
            Arrays.fill(visited, false);
            result.setLength(0);
        }
    }

    public static void bfs() {
        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(A, ""));
        visited[A] = true;

        while(!q.isEmpty()) {
            Data now = q.poll();
            int num = now.num;
            String str = now.str;

            if(num == B) {
                result.append(str);
                return;
            }

            int D = (num * 2) % 10000;
            int S = num == 0 ? 9999 : num - 1;
            int L = (num % 1000) * 10 + num / 1000;
            int R = (num % 10) * 1000 + num / 10;

            if(!visited[D]) {
                visited[D] = true;
                q.offer(new Data(D, str + "D"));
            }
            if(!visited[S]) {
                visited[S] = true;
                q.offer(new Data(S, str + "S"));
            }
            if(!visited[L]) {
                visited[L] = true;
                q.offer(new Data(L, str + "L"));
            }
            if(!visited[R]) {
                visited[R] = true;
                q.offer(new Data(R, str + "R"));
            }
        }
    }
}