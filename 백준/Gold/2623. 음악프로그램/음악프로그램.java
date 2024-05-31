import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] edgeCnt;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeCnt = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num-1; j++) {
                int next = Integer.parseInt(st.nextToken());
                list.get(prev).add(next);
                edgeCnt[next]++;
                prev = next;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(edgeCnt[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            for(int next : list.get(now)){
                edgeCnt[next]--;
                if(edgeCnt[next] == 0){
                    q.offer(next);
                }
            }
        }

        if(result.size() != N){
            System.out.println(0);
        } else {
            for(int i : result){
                System.out.println(i);
            }
        }
    }
}