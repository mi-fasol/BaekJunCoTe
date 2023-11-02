import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        while (true) {
            int p = Integer.parseInt(br.readLine());
            if (p == -1) break;
            if (p == 0) {
                q.remove();
            } else if (num > q.size()) {
                q.add(p);
            }

        }

        if (!q.isEmpty()) {
            for (int i : q) {
                bw.write(i + " ");
            }
        } else {
            bw.write("empty");
        }

        br.close();
        bw.close();
    }
}