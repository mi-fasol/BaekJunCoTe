import java.io.*;
import java.util.*;

public class Main {
    static int N, res;
    static String[] strs;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        strs = new String[N];

        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
            for(int j = 0; j < strs[i].length(); j++) {
                map.put(strs[i].charAt(j), (int) Math.pow(10, strs[i].length() - j - 1) + map.getOrDefault(strs[i].charAt(j), 0));
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));

        int num = 9;

        for(Character c : list) {
            res += map.get(c) * num--;
        }

        System.out.println(res);
    }
}