import java.io.*;
import java.util.*;

public class Main {
    static int N, BUS;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        BUS = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= BUS; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start][end] = graph[start][end] == 0 ? cost : Math.min(graph[start][end], cost);
        }

        findMinCost();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findMinCost() {
        // 경유지
        for (int k = 1; k <= N; k++) {
            // 츨빌지
            for (int i = 1; i <= N; i++) {
                if (k == i) continue;
                // 도착지
                for (int j = 1; j <= N; j++) {
                    if (j == i) continue;
                    if(graph[i][k] != 0 && graph[k][j] != 0){
                        if(graph[i][j] != 0){
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        } else{
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }
                    }
                }
            }
        }
    }
}