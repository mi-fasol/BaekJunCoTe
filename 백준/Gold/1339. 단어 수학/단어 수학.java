import java.io.*;
import java.util.*;

public class Main {
    static int N, res;
    static String[] strs;
    static boolean[] visited = new boolean[10];
    static HashMap<Character, Integer> map = new HashMap<>();
    static ArrayList<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        strs = new String[N];

        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
            for(int j = 0; j < strs[i].length(); j++) {
                if(!list.contains(strs[i].charAt(j))) {
                    list.add(strs[i].charAt(j));
                }
            }
        }

        combination(0);

        System.out.println(res);

    }

    public static void combination(int idx) {
        if(idx == list.size()) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = 0;
                for (int j = 0; j < strs[i].length(); j++) {
                    num = num * 10 + map.get(strs[i].charAt(j));
                }
                sum += num;
            }
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            map.put(list.get(idx), i);
            combination(idx + 1);
            visited[i] = false;
        }
    }
}