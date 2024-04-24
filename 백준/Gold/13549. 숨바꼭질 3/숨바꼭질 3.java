import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dx = {-1, 1};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[100001];

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
    }

    public static void bfs(int n){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        visited[n] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int cnt = now[1];

            if(x == K){
                System.out.println(cnt);
                return;
            }

            for(int i = 0; i < 3; i++){
                int nx;
                int count = cnt;
                if(i == 0){
                    nx = x *2;
                } else{
                    nx = x + dx[i-1];
                    count++;
                }

                if(nx >= 0 && nx < 100001 && !visited[nx]){
                    visited[nx] = true;
                    q.offer(new int[]{nx, count});
                }
            }
        }
    }
}