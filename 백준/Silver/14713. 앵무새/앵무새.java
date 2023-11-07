import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        Queue<String>[] q = new LinkedList[num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            q[i] = new LinkedList<>();
            for (int j = 0; st.hasMoreTokens(); j++) {
                q[i].add(st.nextToken());
            }
        }

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        Queue<String> test = new LinkedList<>();
        for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
            test.add(stringTokenizer.nextToken());
        }

        boolean isPossible = true; // 기본적으로 가능한 상태로 초기화

        while (!test.isEmpty()) {
            String word = test.poll();
            boolean isChecked = false;

            for (int i = 0; i < num; i++) {
                if (word.equals(q[i].peek())) {
                    q[i].poll();
                    isChecked = true;
                }
            }

            if (!isChecked) {
                isPossible = false;
                break;
            }
        }

        for (int i = 0; i < num; i++) {
            if (!q[i].isEmpty()) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            bw.write("Possible");
        } else {
            bw.write("Impossible");
        }

        br.close();
        bw.close();
    }
}
