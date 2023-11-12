import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> line = new LinkedList<>();

        for(int i = 0; i < num;i++){
            line.add(Integer.parseInt(st.nextToken()));
        }

        int start = 1;

        while(!line.isEmpty()){
            if(line.peek() == start){
                line.poll();
                start++;
            } else if(!stack.isEmpty() && stack.peek() == start){
                stack.pop();
                start++;
            } else{
                stack.add(line.poll());
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek() == start){
                start++;
                stack.pop();
            } else{
                bw.write("Sad");
                bw.close();
                return;
            }
        }

        bw.write("Nice");

        br.close();
        bw.close();
    }
}
