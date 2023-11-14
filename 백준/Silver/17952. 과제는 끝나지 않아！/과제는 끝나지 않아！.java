import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> grade = new Stack<>();
        Stack<Integer> time = new Stack<>();

        int num = Integer.parseInt(br.readLine());
        int score = 0;

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '1') {
                int g = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if(t == 1){
                    score += g;
                } else{
                    grade.push(g);
                    time.push(t-1);
                }
            } else {
                if (!grade.isEmpty()) {
                    int sc = time.pop();
                    if (sc > 1) {
                        time.push(sc - 1);
                    } else{
                        score += grade.pop();
                    }
                }
            }
        }

        bw.write(Integer.toString(score));

        br.close();
        bw.close();
    }
}
