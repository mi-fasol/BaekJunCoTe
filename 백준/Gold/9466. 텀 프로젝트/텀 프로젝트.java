import java.io.*;
import java.util.*;

public class Main {
    static int T, res;
    static int[] student;
    static boolean[] visited, isChecked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            student = new int[num + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[num + 1];
            isChecked = new boolean[num + 1];
            for (int j = 1; j <= num; j++) {
                dfs(j);
            }
            System.out.println(num - res);
            res = 0;
        }
    }

    public static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;

        if (!visited[student[start]]) {
            dfs(student[start]);
        } else {
            if (!isChecked[student[start]]) {
                res++;
                for (int i = student[start]; i != start; i = student[i]) {
                    res++;
                }
            }
        }

        isChecked[start] = true;
    }
}