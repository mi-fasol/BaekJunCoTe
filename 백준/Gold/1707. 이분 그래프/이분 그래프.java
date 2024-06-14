import java.io.*;
import java.util.*;

public class Main {
    static int K, V, E;
    static List<List<Integer>> graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            visited = new int[V + 1];
            
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 1; j <= E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean flag = true;

            for(int j = 1; j <= V; j++){
                if(visited[j] == 0){
                    if(!bfs(j, 1)){
                        flag = false;
                        break;
                    }
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start, int color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = color;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next: graph.get(cur)){
                if(visited[next] == 0){
                    // 방문하지 않은 경우 현재 노드와 다른 색으로 방문
                    visited[next] = visited[cur] * -1;
                    q.offer(next);
                } else if(visited[next] == visited[cur]){
                    // 이미 방문한 경우 현재 노드와 색이 같다면 겹치는 경우, 이분 그래프가 아님
                    return false;
                }
            }
        }
        return true;
    }
}