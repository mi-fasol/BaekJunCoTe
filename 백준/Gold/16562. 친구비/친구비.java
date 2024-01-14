import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] money = new int[n+1];
        parents = new int[n+1];
        boolean[] isFriend = new boolean[n+1];

        for(int i = 1; i<=n;i++){
            parents[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v, w, money);
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if(parents[i] == i){
                sum += money[i];
            }
        }

        if (k < sum){
            System.out.println("Oh no");
        } else{
            System.out.println(sum);
        }
    }

    private static void union(int v, int w, int[] money){
        int rootV = find(v);
        int rootW = find(w);
        if(rootV != rootW){
            if(money[rootV] > money[rootW]){
                parents[rootV] = rootW;
            } else{
                parents[rootW] = rootV;
            }
        }
    }

    private static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}