import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static HashMap<String, Integer> people;
    static int[] parent;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            people = new HashMap<>();
            parent = new int[1000001];
            cnt = new int[1000001];

            int idx = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String name2 = st.nextToken();

                if (!people.containsKey(name)) {
                    people.put(name, idx);
                    parent[idx] = idx;
                    cnt[idx++] = 1;
                }
                if (!people.containsKey(name2)) {
                    people.put(name2, idx);
                    parent[idx] = idx;
                    cnt[idx++] = 1;
                }

                union(people.get(name), people.get(name2));
                System.out.println(cnt[find(people.get(name))]);
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (a < b) {
            parent[b] = a;
            cnt[a] += cnt[b];
        } else {
            parent[a] = b;
            cnt[b] += cnt[a];
        }
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}