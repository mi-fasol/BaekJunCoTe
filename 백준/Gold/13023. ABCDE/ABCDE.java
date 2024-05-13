import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res;
    static ArrayList<ArrayList<Integer>> friend;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friend = new ArrayList<>();

        for(int i = 0; i < N; i++){
            friend.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend.get(a).add(b);
            friend.get(b).add(a);
        }

        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            dfs(i, 0);
            if(res == 1) break;
        }

        System.out.println(res);
    }

    public static void dfs(int idx, int cnt){
        if(cnt == 4){
            for(int i = 0; i < friend.get(idx).size(); i++){
                if(!visited[friend.get(idx).get(i)]){
                    res = 1;
                    return;
                }
            }
            return;
        }

        for(int i : friend.get(idx)) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }
}