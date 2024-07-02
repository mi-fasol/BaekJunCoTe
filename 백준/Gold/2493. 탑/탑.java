import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new int[N];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(i == 0) {
                stack.add(new int[]{i + 1, num});
                continue;
            }
            
            while(!stack.isEmpty()) {
                if(stack.peek()[1] > num) {
                    answer[i] = stack.peek()[0];
                    break;
                } else {
                    stack.pop();
                }
            }

            stack.add(new int[]{i + 1, num});
        }

        for(int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}