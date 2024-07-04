import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0, "");

        System.out.println(sb);

    }

    public static void dfs(int idx, int cnt, String str) {
        if(cnt == L) {
            int vowel = 0, consonant = 0;
            for(int i = 0; i < L; i++) {
                if(vowels.contains(str.charAt(i))) vowel++;
                else consonant++;
            }
            if(vowel >= 1 && consonant >= 2) {
                sb.append(str).append("\n");
            }
            return;
        }

        for(int i = idx; i < C; i++) {
            dfs(i + 1, cnt + 1, str + arr[i]);
        }
    }
}