import java.io.*;
import java.util.*;

public class Main {

    public static int[][] arr;
    public static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = arr[end][start] = 1;
        }
        sb = new StringBuilder();

        dfs(V);

        isVisited = new boolean[N+1];

        System.out.println(sb.toString());
        System.out.println(bfs(V));

    }

    public static String bfs(int start){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        isVisited[start] = true;

        while(!queue.isEmpty()){
            start = queue.poll();

            sb.append(start).append(" ");
            for(int i = 1; i<= N; i++){
                if(arr[start][i] == 1 && !isVisited[i]){
                    queue.offer(i);
                    isVisited[i] = true;
                }
            }
        }
        return sb.toString();
    }

    public static void dfs(int start){

        isVisited[start] = true;

        sb.append(start).append(" ");

        for(int i = 0; i<= N; i++){
            if(arr[start][i] == 1 && !isVisited[i]){
                dfs(i);
            }
        }
    }
}